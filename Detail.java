package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        TextView tvTitle = (TextView) findViewById(R.id.tv_dt_title);
        TextView tvDes =(TextView) findViewById(R.id.tv_dt_des);
        ImageView imageView = (ImageView) findViewById(R.id.iv_dt_ha);
        tvTitle.setText(intent.getStringExtra("title"));
        tvDes.setText(intent.getStringExtra("des"));
        imageView.setImageResource(intent.getIntExtra("image",R.id.imgviewHinh));

        Button button = (Button) findViewById(R.id.buton_muahang);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpentListviewActivity();
            }
        });
    }
    private void doOpentListviewActivity(){
        Intent intent = new Intent(this, MainFood.class);
        startActivity(intent);
    }
}