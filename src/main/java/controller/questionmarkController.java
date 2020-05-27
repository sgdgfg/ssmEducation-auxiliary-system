package controller;

import mapper.questionmarkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.questionmark;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@Controller
public class questionmarkController {
    @Autowired
    questionmarkDao dao;

    @ResponseBody
    @RequestMapping("mark")
    public String mark(    questionmark mm,HttpServletRequest request) {
        System.out.println("mm:       " + mm);
        try{
        BufferedReader br = request.getReader();
        String str = "";
        String listString = "";
        while ((str = br.readLine()) != null) {
            listString += str;
        }
        System.out.println(listString);}catch(Exception e){}
        dao.add(mm);
        return "mark sss";
    }

    @ResponseBody
    @RequestMapping("delectmark")
    public String delectmark(int questionid,int userid){
        questionmark mark=new questionmark();
        mark.setQuestiontitle("0");
        mark.setQuestionid(questionid);
        mark.setUserid(userid);
          dao.delete(mark);
          return "delectmark";
    }


}