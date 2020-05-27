package controller;

import com.alibaba.fastjson.JSON;
import mapper.inUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class person {
   @Autowired
    inUser usr;

    @ResponseBody
    @RequestMapping("getperson")
public String get(HttpServletRequest request){
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
    return JSON.toJSONString(usr.get(id));
}


    @RequestMapping("personEdit")
    public String upload(HttpSession session, @RequestParam("touxiang") MultipartFile file,HttpServletRequest request) {
        String realPath = request.getSession().
                getServletContext().getRealPath("/");
        String imgAddress = realPath;
        String s= file.getOriginalFilename() ;
      String ss= "img/" +(String)session.getAttribute("userid")+"touxiang"+s.substring(s.length()-4,s.length()) ;
          String pathname=imgAddress+ss;
         File saveFile = new File(pathname);
        // 保存
        try {
            //保存文件到服务器
            file.transferTo(saveFile);

        } catch (Exception e) {
            e.printStackTrace();

        }

        user  uu=new user();
        uu.setId((String)session.getAttribute("userid"));
        uu.setName(request.getParameter("name"));
        uu.setEmail(request.getParameter("email"));
        uu.setSex(request.getParameter("sex"));
        uu.setPower(2);
        uu.setLink(ss);
        System.out.println("persion:     "+uu);
     usr.update(uu);

        session.setAttribute("userid",uu.getId());
        session.setAttribute("username", uu.getName());
        session.setAttribute("touxiang", uu.getLink());
        return "redirect:/student.html";
    }


    @RequestMapping("teacherEdit")
    public String upteacher(HttpSession session,  HttpServletRequest request) {

       user  uu=new user();
        uu.setId((String)session.getAttribute("userid"));
        uu.setName(request.getParameter("name"));
        uu.setEmail(request.getParameter("email"));
        uu.setSex(request.getParameter("sex"));
        uu.setLink("0");
        uu.setPower(1);
        usr.update(uu );
        session.setAttribute("userid",uu.getId());
        session.setAttribute("username", uu.getName());
        session.setAttribute("touxiang", uu.getLink());
        return "redirect:/teacher_personEdit.html";
    }

    @RequestMapping("manageEdit")
    public String updateroot(HttpSession session,  HttpServletRequest request) {

        user  uu=new user();
        uu.setId((String)session.getAttribute("userid"));
        uu.setName(request.getParameter("name"));
        uu.setEmail(request.getParameter("email"));
        uu.setSex(request.getParameter("sex"));
        uu.setLink("0");
        uu.setPower(0);
        usr.update(uu );
        session.setAttribute("userid",uu.getId());
        session.setAttribute("username", uu.getName());
        session.setAttribute("touxiang", uu.getLink());
        return "redirect:/manage_personedit.html";
    }
}
