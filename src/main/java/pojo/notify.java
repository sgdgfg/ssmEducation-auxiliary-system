package pojo;

import java.sql.Time;

public class notify{
int   id;
int   teacherid;
String   title;
String   content;
int   classid;
String   time;
int ifread;

    public int getIfread() {
        return ifread;
    }

    public void setIfread(int ifread) {
        this.ifread = ifread;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int   getid(){ return id;}
public  void   setid( int id){ this.id=id;}
public int   getteacherid(){ return teacherid;}
public  void   setteacherid( int teacherid){ this.teacherid=teacherid;}
public String   gettitle(){ return title;}
public  void   settitle( String title){ this.title=title;}
public String   getcontent(){ return content;}
public  void   setcontent( String content){ this.content=content;}
public int   getclassid(){ return classid;}
public  void   setclassid( int classid){ this.classid=classid;}

}