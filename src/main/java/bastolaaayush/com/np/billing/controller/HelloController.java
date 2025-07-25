package bastolaaayush.com.np.billing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @PostMapping("/hello/{name}")
    public String sayhello(@RequestParam String name){
        return "Hello, " + name;
    }
}
