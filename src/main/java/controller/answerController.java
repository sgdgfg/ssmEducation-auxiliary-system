package controller;

import com.alibaba.fastjson.JSON;
import mapper.answerDao;
import mapper.inUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.answer;
import pojo.user;
import pojoController.answerjson;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class answerController {

    @Autowired
   answerDao dao ;
    @Autowired
    inUser  userdao;

    @ResponseBody
    @RequestMapping("getanswerlist")
    public String getanswerlist(String questionid){
         answer[] aa= dao.list(questionid);
        answerjson[] jj=new answerjson[aa.length];
        System.out.println("===========================================================================");

         for(int i=0;i<aa.length;i++){
             jj[i]=new answerjson();
             jj[i].setUserid(aa[i].getUserid());
             jj[i].setContent(aa[i].getContent());
             jj[i].setTime(aa[i].getTime());
            user uu=userdao.get(aa[i].getUserid());
            if(uu!=null){
             jj[i].setName(uu.getName());
             jj[i].setIntroduce("");
             jj[i].setLink(uu.getLink());}
         }
         return JSON.toJSONString(jj);

    }

    @ResponseBody
    @RequestMapping("addanswer")
    public String  addanswer(answer an, HttpServletRequest request){
        LocalDate data=LocalDate.now();
        LocalTime time=LocalTime.now();
       an.setTime(data.toString()+"."+time);
        System.out.println("-----------------------------------66");
        System.out.println(an);
       dao.add(an);
       return "success";
    }


}
