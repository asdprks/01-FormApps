package net.asdprks.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PHONE = "extra_phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputName=(EditText) findViewById(R.id.idInputNama);
        EditText inputEmail=(EditText) findViewById(R.id.idInputEmail);
        EditText inputPhone=(EditText) findViewById(R.id.idInputNomor);
        EditText inputPass=(EditText) findViewById(R.id.idInputPassword);

        Button btnSave=(Button) findViewById(R.id.idButtonSave);
        btnSave.setOnClickListener(v ->  {
            Intent loginIntent = new Intent(MainActivity.this, DashboardActivity.class);
            loginIntent.putExtra(EXTRA_NAME, inputName.getText().toString());
            loginIntent.putExtra(EXTRA_EMAIL, inputEmail.getText().toString());
            loginIntent.putExtra(EXTRA_PHONE, inputPhone.getText().toString());
            startActivity(loginIntent);
        });

    }

    private void showLog(String text) {
        Log.d(getPackageName(), text);
    }

    @Override
    protected void onRestart() {
        super.onRestart(); //call to restart after onStop
        showLog("Activity restarted");
    }

    @Override
    protected void onStart() {
        super.onStart(); //soon be visible
        showLog("Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume(); //visible
        showLog("Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause(); //invisible
        showLog("Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("Activity is being destroyed");
    }


}