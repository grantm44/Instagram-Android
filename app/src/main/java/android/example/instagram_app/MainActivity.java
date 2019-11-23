package android.example.instagram_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.example.instagram_app.fragments.CameraFragment;
import android.example.instagram_app.fragments.PostsFragment;
import android.example.instagram_app.fragments.ProfileFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";


    private BottomNavigationView bottonNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottonNavigation = findViewById(R.id.bottom_navigation);

        bottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_camera:
                        fragment = new CameraFragment();
                        Toast.makeText(MainActivity.this, "Clicked camera - make post", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_home:
                        fragment = new PostsFragment();
                        Toast.makeText(MainActivity.this, "Clicked home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_logout:
                        fragment = new ProfileFragment();
                        Toast.makeText(MainActivity.this, "Clicked profile", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        fragment = new CameraFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottonNavigation.setSelectedItemId(R.id.action_home);
    }

}