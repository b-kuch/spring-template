package pl.za.community.forum.forumuser.application;

import org.springframework.stereotype.Service;
import pl.za.community.forum.forumuser.domain.ForumUser;
import pl.za.community.forum.forumuser.domain.ForumUserId;
import pl.za.community.forum.forumuser.domain.ForumUserRepository;

import java.util.Optional;

@Service
public class FindUserUseCase {

    private final ForumUserRepository forumUserRepository;

    FindUserUseCase(ForumUserRepository forumUserRepository) {
        this.forumUserRepository = forumUserRepository;
    }

    public Optional<ForumUser> findUser(ForumUserId username) {
        return forumUserRepository.findById(username);
    }
}
