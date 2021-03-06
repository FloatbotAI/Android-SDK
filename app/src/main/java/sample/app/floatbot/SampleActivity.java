package sample.app.floatbot;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import app.floatbot.FloatbotAttributes;
import app.floatbot.FloatbotFragment;
import app.floatbot.FloatbotUtils;

public class SampleActivity extends AppCompatActivity implements FloatbotFragment.OnFloatbotInteractionListener{

    FloatbotFragment flb;
    FrameLayout addView;

    @Override
    public void onChatWindowClosed() {
        finish();
    }


    @Override
    public void onCallback(Uri uri) {
        Log.e("callback",uri.toString());
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        addView = (FrameLayout) findViewById(R.id.addView);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        flb =  new FloatbotFragment();
        Bundle bundle = new Bundle();
        bundle.putString("bot_id","5dad7272e629363ee04ecda2");
        bundle.putString("key","lwf29rMeVOuYFCHDEztZNqA8aKo");
        bundle.putBoolean("showHeader",true);

        //Will create new Session of user everytime
        bundle.putBoolean("create_new_session",true);

        //bundle.putString("push_token",<FCM TOKEN>);
        //bundle.putString("data",<AES-CBC-256 Encrypted Json String>);

        //To set attributes directly from SDK
        /* FloatbotAttributes attributes = new FloatbotAttributes();
        try {
            attributes.addAttributes("name","user-name");
            bundle.putString("attributes",attributes.value());
        } catch (Exception e) {

        }*/
        
        flb.setArguments(bundle);
        transaction.replace(R.id.addView,flb);
        transaction.commit();

        //To show list of session to users in chatbot uncomment below function
        //flb.showSessions();

        /*Get floatbot user id from SDK*/
        //FloatbotUtils.getFloatbotUserID(this);

        /*Set Customized view for loading screen*/
        //FloatbotUtils.setLoadingView(this,R.layout.connecting);

        /* Set customized view for no internet connection*/
        //FloatbotUtils.setNoInternetConnectionView(this,R.layout.nointernet);

        /* To clear floatbot user data from app */
        //FloatbotUtils.clearUserData(this);

        /* To update token in floatbot, call below function with new push token */
        //FloatbotUtils. ("<FCM TOKEN>");

    }
}
