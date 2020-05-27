package mapper;

import pojo.answer;

public interface answerDao {
    public void add(answer an);
    public answer get(answer an);
    public String  getnumber(String  questionid);
    public answer[] list(String questionid);
}
