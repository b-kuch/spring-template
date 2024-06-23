package pl.za.community.forum.forumuser.application;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import pl.za.community.forum.forumuser.domain.CreateForumUserCommand;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserUseCaseTests {
    protected CreateForumUserUseCase createForumUserUseCase;
    protected FindUserUseCase findUserUseCase;

    @BeforeEach
    void beforeEach() {
        var repository = new InMemoryForumUserRepository();
        createForumUserUseCase = new CreateForumUserUseCase(repository);
        findUserUseCase = new FindUserUseCase(repository);
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldSaveUserWithSpecifiedName(CreateForumUserCommand command) {
        var result = createForumUserUseCase.execute(command);
        var user = result.unwrap();
        assertThat(user.getUsername()).isEqualTo(command.username());
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldPersistUser(CreateForumUserCommand command) {
        var user = createForumUserUseCase.execute(command);
        var foundUser = findUserUseCase.findUser(user.unwrap().getId());
        assertThat(foundUser).isPresent();
    }
}
