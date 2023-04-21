package ma.emsi.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressBar;
    List<Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index = 0;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nex_btn;
//    -----------------------------
    TextView card_question, opa, opb, opc, opd;
    CardView cardOA,cardOB, cardOC, cardOD;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        allQuestionsList= SplashActivity.listOfQ;
        Collections.shuffle(allQuestionsList);
        modelclass = allQuestionsList.get(index);

        Hooks();
        resetColor();
        setAllData();
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Calculate the remaining seconds and update the progress bar
                timerValue = (int) (millisUntilFinished / 1000);
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                // Show a dialog when the timer finishes
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);
                dialog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
    }

    private void setAllData() {
        enableButton();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
        nex_btn.setClickable(false);
        card_question.setText(modelclass.getQuestion());
        opa.setText(modelclass.getoA());
        opb.setText(modelclass.getoB());
        opc.setText(modelclass.getoC());
        opd.setText(modelclass.getoD());
        timerValue = 20;
        progressBar.setProgress(progressBar.getMax());
        if(countDownTimer != null){
            countDownTimer.start();
        }
    }

    private void Hooks(){
        progressBar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        opa = findViewById(R.id.opa);
        opb = findViewById(R.id.opb);
        opc = findViewById(R.id.opc);
        opd = findViewById(R.id.opd);
        cardOA = findViewById(R.id.card_oa);
        cardOB = findViewById(R.id.card_ob);
        cardOC = findViewById(R.id.card_oc);
        cardOD = findViewById(R.id.card_od);

        nex_btn = findViewById(R.id.next_btn);

    }

    private void Correct(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.green_quiz));
        nex_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                if(index < allQuestionsList.size()-1) {
                    index++;
                    modelclass = allQuestionsList.get(index);
                    setAllData();
                    resetColor();
                }else{
                    GameWon();
                }
            }
        });
    }

    private void Wrong(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.red_quiz));
        nex_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if(index < allQuestionsList.size()-1){
                    index++;
                    modelclass = allQuestionsList.get(index);
                    setAllData();
                    resetColor();
                }else{
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WongActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        intent.putExtra("total_Questions", allQuestionsList.size());
        startActivity(intent);
    }


    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }
    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white_quiz));
        opa.setTextColor(getResources().getColor(R.color.black));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white_quiz));
        opb.setTextColor(getResources().getColor(R.color.black));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white_quiz));
        opc.setTextColor(getResources().getColor(R.color.black));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white_quiz));
        opd.setTextColor(getResources().getColor(R.color.black));
    }

    public void OptionAClick(View view){
        disableButton();
        nex_btn.setClickable(true);
       if(modelclass.getoA().equals(modelclass.getAns())){

           if(index < allQuestionsList.size() - 1 ){
               Correct(cardOA);
           }else{
               GameWon();
           }

       }else{
           Wrong(cardOA);
       }
    }

    public void OptionBClick(View view){
        disableButton();
        nex_btn.setClickable(true);
        if(modelclass.getoB().equals(modelclass.getAns())){
            if(index < allQuestionsList.size() - 1 ){
                Correct(cardOB);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOB);
        }
    }
    public void OptionCClick(View view){
        disableButton();
        nex_btn.setClickable(true);
        if(modelclass.getoC().equals(modelclass.getAns())){
            if(index < allQuestionsList.size() - 1 ){
                Correct(cardOC);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOC);
        }
    }
    public void OptionDClick(View view){
        disableButton();
        nex_btn.setClickable(true);
        if(modelclass.getoD().equals(modelclass.getAns())){
            if(index < allQuestionsList.size() - 1 ){
                Correct(cardOD);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOD);
        }
    }


}