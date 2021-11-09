package net.asdprks.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_JAWAB="extra_jawab";
    public static final int RESULT_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RadioGroup rgJawab = (RadioGroup) findViewById(R.id.rgQuiz);
        Button btnJawab=(Button) findViewById(R.id.btnJawab);
        btnJawab.setOnClickListener(v -> {
            int jawab= 0;
            if (rgJawab.getCheckedRadioButtonId()!=0){
                int id=rgJawab.getCheckedRadioButtonId();
                if (id==R.id.rbEmpat)
                    jawab=1;
            }
            Intent hasilIntent=new Intent();
            hasilIntent.putExtra(EXTRA_JAWAB, jawab);
            setResult(RESULT_CODE,hasilIntent);
            finish();
        });
    }
}