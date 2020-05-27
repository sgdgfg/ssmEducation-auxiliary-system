package mapper;

import pojo.lesson;

public interface  lessonMapper {
    public lesson[] list();
    public lesson get(String id);
    public void add(lesson le);
    public lesson[] getlessonid(String teacherid);
    public int getlessonnumber(String teacherid);
}
