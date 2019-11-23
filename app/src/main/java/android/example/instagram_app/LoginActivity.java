package android.example.instagram_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.example.instagram_app.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btLogin = findViewById(R.id.login);

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Log.d(TAG, "value: " + username + " " + password);
                login(username, password);
            }
        });
    }

    private void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {

            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with login");

                    e.printStackTrace();
                    return;
                }
                goMainActivity();
            }
        });
    }

    private void logout(){
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser();
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
