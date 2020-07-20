package us.navonod.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class PagesController {
    @GetMapping("/math/pi")
    public String helloGet() {
        return "3.141592653589793";
    }

}
