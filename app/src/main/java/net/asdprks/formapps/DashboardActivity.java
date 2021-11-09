package net.asdprks.formapps;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvName=(TextView) findViewById(R.id.tvName);
        TextView tvEmail=(TextView) findViewById(R.id.tvEmail);
        TextView tvPhone=(TextView) findViewById(R.id.tvPhone);

        tvName.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME));
        tvEmail.setText(getIntent().getStringExtra(MainActivity.EXTRA_EMAIL));
        tvPhone.setText(getIntent().getStringExtra(MainActivity.EXTRA_PHONE));

        Button btnCall=(Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(v -> {
            String nomor="*123##";
            Intent callIntent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomor));
            startActivity(callIntent);
        });

        Button btnQuiz=(Button) findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(v -> {
            Intent loginQuiz =new Intent(DashboardActivity.this, QuizActivity.class);
            resultLauncher.launch(loginQuiz);
        });

        TextView tvHasilQuiz=(TextView) findViewById(R.id.tvHasilQuiz);
        resultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode()==QuizActivity.RESULT_CODE && result.getData()!=null){
                        int jawab=result.getData().getIntExtra(QuizActivity.EXTRA_JAWAB,0);
                        if (jawab==1)
                            tvHasilQuiz.setText("Selamat, jawaban anda Benar!");
                        else tvHasilQuiz.setText("Maaf, jawaban anda Salah!");
                    }
                });
    }
}