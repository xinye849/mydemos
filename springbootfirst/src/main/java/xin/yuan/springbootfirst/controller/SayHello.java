package xin.yuan.springbootfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @authorknightx
 * @create2019/5/14
 * @since 1.0.0
 */
@Controller
@RequestMapping("/test")
public class SayHello {
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "hello world!!!";
    }
}
