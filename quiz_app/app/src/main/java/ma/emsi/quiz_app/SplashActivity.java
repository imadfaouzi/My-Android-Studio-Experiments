package ma.emsi.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    public static ArrayList<Modelclass> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        listOfQ = new ArrayList<>();
        listOfQ.add(new Modelclass("What is the capital of Spain?", "Barcelona", "Madrid", "Seville", "Valencia", "Madrid"));
        listOfQ.add(new Modelclass("What is the highest mountain in the world?", "Mount Kilimanjaro", "Mount Everest", "Mount Fuji", "Mount McKinley", "Mount Everest"));
        listOfQ.add(new Modelclass("Who wrote the Harry Potter series?", "J.K. Rowling", "Stephen King", "Dan Brown", "Agatha Christie", "J.K. Rowling"));
        listOfQ.add(new Modelclass("What is the largest continent by land area?", "Asia", "Europe", "North America", "South America", "Asia"));
        listOfQ.add(new Modelclass("What is the currency of Japan?", "Dollar", "Pound", "Euro", "Yen", "Yen"));
        listOfQ.add(new Modelclass("What is the name of the largest ocean?", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean", "Pacific Ocean"));
        listOfQ.add(new Modelclass("What is the chemical symbol for gold?", "Gd", "Au", "Ag", "Cu", "Au"));
        listOfQ.add(new Modelclass("What is the name of the planet we live on?", "Venus", "Mars", "Jupiter", "Earth", "Earth"));
        listOfQ.add(new Modelclass("Who is the current President of the United States?", "Joe Biden", "Barack Obama", "Donald Trump", "George W. Bush", "Joe Biden"));
        listOfQ.add(new Modelclass("What is the name of the first man to walk on the moon?", "Buzz Aldrin", "Michael Collins", "Neil Armstrong", "Yuri Gagarin", "Neil Armstrong"));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }, 1500);
    }
}