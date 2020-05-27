package pojoController;

public class quemark {
   int id;
   int userid;
   String title;
   String content;
   String link;
   String answernumber;
   boolean ifmark;

    public String getAnswernumber() {
        return answernumber;
    }

    public void setAnswernumber(String answernumber) {
        this.answernumber = answernumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isIfmark() {
        return ifmark;
    }

    public void setIfmark(boolean ifmark) {
        this.ifmark = ifmark;
    }

    @Override
    public String toString() {
        return "quemark{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", ifmark=" + ifmark +
                '}';
    }
}
