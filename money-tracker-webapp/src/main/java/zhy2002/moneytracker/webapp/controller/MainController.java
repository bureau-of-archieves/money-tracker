package zhy2002.moneytracker.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controllers navigation between pages.
 */
@RestController
@RequestMapping()
public class MainController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
}
