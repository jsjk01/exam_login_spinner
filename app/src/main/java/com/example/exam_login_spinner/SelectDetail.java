package com.example.exam_login_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class SelectDetail extends AppCompatActivity {

    private TextView now_apply;
    private Spinner xuexiaoxuanze,zhuanyexuanze,daoshixuanze;
    private String school;
    private String zhuanye;
    private String daoshi;
    private MaterialButton confirm_detail;
    private TextView cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_detail);
        initView();
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initView() {
        cache = findViewById(R.id.cache);
        cache.setText(getIntent().getStringExtra("nowapply"));

        now_apply = findViewById(R.id.now_apply);
        now_apply.setText("提醒：你正在申请 " + cache.getText().toString() + " 考试");

        xuexiaoxuanze = findViewById(R.id.school_spinner);
        xuexiaoxuanze.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        zhuanyexuanze = findViewById(R.id.class_spinner);
        zhuanyexuanze.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zhuanye = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        daoshixuanze = findViewById(R.id.daoshi_spinner);
        daoshixuanze.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                daoshi = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        confirm_detail = findViewById(R.id.confirm_detail);
        confirm_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ConfirmDetail.class);
                i.putExtra("school",school);
                i.putExtra("zhuanye",zhuanye);
                i.putExtra("daoshi",daoshi);
                i.putExtra("nowapply",cache.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }
}
