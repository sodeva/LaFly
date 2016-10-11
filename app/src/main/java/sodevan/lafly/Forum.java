package sodevan.lafly;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
              String Month = qc.getMonth() ;
              final String Title = qc.getTitle() ;
              String BestAnswer = qc.getBestAnswer()  ;// uid who have given best answer
              final String qid = qc.getQid() ;





              String dday = Month +" "+ Date  ;
              if(answers!=null) {

                  Answerchild answerchild = answers.get(BestAnswer);

                  TextView ansnametv = (TextView) v.findViewById(R.id.ansname);
                  TextView ansdatetv = (TextView) v.findViewById(R.id.ansdate);
                  TextView answertv = (TextView) v.findViewById(R.id.ans);

                  String ansname = answerchild.getName();
                  Long ansdate = answerchild.getDate();
                  String ansmonth = answerchild.getMonth();
                  String ansdday = ansmonth + " " + ansdate;
                  final String answer = answerchild.getAnswer();
                  ansnametv.setText(ansname);
                  ansdatetv.setText(ansdday);
                  answertv.setText(answer);

              }












              TextView Bytv = (TextView)v.findViewById(R.id.By) ;
              TextView Datetv = (TextView)v.findViewById(R.id.date) ;
              TextView  questv = (TextView)v.findViewById(R.id.ques) ;

              Button ansbtn = (Button) v.findViewById(R.id.ansbtn) ;

              ansbtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      Log.d(" TEST : " , " BUTTON" ) ;
                      Intent answerscreen = new Intent(getContext(), AnswerScreen.class) ;
                      answerscreen.putExtra("Ques" , Title ) ;
                      answerscreen.putExtra("qid" , qid) ;
                      startActivity(answerscreen);

                  }
              });



              Bytv.setText(By);
              Datetv.setText(dday);
              questv.setText(Title);




              Typeface questf = Typeface.createFromAsset(c.getAssets() , "Lalezar-Regular.ttf") ;

              questv.setTypeface(questf);


          }
      };


        lv.setAdapter(questionAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("Test : " , "Item:"+position) ;

            }
        });

        return V ;
    }

    public void setC(Context c) {
        this.c = c;
    }

}
