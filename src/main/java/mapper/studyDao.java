package mapper;

import pojo.study;

public interface studyDao {
public void add(study study);
public study  get();
public void delete(study study);
public study[]  list();
public int getlessonnumber(String lessonid);
}