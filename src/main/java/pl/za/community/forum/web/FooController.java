package pl.za.community.forum.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
    @GetMapping("/foo")
    String foo() {
        return "foo";
    }
}
