package controller;

import mapper.studentinclassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.studentinclass;

@Controller
public class studentInClassController {
    @Autowired
    studentinclassDao dao;
    @ResponseBody
    @RequestMapping("addstudentinclass")
  public String addst(studentinclass ss){
      dao.add(ss);
      return "success";
  }
}
