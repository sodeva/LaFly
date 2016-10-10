package sodevan.lafly;

/**
 * Created by ravipiyush on 10/10/16.
 */

public class Answerchild {

    String Answer ;
    Long Date  ;
    String Month  ;
    String Name ;




    public  Answerchild(){}

    public  Answerchild(String Answer ,Long Date ,String Month ,String Name){

        this.Answer =Answer  ;
        this.Date =Date  ;
        this.Month = Month  ;
        this.Name  = Name   ;

    }


    public String getAnswer() {
        return Answer;
    }

    public Long getDate() {
        return Date;
    }

    public String getMonth() {
        return Month;
    }

    public String getName() {
        return Name;
    }


}
