package pl.za.community.forum.forumuser.application;

import pl.za.community.forum.domainblocks.UseCase;
import pl.za.community.forum.forumuser.domain.ForumUser;
import pl.za.community.forum.forumuser.domain.ForumUserId;
import pl.za.community.forum.forumuser.domain.ForumUserRepository;

import java.util.Optional;

@UseCase
public class FindUserUseCase {

    private final ForumUserRepository forumUserRepository;

    FindUserUseCase(ForumUserRepository forumUserRepository) {
        this.forumUserRepository = forumUserRepository;
    }

    public Optional<ForumUser> findUser(ForumUserId username) {
        return forumUserRepository.findById(username);
    }
}
