package controller;

import com.alibaba.fastjson.JSON;
import mapper.lessonMapper;
import mapper.studyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.lesson;
import pojo.study;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

@Controller
public class studyController {
     @Autowired
    lessonMapper lessonDao;
     @Autowired
    studyDao studydao;
     @ResponseBody
    @RequestMapping("getstudynumber")
    public String get(String teacherid){
          class tt{
             String title;
             int number;
             public tt(String a,int b){
                 title=a;
                number=b;

             }

              public String getTitle() {
                  return title;
              }

              public void setTitle(String title) {
                  this.title = title;
              }

              public int getNumber() {
                  return number;
              }

              public void setNumber(int number) {
                  this.number = number;
              }
          }

        lesson[] lessons= lessonDao.getlessonid(teacherid);
          tt[] t=new tt[lessons.length];
      String ss="[";
        for(int i=0;i<lessons.length;i++){
            System.out.println(lessons[i].getTitle()+"  ----------------   "+studydao.getlessonnumber(lessons[i].getId()));
            t[i]= new tt(lessons[i].getTitle(),studydao.getlessonnumber(lessons[i].getId()));
        }
         System.out.println("=====================================");
        for(int i=0;i<t.length;i++){
            System.out.println(t[i].title+"   "+t[i].number);
        }
         System.out.println( JSON.toJSONString(t));
     return  JSON.toJSONString(t);
    }
    @ResponseBody
    @RequestMapping("addstudy")
    public String addstudy(HttpServletRequest request){
         study  ss=new study();
         ss.setlessonid(Integer.parseInt((String)request.getParameter("lessonid")));
         ss.setuserid(Integer.parseInt((String)request.getSession().getAttribute("userid")));
         LocalDate date =LocalDate.now();
        LocalTime time=LocalTime.now();
         ss.settime( date.toString()+"."+time.toString());
         studydao.add(ss);
         return "success";
    }

}
