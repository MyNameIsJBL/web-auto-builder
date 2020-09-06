package com.webank.wob.web;

import com.webank.wob.gitlab.GitLabOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @Autowired
    GitLabOperation gitLabOperation;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("name") String name,@RequestParam("password")String password){
        String res = gitLabOperation.getPrivateToken();
        return "success:"+res;
    }
}
