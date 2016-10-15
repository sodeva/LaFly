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

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

    public class EnLearn  extends Fragment {
    private ListView lv;
    Typeface roboto;
    FirebaseDatabase database;
    DatabaseReference ref;
    private YouTubePlayer YPlayer;
    Context c ;
        YouTubePlayerSupportFragment youTubePlayerFragment ;
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
               // TextView Date=(TextView)v.findViewById(R.id.date);
                //TextView Name=(TextView)v.findViewById(R.id.heading);
               // Name.setTypeface(roboto);
                //Date.setTypeface(roboto);
                //Name.setText(name);
                //Date.setText(date);

                 YouTubeThumbnailView thumb    = (YouTubeThumbnailView) v.findViewById(R.id.thumb);
                //AIzaSyCzEKeIrR_Cn-lORRuu0z-1PiD0kCYOI4I
              //  thumb.initialize();







            }


        };
        lv.setAdapter(fb);
        return v ;

    }

    public void setC(Context c) {
        this.c = c;
    }

}
