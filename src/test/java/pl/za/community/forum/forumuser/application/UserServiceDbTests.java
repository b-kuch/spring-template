package pl.za.community.forum.forumuser.application;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import pl.za.community.forum.testsetup.DbTests;

@SpringBootTest
@DbTests
public class UserServiceDbTests extends UserServiceTests {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @Autowired
    ForumUserService service;

    @Autowired
    FindUserUseCase findUserUseCase;

    @BeforeEach
    void beforeEach() {
        // todo entities should be deleted
        super.service = this.service;
        super.findUserUseCase = this.findUserUseCase;
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

}
