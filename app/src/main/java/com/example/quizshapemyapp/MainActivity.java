package com.example.quizshapemyapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements OnQuestionClickListner, Adapterquestion.ItemClickListener {
    LinearLayout ll;
    Adapterquestion adapterquestion;
    int n;
    AdapterNumbering adapterNumbering;
    RecyclerView rvQuiz;
    ArrayList<Modelquestions> ProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvQuiz = findViewById(R.id.rv);
        n=0;
        getSupportActionBar().setTitle("QUIZ");
        ll=findViewById(R.id.ll);
        int pos = getIntent().getIntExtra("pos", 0);
            ProductList = new ArrayList<Modelquestions>();
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method gets the current offset of the first matched element, in pixels, relative to the document?", "offset( )", "offsetParent( )", " position( )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method serializes all forms and form elements like the .serialize() method but returns a JSON data structure for you to work with?", "jQuery.ajax( options )", "jQuery.ajaxSetup( options )", " serialize( )", " serializeArray( )", " serializeArray( )"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", "load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above.s"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method gets the current offset of the first matched element, in pixels, relative to the document?", "offset( )", "offsetParent( )", " position( )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", " load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method serializes all forms and form elements like the .serialize() method but returns a JSON data structure for you to work with?", "jQuery.ajax( options )", "jQuery.ajaxSetup( options )", " serialize( )", " serializeArray( )", " serializeArray( )"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", "load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above.s"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method serializes all forms and form elements like the .serialize() method but returns a JSON data structure for you to work with?", "jQuery.ajax( options )", "jQuery.ajaxSetup( options )", " serialize( )", " serializeArray( )", " serializeArray( )"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", "load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above.s"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method gets the current offset of the first matched element, in pixels, relative to the document?", "offset( )", "offsetParent( )", " position( )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method serializes all forms and form elements like the .serialize() method but returns a JSON data structure for you to work with?", "jQuery.ajax( options )", "jQuery.ajaxSetup( options )", " serialize( )", " serializeArray( )", " serializeArray( )"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", "load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above.s"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method gets the current offset of the first matched element, in pixels, relative to the document?", "offset( )", "offsetParent( )", " position( )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", " load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above."));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method serializes all forms and form elements like the .serialize() method but returns a JSON data structure for you to work with?", "jQuery.ajax( options )", "jQuery.ajaxSetup( options )", " serialize( )", " serializeArray( )", " serializeArray( )"));
            ProductList.add(new Modelquestions(0,pos, "Which of the following jQuery method binds a handler to one or more events (like click) for an element?", "bind( type, [data], fn )", "load(type, [data], fn )", "attach(type, [data], fn )", "None of the above.", "None of the above.s"));
            ll.setVisibility(View.GONE);

            rvQuiz.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
                @Override
                public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {

                    return true;
                }
            });
            adapterquestion = new Adapterquestion(ProductList, this);
            rvQuiz.setAdapter(adapterquestion);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactmenu, menu);


        MenuItem timerItem = menu.findItem(R.id.break_timer);
        final TextView timerText = (TextView) timerItem.getActionView();

        timerText.setPadding(10, 0, 10, 0);
        CountDownTimer timer = new CountDownTimer(1800000, 1000) {

            @Override
            public void onFinish() {
                //TODO Whatever's meant to happen when it finishes
            }

            @Override
            public void onTick(long millisecondsLeft) {

            }
        };
        timer.start();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuresultitem:
                ll.setVisibility(View.VISIBLE);
               rvQuiz.setLayoutManager(new GridLayoutManager(this, 6));
               adapterNumbering= new AdapterNumbering(MainActivity.this,ProductList,this);
n=1;
                rvQuiz.setAdapter(adapterNumbering);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {
        if(n==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.this.finish();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();}
        if(n==1){
            rvQuiz.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
                @Override
                public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {

                    return true;
                }
            });
            adapterquestion = new Adapterquestion(ProductList, this);
            rvQuiz.setAdapter(adapterquestion);
ll.setVisibility(View.GONE);
n=0;
        }
    }

    @Override
    public void onItemClick(View view, int position) { }

    @Override
    public void onQuestionClick() {
        ll.setVisibility(View.GONE);
        rvQuiz.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                return true;
            }
        });
        adapterquestion = new Adapterquestion(ProductList, this);
        rvQuiz.setAdapter(adapterquestion);
    }
}
