package sodevan.lafly;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Forum extends Fragment {

    Context c ;
    FirebaseDatabase database ;
    DatabaseReference reference ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.activity_forum ,container  , false) ;

        database = FirebaseDatabase.getInstance() ;
        reference = database.getReference("ForumQues")  ;

        ListView lv = (ListView) V.findViewById(R.id.forumques) ;


      FirebaseListAdapter<Questionchild> questionAdapter = new FirebaseListAdapter<Questionchild>(getActivity() ,Questionchild.class , R.layout.forum_child, reference ) {
          @Override
          protected void populateView(View v, Questionchild qc, int position) {

              HashMap<String ,Answerchild> answers = new HashMap<>() ;
              answers = qc.getAnswers() ;
              String By = qc.getBy() ;
                By = "Asked By : "+By ;
              Long Date = qc.getDate() ;
              String Description = qc.getDescription() ;
              String Month = qc.getMonth() ;
              String Title = qc.getTitle() ;
              String BestAnswer = qc.getBestAnswer()  ; // uid who have given best answer


              String dday = Month +" "+ Date  ;

              Answerchild answerchild = answers.get(BestAnswer) ;

              String ansname = answerchild.getName() ;
              Long ansdate  = answerchild.getDate() ;
              String ansmonth = answerchild .getMonth() ;
              String ansdday  =  ansmonth + " " + ansdate ;
              String answer = answerchild.getAnswer() ;









              TextView Bytv = (TextView)v.findViewById(R.id.By) ;
              TextView Datetv = (TextView)v.findViewById(R.id.date) ;
              TextView  questv = (TextView)v.findViewById(R.id.ques) ;
              TextView ansnametv = (TextView)v.findViewById(R.id.ansname) ;
              TextView ansdatetv = (TextView)v.findViewById(R.id.ansdate) ;
              TextView answertv = (TextView)v.findViewById(R.id.ans) ;


              Bytv.setText(By);
              Datetv.setText(dday);
              questv.setText(Title);
              ansnametv.setText(ansname);
              ansdatetv.setText(ansdday);
              answertv.setText(answer);


              Typeface questf = Typeface.createFromAsset(c.getAssets() , "Lalezar-Regular.ttf") ;

              questv.setTypeface(questf);


          }
      };


        lv.setAdapter(questionAdapter);

        return V ;
    }

    public void setC(Context c) {
        this.c = c;
    }

}
