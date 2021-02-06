package tn.isg.mppsi.plantsStoreMgt.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String goHome()
    {
        return "Test spring security Ok";
    }
}
