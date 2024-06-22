package pl.za.community.forum;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class UserServiceTest {
    @Autowired
    ForumUserService service;

    @InstancioSource
    @ParameterizedTest
    void createShouldSaveUserWithSpecifiedName(String name) {
        var result = service.createUser(new CreateForumUserCommand(name));
        var user = result.unwrap();
        assertThat(user.getId()).isEqualTo(name);
    }

    @InstancioSource
    @ParameterizedTest
    void createShouldPersistUser(CreateForumUserCommand command) {
        service.createUser(command);
        var user = service.findUser(command.username());
        assertThat(user).isPresent();
    }
}
