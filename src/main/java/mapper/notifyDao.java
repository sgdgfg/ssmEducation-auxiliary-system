package mapper;

import pojo.notify;

public interface notifyDao {
public void add(notify notify);
public notify  get(int id);
public void delete(notify notify);
public notify[]  list();
}