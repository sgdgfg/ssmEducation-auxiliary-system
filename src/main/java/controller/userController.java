package controller;

import com.alibaba.fastjson.JSON;
import mapper.inUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class userController {
    @Autowired
    inUser dao;

    @ResponseBody
    @RequestMapping("getuserlist")
    public String getuser() {
        user[] us = dao.list();

        return JSON.toJSONString(us);
    }

     @ResponseBody
    @RequestMapping("deleteuser")
    public String deleteuser(String id, HttpServletResponse response, HttpServletRequest request) {
        dao.delete(id);

        return  "/manage_userlist.html";
    }
}