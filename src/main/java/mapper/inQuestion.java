package mapper;

import pojo.question;

public interface inQuestion {
    public question get(String id);
    public question[] list();
    public void add(question qu);

}
