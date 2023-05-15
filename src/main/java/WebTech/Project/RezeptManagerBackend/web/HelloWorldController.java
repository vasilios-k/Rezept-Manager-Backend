package WebTech.Project.RezeptManagerBackend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/")
    public ModelAndView showHelloWorld() {
        return new ModelAndView("helloworld");
    }
}
