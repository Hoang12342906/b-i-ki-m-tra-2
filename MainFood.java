package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MainFood extends AppCompatActivity {

    ListView lvFood;

    ArrayList<Food> arrayFood;
    FoodAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);
        Objects.requireNonNull(getSupportActionBar()).hide();

        AnhXa();
        adapter = new FoodAdapter(this,R.layout.dong_food,arrayFood);
        lvFood.setAdapter(adapter);

    }



    private void AnhXa() {
        lvFood = findViewById(R.id.listviewFood);
        arrayFood = new ArrayList<>();



        arrayFood.add(new Food("Cây chuối","4.3",R.drawable.caychuoi));
        arrayFood.add(new Food("Cây hoa giấy","10.4",R.drawable.cayhoagiay));
        arrayFood.add(new Food("Cây nguyệt quế","6.3",R.drawable.caynguyetque));
        arrayFood.add(new Food("Cây si","3.3",R.drawable.caysi));
        arrayFood.add(new Food("Cây thông","4.7",R.drawable.caythong));
        arrayFood.add(new Food("Cây lộc vừng","8.4",R.drawable.caylocvung));



        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food fr = arrayFood.get(i);
                doOpenMainActivity(fr.getTen(),fr.getMota(),fr.getHinh());
            }
        });
    }
    public void doOpenMainActivity(String ten, String mota, int hinh)
    {
        Intent myIntent;
        myIntent = new Intent( this, Detail.class);
        myIntent.putExtra("title",ten);
        myIntent.putExtra("des",mota);
        myIntent.putExtra("image",hinh);
        startActivity(myIntent);
    }
}