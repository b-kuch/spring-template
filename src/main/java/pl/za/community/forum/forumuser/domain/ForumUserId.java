package pl.za.community.forum.forumuser.domain;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Column;

import java.io.Serializable;

public record ForumUserId(@Column(name = "id") long value) implements Serializable {

    public ForumUserId() {
        this(TSID.Factory.getTsid().toLong());
    }
}
