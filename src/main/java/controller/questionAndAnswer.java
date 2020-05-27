package controller;

import com.alibaba.fastjson.JSON;
import mapper.answerDao;
import mapper.inQuestion;
import mapper.questionmarkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.question;
import pojo.questionmark;
import pojoController.quemark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class questionAndAnswer {


    @Autowired
    inQuestion qu;
    @Autowired
    answerDao answerdao;
    @Autowired
    questionmarkDao  markdao;
     @ResponseBody
    @RequestMapping("getquestion")
    public String returnQuestion(String questionid){
         question qqq=qu.get(questionid);
         System.out.println(JSON.toJSONString(qqq));
        return  JSON.toJSONString(qqq);
    }
    @ResponseBody
    @RequestMapping("question")
    public String returnlistQuestion(HttpServletRequest request){
       int userid =Integer.parseInt((String)request.getSession().getAttribute("userid"));
         question[] qq=qu.list();
        quemark[] cc=new quemark[qq.length];
        for(int i=0;i<qq.length;i++){
             cc[i]=new quemark();
            cc[i].setId(Integer.parseInt(qq[i].getId()));
            cc[i].setContent(qq[i].getContent());
            cc[i].setLink(qq[i].getLink());
            cc[i].setTitle(qq[i].getTitle());
            cc[i].setUserid(Integer.parseInt(qq[i].getUserid()));

            cc[i].setAnswernumber(answerdao.getnumber(String.valueOf(cc[i].getId())));
            System.out.println(qq[i].getId()+qq[i].getUserid());
            System.out.println("---------------------------------");
            System.out.println(markdao.get(new questionmark(Integer.parseInt(qq[i].getId()), userid)));
           if(markdao.get(new questionmark(Integer.parseInt(qq[i].getId()), userid))==null){
               cc[i].setIfmark(false);
           }else {
               cc[i].setIfmark(true);
           }
        }
         System.out.println(JSON.toJSONString(cc));
         return JSON.toJSONString(cc);
    }

    @RequestMapping("askquestion")
    public String tiwen(HttpServletRequest request,question question){
        //File file= (File)request.getAttribute("tupian");
        System.out.println(question);
        HttpSession sesson =request.getSession();
        StringBuffer  id=new StringBuffer ( String.valueOf(System.currentTimeMillis()));

        id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0);

        question que=new question();
        que.setId(id.toString());
        que.setTitle(request.getParameter("title"));
        System.out.println(request.getParameter("title"));
        que.setContent(request.getParameter("content"));
        System.out.println(request.getParameter("content"));
        if(sesson.getAttribute("userid ")==null)
            que.setUserid("0");
        else
        que.setUserid(sesson.getAttribute("userid ").toString());

        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();
        que.setTime(date.toString()+"."+time.toString());
        qu.add(que);
        return "redirect:/question.html";
    }


    @ResponseBody
    @RequestMapping("questionImg")
    public String upload(@PathVariable(value = "file") MultipartFile file, HttpServletRequest request) {
        String s= file.getOriginalFilename() ;
         String imgName="img/"+System.currentTimeMillis()+s.substring(s.length()-4,s.length());
        String pathname=request.getServletContext().getRealPath("/")+imgName;
        File saveFile = new File(pathname);
        // 保存

        try {
            //保存文件到服务器
            file.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgName;
    }



}
