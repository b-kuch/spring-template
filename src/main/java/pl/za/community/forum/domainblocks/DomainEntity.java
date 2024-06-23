package pl.za.community.forum.domainblocks;

import java.io.Serializable;

public interface DomainEntity<T extends Serializable> {
    T getId();
}
