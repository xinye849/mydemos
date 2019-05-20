package xin.yuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xin.yuan.domain.Account;
import xin.yuan.service.AccountService;

import java.util.List;

/**
 * @authorknightx
 * @create2019/4/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Account> all = accountService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("account",all);
        mv.setViewName("findAll");

        return mv;
    }
    @RequestMapping("/save")
    public String save(Account account){
        System.out.println(account);
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
