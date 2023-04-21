package ma.emsi.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WongActivity extends AppCompatActivity {

//    ProgressBar
    private ProgressBar progressBar;
    private TextView progressText;

    int correct, wrong, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wong);

        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);

        correct=getIntent().getIntExtra("correct", 0);
        wrong=getIntent().getIntExtra("wrong", 0);
        total=getIntent().getIntExtra("total_Questions", 0);

        progressText.setText(correct+"/"+total);

        int progress = 90; // the progress value as a percentage
        int maxProgress = 100; // the maximum progress value
        int progressValue = (int) (correct / 100 * total); // calculate the progress value
        progressBar.setMax(maxProgress); // set the maximum progress value
        progressBar.setProgress(progressValue); // set the progress value


    }
}