package pl.za.community.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes={PostgresTestConfiguration.class})
class CommunityForumApplicationTests {

	@Test
	void contextLoads() {
	}

}
