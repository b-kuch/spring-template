package pl.za.community.forum.components.forumuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import pl.za.community.forum.components.util.domaintypes.DomainEntity;

@Entity
public class ForumUser implements DomainEntity<String> {
    @Id
    private String id;

    ForumUser() {
    }

    public ForumUser(String username) {
        id = username;
    }

    public String getId() {
        return id;
    }
}
