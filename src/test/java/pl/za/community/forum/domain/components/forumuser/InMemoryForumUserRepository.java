package pl.za.community.forum.domain.components.forumuser;

import pl.za.community.forum.testsetup.InMemoryRepositoryImpl;

public class InMemoryForumUserRepository extends InMemoryRepositoryImpl<ForumUser, ForumUserId> implements ForumUserRepository {
    @Override
    protected Class<ForumUserId> getKeyType() {
        return ForumUserId.class;
    }

}
