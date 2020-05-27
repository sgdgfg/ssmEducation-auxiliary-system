package controller;


import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginFilter implements Filter {
    public void doFilter(ServletRequest request,  ServletResponse response, FilterChain chain){

        HttpServletResponse response1 =(HttpServletResponse) response;
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpSession session=request1.getSession();
       Cookie[] cook= request1.getCookies();
       System.out.println("getRequestURI:    "+request1.getRequestURI());
       String url=request1.getRequestURI();
       String[] c=url.split("/");
       url=c[c.length-1];



       if(( url.equals("login.html"))||url.equals("logup.html")||
               request1.getRequestURI().equals("signin")||request1.getRequestURI().equals("signup")){
           System.out.println("filter in");
            try{
                chain.doFilter(request,response);}catch (Exception e){}
            return;
        }
        if( session.getAttribute("userid")==null){
            System.out.println("session==null");
            try{
                response1.sendRedirect("login.html"); } catch(Exception e){}
            return;
        }

      if(session.getAttribute("userid")!=null){

          response1.addCookie(new Cookie("userid",(String)session.getAttribute("userid")));
          response1.addCookie(new Cookie("username",(String)session.getAttribute("username")));
          response1.addCookie(new Cookie("touxiang",(String)session.getAttribute("touxiang")));
          try{
          chain.doFilter(request,response);}catch (Exception e){}
          return;
      }


       try{
        response1.sendRedirect("login.html");}catch(Exception e){}
        }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
