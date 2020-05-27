package pojo;

public class lesson {
    static  String cc="23132";
    String id;
    String teacherid;
    String videolink;
    String introduce;

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "lesson{" +
                "id='" + id + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", videolink='" + videolink + '\'' +
                ", introduce='" + introduce + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
