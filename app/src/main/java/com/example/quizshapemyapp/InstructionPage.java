package com.example.quizshapemyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionPage extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_page);
        getSupportActionBar().setTitle("Instructions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
btn=findViewById(R.id.btn);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(InstructionPage.this,MainActivity.class);
        startActivity(intent);
    }
});
    }
}
