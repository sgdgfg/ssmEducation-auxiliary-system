package controller;

import com.alibaba.fastjson.JSON;
import mapper.inUser;
import mapper.studentinclassDao;
import mapper.theclassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.lesson;
import pojo.studentinclass;
import pojo.theclass;
import pojo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
public class theclassController {
    @Autowired
    theclassDao  dao;
    @Autowired
    inUser userdao;
    @Autowired
    studentinclassDao studentinclassdao ;

     @RequestMapping("addclass")
     public String  addclass(@RequestParam("link") MultipartFile file, HttpServletRequest request) {

         StringBuffer id = new StringBuffer( String.valueOf(System.currentTimeMillis()) );
         id.deleteCharAt(0);
         id.deleteCharAt(0);
         id.deleteCharAt(0);
         id.deleteCharAt(0);
         HttpSession sesson = request.getSession();
         String realPath = request.getSession().
                 getServletContext().getRealPath("/");
         String imgAddress = realPath;
          String s=file.getOriginalFilename();
         String pathname = imgAddress+"img/"+ id+s.substring(s.length()-4,s.length());
         File saveFile = new File(pathname);
         // 保存
         try {
             //保存文件到服务器
             file.transferTo(saveFile);

         } catch (Exception e) {
             e.printStackTrace();

         }
         theclass cl=new theclass();
         cl.setteacherid(request.getParameter("teacherid"));
         cl.setclassname(request.getParameter("classname"));
         cl.setid(id.toString());
         cl.setintroduce(request.getParameter("introduce"));
         cl.setlink("img/"+ id+s.substring(s.length()-4,s.length()));
         System.out.println(cl);
         dao.add(cl);

         return "redirect:/manage_addclass.html";
     }
    @ResponseBody
    @RequestMapping("getclassidList")
    public String getClass(String teacherid){
        System.out.println(teacherid);
      theclass[] cl= dao.getclassidList(teacherid);
        System.out.println(JSON.toJSONString(cl));
      return JSON.toJSONString(cl);
    }

    @ResponseBody
    @RequestMapping("getclassList")
    public String getClassList(){

        theclass[] cl= dao.list();
       for(int i=0;i<cl.length;i++){
         user u= userdao.get(cl[i].getteacherid());
         if(u!=null)
         cl[i].setteacherid(u.getName());
       }
        return JSON.toJSONString(cl);
    }

    @ResponseBody
    @RequestMapping("getclassedList")
    public String getClassedList(HttpSession session){
        String userid=(String)session.getAttribute("userid");
     studentinclass[] ss=studentinclassdao.get(userid);
        theclass[] cc=new theclass[ss.length];
        for(int i=0;i<ss.length;i++){
           theclass c=dao.get(String.valueOf(ss[i].getclassid()));

           cc[i]=c;
        }

        return JSON.toJSONString(cc);
    }


    @ResponseBody
    @RequestMapping("getclass")
    public String get(String classid){

        theclass cl= dao.get(classid);
        user uu=userdao.get(cl.getteacherid());
        if(uu!=null)
        cl.setteacherid(uu.getName());

        return JSON.toJSONString(cl);
    }


    @ResponseBody
    @RequestMapping("getclassnumber")
    public String getclassnumber(){



        return String.valueOf(dao.getclassnumber());
    }
}
