package pojo;

public class questionmark{
Integer  questionid;
String   questiontitle;
Integer   userid;

 public questionmark(){}
 public questionmark(int questionid,int userid){
     this.questionid=questionid;
     this.userid=userid;
 }
    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestiontitle() {
        return questiontitle;
    }

    public void setQuestiontitle(String questiontitle) {
        this.questiontitle = questiontitle;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "questionmark{" +
                "questionid=" + questionid +
                ", questiontitle='" + questiontitle + '\'' +
                ", userid=" + userid +
                '}';
    }
}