package sodevan.lafly;

/**
 * Created by kartiksharma on 11/10/16.
 */

public class VideoChild {
    String url;
    String date;
    String name;
    public VideoChild(){

    }


    public VideoChild(String URL, String Date, String Name){
        this.date=Date;
        this.url=URL;
        this.name=Name;


    }
    public String getURL() {
        return url ;
    }
    public String getDate(){
        return date;
    }
    public String getName(){
        return name;
    }


}
