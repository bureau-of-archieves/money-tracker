package zhy2002.moneytracker.webapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * This class contains the main method for Spring Boot standalone application.
 */
@SpringBootApplication(scanBasePackages = {"zhy2002.moneytracker"})
@ComponentScan //This is unnecessary but added for IntelliJ Idea IDE support
public class RootConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }


}
