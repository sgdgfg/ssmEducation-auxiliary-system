package pojo;

public class answer {
    String questionid;
    String userid;
    String content;
    String link;
    String time;

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "answer{" +
                "questionid='" + questionid + '\'' +
                ", userid='" + userid + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
