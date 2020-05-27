package mapper;

import pojo.signinsituation;



public interface signinsituationDao {
public void add(signinsituation signinsituation);
public signinsituation  get(String time);
public void delete(signinsituation signinsituation);
public signinsituation[]  list();
public  void update(signinsituation signinsituation);
public  signinsituation getalive(String time);
}