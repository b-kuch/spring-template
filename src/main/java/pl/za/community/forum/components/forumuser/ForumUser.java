package pl.za.community.forum.components.forumuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ForumUser {
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
