package pl.za.community.forum;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForumUserService {

    private final ForumUserRepository forumUserRepository;

    ForumUserService(ForumUserRepository forumUserRepository) {
        this.forumUserRepository = forumUserRepository;
    }

    public Result<ForumUser, ?> createUser(CreateForumUserCommand command) {
        var user = forumUserRepository.persist(new ForumUser(command.username()));
        return Success.from(user);
    }
    public Optional<ForumUser> findUser(String username) {
        return forumUserRepository.findById(username);
    }
}
