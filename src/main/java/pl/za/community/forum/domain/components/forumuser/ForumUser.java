package pl.za.community.forum.domain.components.forumuser;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import pl.za.community.forum.domain.components.util.domaintypes.DomainEntity;

@Entity
public class ForumUser implements DomainEntity<ForumUserId> {
    @EmbeddedId
    private ForumUserId id;

    ForumUser() {
    }

    public ForumUser(ForumUserId username) {
        id = username;
    }

    public ForumUserId getId() {
        return id;
    }

}
