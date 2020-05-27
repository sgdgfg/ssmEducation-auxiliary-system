package controller;

import com.alibaba.fastjson.JSON;
import mapper.signinsituationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.signinsituation;

@Controller
public class signSitutationController {
    @Autowired
    signinsituationDao dao;

    @ResponseBody
    @RequestMapping("getsign")
    public String getSign(String time){
        return JSON.toJSONString(dao.get(time));
    }
    @ResponseBody
    @RequestMapping("getsignlist")
    public String getSignList(){
        signinsituation[] ss=dao.list();
        for(int i=0;i<ss.length;i++){
          ss[i].settime(  ss[i].gettime().substring(5,10));
        }
        return JSON.toJSONString(ss);
    }
}
