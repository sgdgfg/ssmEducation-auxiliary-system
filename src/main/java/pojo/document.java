package pojo;

public class document {
    String id;
    String documentname;
    String teacherid;
    String link;
    String introduce;
    String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    @Override
    public String toString() {
        return "document{" +
                "id='" + id + '\'' +
                ", documentname='" + documentname + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", link='" + link + '\'' +
                ", introduce='" + introduce + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
