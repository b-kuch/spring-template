package pl.za.community.forum.forumuser.domain;

import jakarta.persistence.Column;
import org.springframework.util.Assert;

public record Username(@Column(name = "username") String value) {
    public Username {
        Assert.notNull(value, "Username cannot be null");
    }
}
