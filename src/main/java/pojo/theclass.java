package pojo;

public class theclass{
String   id;
String   classname;
String   teacherid;
String   introduce;
String   link;
public String getid(){ return id;}
public  void   setid( String id){ this.id=id;}
public String   getclassname(){ return classname;}
public  void   setclassname( String classname){ this.classname=classname;}
public String   getteacherid(){ return teacherid;}
public  void   setteacherid( String teacherid){ this.teacherid=teacherid;}
public String   getintroduce(){ return introduce;}
public  void   setintroduce( String introduce){ this.introduce=introduce;}
public String   getlink(){ return link;}
public  void   setlink( String link){ this.link=link;}

    @Override
    public String toString() {
        return "theclass{" +
                "id='" + id + '\'' +
                ", classname='" + classname + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", introduce='" + introduce + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}