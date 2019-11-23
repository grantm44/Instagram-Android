package android.example.instagram_app;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("grant-mcdonnal-instagram") // should correspond to APP_ID env variable
            .clientKey("myMasterKeyParse")  // set explicitly unless clientKey is explicitly configured on Parse server
            .server("http://grant-mcdonnal-instagram.herokuapp.com/parse/").build());
    }
}
