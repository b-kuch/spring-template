package pl.za.community.forum.components.util.domaintypes;

import java.io.Serializable;

public interface DomainEntity<T extends Serializable> {
    T getId();
}
