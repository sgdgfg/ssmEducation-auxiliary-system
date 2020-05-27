package controller;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.notify;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class NotifyController {
    @Autowired
    mapper.notifyDao notifyDao;
    @ResponseBody

    @RequestMapping("getnotify")
    public String  getNotify(String id){
         notify no=notifyDao.get(Integer.parseInt(id));
         return JSON.toJSONString(no);
    }
    @ResponseBody
    @RequestMapping("getnotifylist")
    public String getNotifyList(){
        notify[] no=notifyDao.list();
        return  JSON.toJSONString(no);
    }

    @RequestMapping("addnotify")
    public String  addnotify(HttpServletRequest request){
        System.out.println("addnotify");
        notify no=new notify();
        no.setid((int)System.currentTimeMillis() );
        no.settitle(request.getParameter("title"));
        no.setcontent(request.getParameter("content"));
        no.setIfread(0);
        no.setclassid(Integer.parseInt(request.getParameter("classid")));
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();

        no.setTime(date.toString()+"."+time.toString());
        notifyDao.add(no);
        return "redirect:/teacherNotify.html";
    }
}
