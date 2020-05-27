package controller;

import com.alibaba.fastjson.JSON;
import mapper.inDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.document;
import pojo.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class lessonController {

    @Autowired
    mapper.lessonMapper lesson1;

    @Autowired
    inDocument  documentMapper;
    @ResponseBody
    @RequestMapping("getlessonlist")
    public String getlessonlist(){
        lesson[]  le=lesson1.list();
      System.out.println(JSON.toJSONString(le));
    return JSON.toJSONString(le);
    }

    @RequestMapping("addlesson")
    public String  addlesson(@RequestParam("video") MultipartFile file, HttpServletRequest request){
        StringBuffer  id=new StringBuffer (String.valueOf(System.currentTimeMillis()));

        id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0);id.deleteCharAt(0);
        HttpSession sesson=request.getSession();
        String realPath = request.getSession().
                getServletContext().getRealPath("/");
        String imgAddress = realPath;
        String s=file.getOriginalFilename();
        String pathname =  imgAddress+"video/"+ id+s.substring(s.length()-4,s.length());
        File saveFile = new File(pathname);
        // 保存
        try {
            //保存文件到服务器
            file.transferTo(saveFile);

        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println(id);
        lesson que=new lesson();
        que.setId(id.toString());
        que.setTitle(request.getParameter("title"));
        que.setIntroduce(request.getParameter("introduce"));
        que.setTeacherid((String)sesson.getAttribute("userid"));
        que.setVideolink("video/"+ id+s.substring(s.length()-4,s.length()));
        lesson1.add(que);

        return "redirect:/teacher_lesson.html";

    }

    @ResponseBody
    @RequestMapping("getlesson")
    public String getlesson(HttpServletRequest request ,String lessonid){
      /*  String lessonid=request.getParameter("lessonid");*/
        System.out.println("lessonid"+lessonid);
        lesson  le=lesson1.get(lessonid);
        System.out.println(JSON.toJSONString(le));
        return JSON.toJSONString(le);
    }

    @ResponseBody
    @RequestMapping("getlessonnumber")
    public String getlessonnumber(HttpServletRequest request){

        return  String.valueOf(lesson1.getlessonnumber((String)request.getSession().getAttribute("userid")));
    }

    @ResponseBody
    @RequestMapping("getdocumentlist")
    public String getdocumentlist(){
        document[]  le=documentMapper.list();
        System.out.println(JSON.toJSONString(le));
        return JSON.toJSONString(le);
    }

    @RequestMapping("adddocument")
    public String  adddocument(@RequestParam(value="file") MultipartFile file , HttpServletRequest request){
        StringBuffer  id=new StringBuffer ( String.valueOf(System.currentTimeMillis()) );


        id.deleteCharAt(0); id.deleteCharAt(0); id.deleteCharAt(0);id.deleteCharAt(0);


        HttpSession sesson=request.getSession();
        String realPath = request.getSession().
                getServletContext().getRealPath("/");
        String imgAddress = realPath;
        String s=file.getOriginalFilename();
        String pathname = imgAddress+ "file/"+ id+s.substring(s.length()-4,s.length());
        File saveFile = new File(pathname);
        // 保存
        try {
            //保存文件到服务器
            file.transferTo(saveFile);

        } catch (Exception e) {
            e.printStackTrace();

        }

        document que=new document();
        que.setId(id.toString());
        que.setDocumentname(request.getParameter("name"));
        que.setIntroduce(request.getParameter("introduce"));
        que.setTeacherid((String)sesson.getAttribute("userid"));
        que.setLink("file/"+ id+s.substring(s.length()-4,s.length()));
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();

        que.setTime(date.toString()+"."+time.toString());
        documentMapper.add(que);

        return "redirect:/teacher_document.html";

    }



}
