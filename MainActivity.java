package com.example.apptonghop;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText emailedit,passedit;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mAuth=FirebaseAuth.getInstance();

        emailedit = findViewById(R.id.userSignin);
        passedit = findViewById(R.id.passSignin);

        Button bt_chuyen_Signup = (Button) findViewById(R.id.bt_chuyensignup);
        Button btSignin = (Button) findViewById(R.id.buttonSignin);

        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        bt_chuyen_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenChuyensignupActivity();
            }
        });
    }

    public void doOpenHomeActivity()
    {
        Intent myIntent=new Intent(this, Home.class);
        startActivity(myIntent);
    }
    public void doOpenChuyensignupActivity()
    {
        Intent myIntent=new Intent(this, sign_up.class);
        startActivity(myIntent);
    }
    public void login(){
        String email,pass;
        email = emailedit.getText().toString();
        pass = passedit.getText().toString();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui long nhap email!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui long nhap password!",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Dang nhap thanh cong!",Toast.LENGTH_SHORT).show();
                    doOpenHomeActivity();
                }else {
                    Toast.makeText(getApplicationContext(),"Dang nhap khong thanh cong!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}