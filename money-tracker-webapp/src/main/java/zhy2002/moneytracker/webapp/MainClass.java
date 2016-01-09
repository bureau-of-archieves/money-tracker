package zhy2002.moneytracker.webapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class contains the main method for Spring Boot standalone application.
 */
@RestController
@SpringBootApplication(scanBasePackages = {"zhy2002.moneytracker"})
@ComponentScan //This is unnecessary but added for IntelliJ Idea IDE support
public class MainClass extends SpringBootServletInitializer {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainClass.class);
    }
}
