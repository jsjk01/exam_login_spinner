package com.example.exam_login_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class Detail extends AppCompatActivity {

    private ImageView apppage;
    private TextView detailtext,detail_tips;
    private MaterialButton installapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        apppage = findViewById(R.id.app_page);
        apppage.setImageResource(Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra("image"))));
        detailtext = findViewById(R.id.detail_text);
        detailtext.setText(getIntent().getStringExtra("examname"));
        detail_tips = findViewById(R.id.detail_tips);
        detail_tips.setText(getIntent().getStringExtra("tips"));
        installapp = findViewById(R.id.installapp);
        installapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                installapp.setText("正在跳转..");
                Intent i = new Intent(getApplicationContext(),SelectDetail.class);
                i.putExtra("nowapply",detailtext.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}

