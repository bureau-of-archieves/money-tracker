package zhy2002.moneytracker.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class contains the main method for Spring Boot standalone application.
 */
@RestController
@EnableAutoConfiguration
public class MainClass {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MainClass.class, args);
    }
}
