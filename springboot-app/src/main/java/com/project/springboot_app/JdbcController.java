package com.project.springboot_app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//mport org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Controller
    @RequestMapping("/jdbc")
public class JdbcController {
    
@GetMapping
public String get(Model model){
    //add object to be bound by user provided details
    model.addAttribute("obj",new UserDetails());
    return "login";

}
@PostMapping                           
public static String post(@ModelAttribute("obj") UserDetails adminlogin,Model model){
  JDBC SQL =new JDBC();
  int result=SQL.insert(adminlogin);
  System.out.println("i am inserted");
  if(result==1)
  model.addAttribute("message","Successful JDBC");
  else{
  model.addAttribute("message","Query not submiited");
  }


  return "index";

}
}
