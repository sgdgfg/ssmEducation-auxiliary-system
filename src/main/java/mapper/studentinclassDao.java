package mapper;

import pojo.studentinclass;

public interface studentinclassDao {
public void add(studentinclass studentinclass);
public studentinclass[]  get(String studentid);
public void delete(studentinclass studentinclass);
public studentinclass[]  list();
}