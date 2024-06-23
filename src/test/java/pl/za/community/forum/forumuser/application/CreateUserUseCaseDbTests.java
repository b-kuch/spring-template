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
public class CreateUserUseCaseDbTests extends CreateUserUseCaseTests {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @Autowired
    CreateForumUserUseCase createForumUserUseCase;

    @Autowired
    FindUserUseCase findUserUseCase;

    @BeforeEach
    void beforeEach() {
        // todo entities should be deleted
        super.createForumUserUseCase = this.createForumUserUseCase;
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
