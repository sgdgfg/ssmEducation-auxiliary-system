package mapper;

import pojo.user;

public interface inUser {
public void add(user user);
public user  get(String id);
public void update(user user);
public int  getnumber();
public void  delete(String id);
public  user[] list();
public int getusernumber();
}
