package pl.za.community.forum;


import org.junit.jupiter.api.Tag;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Testcontainers
@Tag("db")
public @interface DbTests {
}
