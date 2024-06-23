package pl.za.community.forum.domain.components.forumuser;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.util.Assert;

import java.io.Serializable;

@MappedSuperclass
public record ForumUserId(@Column(name = "id") String value) implements Serializable {
    public ForumUserId {
        Assert.notNull(value, "Id cannot be null");
    }

}
