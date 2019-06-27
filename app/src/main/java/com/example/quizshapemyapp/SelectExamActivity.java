package com.example.quizshapemyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SelectExamActivity extends AppCompatActivity implements  AdapterExamtype.ItemClickListener{
AdapterExamtype adapterExamtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exam);
        getSupportActionBar().setTitle("Exam Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<ModelExamType> ProductList = new ArrayList<ModelExamType>();
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/g"), "60 Minutes","30 Questions","Maths Quiz"));
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/h"),"60 Minutes","30 Questions","English Quiz"));
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/i"), "60 Minutes","30 Questions","Science Quiz"));
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/j"),"60 Minutes","30 Questions","Computer Science Quiz"));
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/g"),"60 Minutes","30 Questions","IP Quiz"));
        ProductList.add(new ModelExamType(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/d"),"60 Minutes","30 Questions","Basic Overall Exam Quiz"));
        RecyclerView recyclerviewproduct = findViewById(R.id.rv);
        recyclerviewproduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {

                return true;
            }
        });
       adapterExamtype = new AdapterExamtype(ProductList, this);
     //  adapterExamtype.setClickListener(MainActivity.this);
        recyclerviewproduct.setAdapter(adapterExamtype);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
