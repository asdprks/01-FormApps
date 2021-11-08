package net.asdprks.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputName=(EditText) findViewById(R.id.idInputNama);
        EditText inputEmail=(EditText) findViewById(R.id.idInputEmail);
        EditText inputPhone=(EditText) findViewById(R.id.idInputNomor);
        EditText inputPass=(EditText) findViewById(R.id.idInputPassword);

        Button btnSave=(Button) findViewById(R.id.idButtonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("--Nama--",inputName.getText().toString());
                Log.d("--Email--",inputEmail.getText().toString());
                Log.d("--Phone--",inputPhone.getText().toString());
                Log.d("--Password--",inputPass.getText().toString());


            }
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