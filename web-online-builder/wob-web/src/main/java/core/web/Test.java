package core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("name") String name,@RequestParam("password")String password){
        return "success:"+name+password;
    }
}
