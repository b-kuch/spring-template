package pl.za.community.forum.forumuser.application;

import org.springframework.stereotype.Service;
import pl.za.community.forum.forumuser.domain.CreateForumUserCommand;
import pl.za.community.forum.forumuser.domain.ForumUser;
import pl.za.community.forum.forumuser.domain.ForumUserRepository;
import pl.za.community.forum.util.result.Result;
import pl.za.community.forum.util.result.Success;

@Service
public class CreateForumUserUseCase {

    private final ForumUserRepository forumUserRepository;

    CreateForumUserUseCase(ForumUserRepository forumUserRepository) {
        this.forumUserRepository = forumUserRepository;
    }

    public Result<ForumUser, ?> execute(CreateForumUserCommand command) {
        var user = forumUserRepository.persist(new ForumUser(command.username()));
        return Success.from(user);
    }

}
