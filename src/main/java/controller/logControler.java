package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
public class logControler {

    @RequestMapping("logdownload")
    public void logdown(HttpServletRequest request,HttpServletResponse response, String s){
        String pathname=request.getServletContext().getRealPath("/");

        // 2.获取要下载的文件名
        String fileName =pathname+"logs/"+s;
        // 3.设置content-disposition响应头控制浏览器弹出保存框，若没有此句则浏览器会直接打开并显示文件。中文名要经过URLEncoder.encode编码，否则虽然客户端能下载但显示的名字是乱码
        try{
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(s, "UTF-8"));
        // 4.获取要下载的文件输入流

        InputStream in = new FileInputStream(fileName);
        int len = 0;
        // 5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        // 6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        // 7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            // 8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer, 0, len);
        }
        in.close();}catch(Exception e){

        }
        }
    }

