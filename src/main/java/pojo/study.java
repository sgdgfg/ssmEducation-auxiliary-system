package pojo;

import java.sql.Time;

public class study{
int   userid;
int   lessonid;
String   time;
public int   getuserid(){ return userid;}
public  void   setuserid( int userid){ this.userid=userid;}
public int   getlessonid(){ return lessonid;}
public  void   setlessonid( int lessonid){ this.lessonid=lessonid;}
public String   gettime(){ return time;}
public  void   settime( String time){ this.time=time;}
}