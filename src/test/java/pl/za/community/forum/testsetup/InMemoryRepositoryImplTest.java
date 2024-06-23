package pl.za.community.forum.testsetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.za.community.forum.domainblocks.DomainEntity;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryRepositoryImplTest {

    private SampleRepositoryImpl repository;

    @BeforeEach
    void beforeEach() {
        this.repository = new SampleRepositoryImpl();
    }

    @Disabled("I don't want to add cloning")
    @Test
    void changesMadePostPersistShouldNotBeAffectingPersistedInstances() {

        var sampleEntity = new Sample(1, "foo");
        sampleEntity = repository.persist(sampleEntity);

        sampleEntity.setField("bar");
        var sampleEntityFromDb = repository.findById(sampleEntity.getId()).get();

        assertThat(sampleEntityFromDb.getField()).isEqualTo("foo");
    }

    private static class SampleRepositoryImpl extends InMemoryRepositoryImpl<Sample, Integer> {
        @Override
        protected Class<Integer> getKeyType() {
            return Integer.class;
        }
    }
    private static class Sample implements DomainEntity<Integer> {

        private final Integer id;
        private String field;

        private Sample(Integer id, String field) {
            this.id = id;
            this.field = field;
        }

        @Override
        public Integer getId() {
            return id;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }
    }
}