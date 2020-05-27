package controller;

import com.alibaba.fastjson.JSON;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.questionmark;
import pojo.thePolo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;


@Controller
public class text1 {



  @ResponseBody
    @RequestMapping("showsession")
    public String  t(HttpServletRequest request){
    String s="";
    s+=request.getContextPath();
    s+="                   ";
     HttpSession session =request.getSession();
     s+=session.getAttribute("userid");
    String pathname=request.getServletContext().getRealPath("/");
    StringBuffer id = new StringBuffer(new Date(System.currentTimeMillis()).toLocaleString());
    for (int i = 0; i < id.length(); i++) {
      if (id.charAt(i) == '-' || id.charAt(i) == ' ' || id.charAt(i) == ':')
        id.deleteCharAt(i);
    }

   return  s+"           "+pathname+"               "+id+"                  "+ LocalDate.now().toString();
  }



}
