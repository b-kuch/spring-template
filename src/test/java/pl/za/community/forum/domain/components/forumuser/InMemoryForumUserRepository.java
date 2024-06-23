package pl.za.community.forum.domain.components.forumuser;

import pl.za.community.forum.testsetup.InMemoryRepositoryImpl;

public class InMemoryForumUserRepository extends InMemoryRepositoryImpl<ForumUser, String> implements ForumUserRepository {
    @Override
    protected Class<String> getKeyType() {
        return String.class;
    }

}
