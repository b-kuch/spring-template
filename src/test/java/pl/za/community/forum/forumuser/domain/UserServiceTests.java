package pl.za.community.forum.forumuser.domain;

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
        assertThat(user.getUsername()).isEqualTo(command.username());
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldPersistUser(CreateForumUserCommand command) {
        var user = service.createUser(command);
        var foundUser = service.findUser(user.unwrap().getId());
        assertThat(foundUser).isPresent();
    }

    protected ForumUserService supplyTestedService() {
        return new ForumUserService(new InMemoryForumUserRepository());
    }
}
