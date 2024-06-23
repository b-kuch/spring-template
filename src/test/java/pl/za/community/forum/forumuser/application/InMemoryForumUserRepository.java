package pl.za.community.forum.forumuser.application;

import pl.za.community.forum.forumuser.domain.ForumUser;
import pl.za.community.forum.forumuser.domain.ForumUserId;
import pl.za.community.forum.forumuser.domain.ForumUserRepository;
import pl.za.community.forum.testsetup.InMemoryRepositoryImpl;

public class InMemoryForumUserRepository extends InMemoryRepositoryImpl<ForumUser, ForumUserId> implements ForumUserRepository {
    @Override
    protected Class<ForumUserId> getKeyType() {
        return ForumUserId.class;
    }

}
