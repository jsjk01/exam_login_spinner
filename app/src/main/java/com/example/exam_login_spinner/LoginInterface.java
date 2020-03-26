package com.example.exam_login_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class LoginInterface extends AppCompatActivity implements View.OnClickListener {

    private EditText student_name,student_passwd;
    private MaterialButton account_confirm,account_signup;
    private TextView signup_username,signup_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);
        initView();



    }

    private void initView() {
        //获取文本控件
        student_name = findViewById(R.id.student_name);
        student_passwd = findViewById(R.id.student_passwd);
        //获取按钮控件
        account_confirm = findViewById(R.id.account_confirm);
        account_signup = findViewById(R.id.account_signup);
        account_confirm.setOnClickListener(this);
        account_signup.setOnClickListener(this);
        //暂存机制
        signup_username = findViewById(R.id.signup_username);
        signup_passwd = findViewById(R.id.signup_passwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_confirm:
                    if((student_name.getText().toString().equals("student") && student_passwd.getText().toString().equals("666666"))
                            || (!student_name.getText().toString().isEmpty() && !student_passwd.getText().toString().isEmpty()) && (student_name.getText().toString().equals(signup_username.getText().toString()) && student_passwd.getText().toString().equals(signup_passwd.getText().toString()))){
                        Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        student_name.setText("");
                        student_passwd.setText("");
                    }
                    break;
            case R.id.account_signup:
                if(student_name.getText().toString().isEmpty() || student_passwd.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"请输入正确的用户名和密码",Toast.LENGTH_SHORT).show();
                    student_name.setText("");
                    student_passwd.setText("");
                }else {
                    signup_username.setText(student_name.getText().toString());
                    signup_passwd.setText(student_passwd.getText().toString());
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    student_name.setText("");
                    student_passwd.setText("");
                }
        }
    }
}
