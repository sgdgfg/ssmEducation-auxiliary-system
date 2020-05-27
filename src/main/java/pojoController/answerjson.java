package pojoController;

public class answerjson {

    String userid;
    String name;
    String link;
    String content;
   String introduce;
    String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "answerjson{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", content='" + content + '\'' +
                ", introduce='" + introduce + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
