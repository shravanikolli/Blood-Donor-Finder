package shravs.com.blooddonorfinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Activity {

    private static final String TAG = "Register";
    TextView errorMsg;
    EditText nameET,emailET,pwdET,ageET,bgroupET,contactET,addLine1ET,addLine2ET, cityET,stateET,countryET,zipET,usernameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"hellooooooo");
        setContentView(R.layout.activity_register);

        // Initiating service.
        Intent intent = new Intent(this, RestFulServices.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

        errorMsg = (TextView)findViewById(R.id.errorMsgTV);
        nameET = (EditText)findViewById(R.id.nameET);
        emailET = (EditText)findViewById(R.id.emailET);
        pwdET = (EditText)findViewById(R.id.passwordET);
        ageET = (EditText)findViewById(R.id.ageET);
        bgroupET = (EditText)findViewById(R.id.bloodGroupET);
        contactET = (EditText)findViewById(R.id.bloodGroupET);
        addLine1ET = (EditText)findViewById(R.id.bloodGroupET);
        addLine2ET = (EditText)findViewById(R.id.bloodGroupET);
        cityET = (EditText)findViewById(R.id.bloodGroupET);
        stateET = (EditText)findViewById(R.id.bloodGroupET);
        countryET = (EditText)findViewById(R.id.bloodGroupET);
        zipET = (EditText)findViewById(R.id.bloodGroupET);
        usernameET = (EditText)findViewById(R.id.bloodGroupET);
    }

    public void registerUser(View view){

        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        String password = pwdET.getText().toString();


        //Create a http request object and pass all the values into it and then write a method to invoke webservice


/*        Intent loginIntent = new Intent(getApplicationContext(),Login.class);
        startActivity(loginIntent);*/
        String response = myService.register("GOD IS ONE");
        Log.d(TAG,"response = "+response);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    RestFulServices myService;
    boolean isBound = false;

    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            RestFulServices.MyLocalBinder binder = (RestFulServices.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }

    };
}
