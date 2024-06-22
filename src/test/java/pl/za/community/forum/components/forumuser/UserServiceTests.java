package pl.za.community.forum.components.forumuser;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTests {
    private ForumUserService service;

    @BeforeEach
    void beforeEach() {
        service = supplyTestedService();
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldSaveUserWithSpecifiedName(CreateForumUserCommand command) {
        var result = service.createUser(command);
        var user = result.unwrap();
        assertThat(user.getId()).isEqualTo(command.username());
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldPersistUser(CreateForumUserCommand command) {
        service.createUser(command);
        var user = service.findUser(command.username());
        assertThat(user).isPresent();
    }

    protected ForumUserService supplyTestedService() {
        return new ForumUserService(new InMemoryForumUserRepository());
    }
}
