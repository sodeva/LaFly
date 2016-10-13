package sodevan.lafly;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Created by kartiksharma on 11/10/16.
 */

public class VideoChild extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
