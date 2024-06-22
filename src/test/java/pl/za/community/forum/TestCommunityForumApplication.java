package pl.za.community.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCommunityForumApplication {

	public static void main(String[] args) {
		SpringApplication
				.from(CommunityForumApplication::main)
				.with(TestCommunityForumApplication.class)
				.with(PostgresTestConfiguration.class)
				.run(args);
	}

}
