package ma.emsi.login_register_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button logoutBtn;
    TextView profile_email, profile_name;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        logoutBtn = findViewById(R.id.btn_logout);
        profile_email = findViewById(R.id.profile_email);
        profile_name = findViewById(R.id.profile_name);

        if(user == null){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }else{
            profile_email.setText(user.getEmail());
        }


        // Logout
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

    }
}