package pl.za.community.forum.forumuser.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import pl.za.community.forum.domainblocks.DomainEntity;

@Entity
public class ForumUser implements DomainEntity<ForumUserId> {
    @EmbeddedId
    private ForumUserId id;
    @Embedded
    private Username username;

    ForumUser() {
    }

    public ForumUser(Username username) {
        this.id = new ForumUserId();
        this.username = username;
    }

    public ForumUserId getId() {
        return id;
    }

    public Username getUsername() {
        return username;
    }
}
