package sodevan.lafly;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaedongchicken.ytplayer.YoutubePlayerView;
import com.jaedongchicken.ytplayer.model.YTParams;
import com.pierfrancescosoffritti.youtubeplayer.AbstractYouTubeListener;
import com.pierfrancescosoffritti.youtubeplayer.YouTubePlayerView;

public class EnLearn  extends Fragment {
    private ListView lv;
    Typeface roboto;
    FirebaseDatabase database;
    DatabaseReference ref;
    Context c ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_en_learn ,container  , false) ;

        database = FirebaseDatabase.getInstance() ;
        ref = database.getReference("Enlearn Videos")  ;
        lv = (ListView) v.findViewById(R.id.enlearnlistview);


        FirebaseListAdapter<VideoChild> fb = new FirebaseListAdapter<VideoChild>(getActivity(), VideoChild.class, R.layout.videochild, ref) {

            @Override
            protected void populateView(View v, VideoChild model, int position) {
                roboto=Typeface.createFromAsset(c.getAssets() , "roboto.ttf") ;
              final String url=model.getURL();
                String date=model.getDate();
                String name=model.getName();
                TextView Date=(TextView)v.findViewById(R.id.date);
                TextView Name=(TextView)v.findViewById(R.id.heading);
                Name.setTypeface(roboto);
                Date.setTypeface(roboto);
                Name.setText(name);
                Date.setText(date);
                final YoutubePlayerView youtubePlayerView = (YoutubePlayerView) v.findViewById(R.id.youtubePlayerView);

                // Control values
                // see more # https://developers.google.com/youtube/player_parameters?hl=en
                YTParams params = new YTParams();
                // params.setControls(0); // hide control

                // initialize YoutubePlayerCallBackListener with Params and VideoID
                // youtubePlayerView.initialize("WCchr07kLPE", params, new YoutubePlayerView.YouTubeListener())


                // make auto height of youtube. if you want to use 'wrap_content'
                youtubePlayerView.setAutoPlayerHeight(getContext());
                // initialize YoutubePlayerCallBackListener and VideoID
                youtubePlayerView.initialize(url, new YoutubePlayerView.YouTubeListener() {

                    @Override
                    public void onReady() {
                        // when player is ready.
                    }

                    @Override
                    public void onStateChange(YoutubePlayerView.STATE state) {
                        /**
                         * YoutubePlayerView.STATE
                         *
                         * UNSTARTED, ENDED, PLAYING, PAUSED, BUFFERING, CUED, NONE
                         *
                         */
                    }

                    @Override
                    public void onPlaybackQualityChange(String arg) {
                    }

                    @Override
                    public void onPlaybackRateChange(String arg) {
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onApiChange(String arg) {
                    }

                    @Override
                    public void onCurrentSecond(double second) {
                        // currentTime callback
                    }

                    @Override
                    public void onDuration(double duration) {
                        // total duration
                    }

                    @Override
                    public void logs(String log) {
                        // javascript debug log. you don't need to use it.
                    }
                });


                // psuse video
                youtubePlayerView.pause();
                // play video when it's ready
                youtubePlayerView.play();

            }


        };
        lv.setAdapter(fb);
        return v ;

    }

    public void setC(Context c) {
        this.c = c;
    }

}
