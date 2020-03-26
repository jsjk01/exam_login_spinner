package com.example.exam_login_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ConfirmDetail extends AppCompatActivity implements View.OnClickListener {

    private TextView rec_school,rec_zhuanye,rec_daoshi;
    private MaterialButton final_confirm,final_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_detail);
        initView();
    }

    private void initView() {
        rec_school = findViewById(R.id.rec_school);
        rec_school.setText(getIntent().getStringExtra("school"));
        rec_zhuanye = findViewById(R.id.rec_zhuanye);
        rec_zhuanye.setText(getIntent().getStringExtra("zhuanye"));
        rec_daoshi = findViewById(R.id.rec_daoshi);
        rec_daoshi.setText(getIntent().getStringExtra("daoshi"));

        final_confirm = findViewById(R.id.final_confirm);
        final_back = findViewById(R.id.final_back);
        final_confirm.setOnClickListener(this);
        final_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.final_confirm:
                Intent k = new Intent(getApplicationContext(),Success.class);
                k.putExtra("nowapply",getIntent().getStringExtra("nowapply"));
                startActivity(k);
                finish();
                break;
            case R.id.final_back:
                Intent j = new Intent(getApplicationContext(),SelectDetail.class);
                j.putExtra("nowapply",getIntent().getStringExtra("nowapply"));
                startActivity(j);
                finish();
                break;
        }
    }
}
