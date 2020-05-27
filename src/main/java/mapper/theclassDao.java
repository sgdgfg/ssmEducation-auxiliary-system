package mapper;

import pojo.theclass;

public interface theclassDao {
public void add(theclass theclass);
public theclass  get(String id);
public void delete(theclass theclass);
public theclass[]  list();
public theclass[] getclassidList(String teacherid);
    public theclass[]    getclassedList(String id);
    public int getclassnumber();
}