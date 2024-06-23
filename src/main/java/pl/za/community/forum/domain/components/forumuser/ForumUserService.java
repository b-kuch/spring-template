package pl.za.community.forum.domain.components.forumuser;

import org.springframework.stereotype.Service;
import pl.za.community.forum.util.result.Result;
import pl.za.community.forum.util.result.Success;

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
    public Optional<ForumUser> findUser(ForumUserId username) {
        return forumUserRepository.findById(username);
    }
}
