package pl.za.community.forum;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		value = "pl.za.community.forum",
		repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class CommunityForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityForumApplication.class, args);
	}

}
