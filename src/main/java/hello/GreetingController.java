package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "wus poppin, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/blood")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Blood") String name) {
        if (name.substring(0, 1).equalsIgnoreCase("c")) {
            name = "[B]" + name.substring(1);
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}