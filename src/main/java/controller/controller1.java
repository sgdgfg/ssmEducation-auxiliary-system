package controller;

import mapper.inUser;
import mapper.mapper1;
import mapper.signinsituationDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pojo.signinsituation;
import pojo.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class controller1 {
    @Autowired
   mapper1 ma;
    @Autowired
    inUser inuser;
@Autowired
signinsituationDao signdao;
    static Logger logger = LogManager.getLogger(controller1.class.getName());
    @RequestMapping("signin")//注册
    public String bb(HttpServletRequest request ){


      System.out.println("zhuce");
        user  us=new user();
        us.setId(request.getParameter("id"));
        us.setName(request.getParameter("name"));
        us.setPassword(request.getParameter("password"));
        us.setEmail(request.getParameter("email"));
        us.setPower(Integer.parseInt(request.getParameter("power")));
        us.setSex(request.getParameter("sex"));
        System.out.println(us.toString());
        try{
        inuser.add(us);}catch (Exception e){e.printStackTrace(); System.out.println("zhuce error");}
        System.out.println(request.getParameter("password"));
        return "redirect:/login.html";
    }

    @RequestMapping("signup")//登陆
    public String singnup(HttpServletRequest request, HttpServletResponse response){
        System.out.println("==========signup=======");  
        user us= inuser.get(request.getParameter("id"));
        System.out.println(us);
        if(us.getPassword().equals(request.getParameter("password"))) {
            System.out.println("signup success");
            user uu=inuser.get(request.getParameter("id"));
            HttpSession session=request.getSession();
            session.setAttribute("userid",uu.getId());
            session.setAttribute("username", uu.getName());
            session.setAttribute("touxiang", uu.getLink());
            response.addCookie(new Cookie("userid", uu.getId()));
            response.addCookie(new Cookie("username", uu.getName()));
            response.addCookie(new Cookie("touxiang", uu.getLink()));
            String view= "student.html" ;

            LocalDate date =LocalDate.now();
           if( signdao.getalive(date.toString())==null){
          logger.debug(date.toString()+"==null      --------     signup");
               signinsituation  ss=new signinsituation();
               ss.settime(date.toString());
               ss.setnumber(1);
               signdao.add(ss);
           }else{
               signinsituation  ss=  signdao.get(date.toString());
            int number=   ss.getnumber();
            signinsituation sss=new signinsituation();
            sss.setnumber(number+1);
            sss.settime(date.toString());
            signdao.update(sss);
           }

            if(uu.getPower()==0){
             view =  "redirect:/manage_index.html";}
            else if(uu.getPower()==1){
               view = "redirect:/teacherIndex.html" ;
            }else{
                 view =  "redirect:/student.html";
            }
             return view;
        }
        else{

          String  view="redirect:/login.html";
          //  view.addObject();
            return view;
         }

    }
    @ResponseBody
    @RequestMapping("text")
    public String text(){
        // System.out.println(usr );

        return "789456123aaaaaa";
    }

    @ResponseBody
    @RequestMapping("getnumber")
    public String getnumber(){
        // System.out.println(usr );
     return    String.valueOf(inuser.getnumber());

    }
    @ResponseBody
    @RequestMapping("getusernumber")
    public String getusernumber(){
        // System.out.println(usr );
        return    String.valueOf(inuser.getusernumber());

    }

}
