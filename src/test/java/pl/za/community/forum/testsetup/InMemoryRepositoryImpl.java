package pl.za.community.forum.testsetup;

import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import jakarta.persistence.LockModeType;
import org.instancio.Instancio;
import org.instancio.Select;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.util.ReflectionTestUtils;
import pl.za.community.forum.domainblocks.DomainEntity;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class InMemoryRepositoryImpl<T extends DomainEntity<ID>, ID extends Serializable>
        implements BaseJpaRepository<T, ID> {
    final Map<ID, T> map;

    public InMemoryRepositoryImpl() {
        map = new HashMap<>();
    }

    private T get(ID id) {
        return map.get(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return get(id) != null;
    }

    @Override
    public T getReferenceById(ID id) {
        return get(id);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        var idSet = new HashSet<>();
        ids.forEach(idSet::add);
        return map.entrySet().stream()
                .filter(entry -> idSet.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public long count() {
        return map.size();
    }

    @Override
    public void delete(T entity) {
        map.remove(entity.getId());
    }

    @Override
    public void deleteAllInBatch(Iterable<T> entities) {
        entities.forEach(entity -> map.remove(entity.getId()));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<ID> ids) {
        ids.forEach(map::remove);
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends T> S persist(S entity) {
        assertThat(map.containsValue(entity)).isFalse();
        var key = entity.getId() == null // we could check the generation type
                ? generateKey() // if generation type is none, we should fail here
                : entity.getId();
        ReflectionTestUtils.setField(entity, "id", key);
        map.put(key, entity);
        return entity;
    }

    protected abstract Class<ID> getKeyType();

    @SuppressWarnings("unchecked")
    protected ID generateKey() {
        return Instancio.of(getKeyType())
                .filter(Select.root(), key -> !map.containsKey((ID) key))
                .create();
    }

    @Override
    public <S extends T> S persistAndFlush(S entity) {
        return persist(entity);
    }

    @Override
    public <S extends T> List<S> persistAll(Iterable<S> entities) {
        return doForEntities(entities, this::persist);
    }

    @NotNull
    private static <T extends DomainEntity<ID>, ID extends Serializable, S extends T> List<S> doForEntities(Iterable<S> entities, Consumer<S> operation) {
        entities.forEach(operation);
        if (entities instanceof List<S> entityList)
            return entityList;

        var entityList = new ArrayList<S>();
        entities.forEach(entityList::add);
        return entityList;
    }

    @Override
    public <S extends T> List<S> persistAllAndFlush(Iterable<S> entities) {
        return persistAll(entities);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S extends T> S merge(S entity) {
        assertThat(get(entity.getId())).isNotNull();
        return (S) map.put(entity.getId(), entity);
    }

    @Override
    public <S extends T> S mergeAndFlush(S entity) {
        return merge(entity);
    }

    @Override
    public <S extends T> List<S> mergeAll(Iterable<S> entities) {
        return doForEntities(entities, this::merge);
    }

    @Override
    public <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities) {
        return mergeAll(entities);
    }

    @Override
    public <S extends T> S update(S entity) {
        return merge(entity);
    }

    @Override
    public <S extends T> S updateAndFlush(S entity) {
        return update(entity);
    }

    @Override
    public <S extends T> List<S> updateAll(Iterable<S> entities) {
        return doForEntities(entities, this::update);
    }

    @Override
    public <S extends T> List<S> updateAllAndFlush(Iterable<S> entities) {
        return updateAll(entities);
    }

    @Override
    public T lockById(ID id, LockModeType lockMode) {
        return null;
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends T> Iterable<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> Iterable<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
