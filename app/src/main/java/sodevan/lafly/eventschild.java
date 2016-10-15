package sodevan.lafly;

/**
 * Created by ronaksakhuja on 10/10/16.
 */

public class eventschild {//sdfddfs
String event_name ,event_by ,event_short,event_long;
public eventschild(){

}
    public eventschild(String event_name,String event_by,String event_short,String event_long){
        this.event_name=event_name;
        this.event_by=event_by;
        this.event_short=event_short;
        this.event_long=event_long;
    }

    public String getEvent_by() {
        return event_by;
    }

    public String getEvent_long() {
        return event_long;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_short() {
        return event_short;
    }
}
