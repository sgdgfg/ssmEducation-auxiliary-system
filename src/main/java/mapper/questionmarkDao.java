package mapper;

import pojo.questionmark;

public interface questionmarkDao {
public void add(questionmark questionmark);
public questionmark  get(questionmark questionmark);
public void delete(questionmark questionmark);
public questionmark[]  list();
}