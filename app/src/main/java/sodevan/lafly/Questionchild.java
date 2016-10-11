package sodevan.lafly;


import java.util.HashMap;

/**
 * Created by ravipiyush on 10/10/16.
 */

public class Questionchild {



    HashMap<String , Answerchild> answers  ;
    String By  ;
    Long Date ;
    String Month ;
    String Title ;
    String bestAnswer ;
    String qid ;



    public Questionchild() {
    }



    public Questionchild( HashMap<String , Answerchild> answers ,String By ,Long Date , String Description ,String Month , String Title ,String bestAnswer ,String qid ) {

        this.By =By ;
        this.answers =answers ;
        this.Date =Date ;
        this.Month =Month ;
        this.Title = Title ;
        this.bestAnswer = bestAnswer ;
        this.qid = qid ;

    }


    public HashMap<String, Answerchild> getAnswers() {
        return answers;
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
        return bestAnswer;
    }

    public String getQid() { return qid; }


}
