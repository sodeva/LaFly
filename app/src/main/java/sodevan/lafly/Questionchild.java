package sodevan.lafly;


import java.util.HashMap;

/**
 * Created by ravipiyush on 10/10/16.
 */

public class Questionchild {



    HashMap<String , Answerchild> Answers  ;
    String By  ;
    Long Date ;
    String Month ;
    String Title ;
    String BestAnswer ;
    String qid ;



    public Questionchild() {
    }



    public Questionchild( HashMap<String , Answerchild> Answers ,String By ,Long Date , String Description ,String Month , String Title ,String BestAnswer ,String qid ) {

        this.By =By ;
        this.Answers =Answers ;
        this.Date =Date ;
        this.Month =Month ;
        this.Title = Title ;
        this.BestAnswer = BestAnswer ;
        this.qid = qid ;


    }


    public HashMap<String, Answerchild> getAnswers() {
        return Answers;
    }

    public String getBy() {
        return By;
    }

    public Long getDate() {
        return Date;
    }


    public String getMonth() {
        return Month;
    }

    public String getTitle() {
        return Title;
    }

    public String getBestAnswer() {
        return BestAnswer;
    }

    public String getQid() { return qid; }


}
