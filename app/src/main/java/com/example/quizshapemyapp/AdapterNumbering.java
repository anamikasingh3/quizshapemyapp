package com.example.quizshapemyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterNumbering extends RecyclerView.Adapter<AdapterNumbering.ViewHolder> {

    private ArrayList<Modelquestions> numberList;
    private LayoutInflater mInflater;
    private OnQuestionClickListner onQuestionClickListner;
    private ItemClickListener mClickListener;
    public Context context;

    AdapterNumbering(Context context, ArrayList<Modelquestions> data, OnQuestionClickListner onQuestionClickListner) {
        this.mInflater = LayoutInflater.from(context);
        this.numberList = data;
        this.onQuestionClickListner = onQuestionClickListner;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.singlebutton, parent, false);
        context=parent.getContext();
        return new ViewHolder(view);


    }
    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {

        Object description = numberList.get(position);
        int m= numberList.get(position).getColorvalue();
        if(m==3){
            holder.numbertext.setBackgroundResource(R.drawable.reviewagain);
        }
        if(m==2){
            holder.numbertext.setBackgroundResource(R.drawable.redd);
        }
        if(m==1){
            holder.numbertext.setBackgroundResource(R.drawable.green);
        }
        if(m==4){
            holder.numbertext.setBackgroundResource(R.drawable.answerasreview);
        }


        holder.setdesctext(String.valueOf(position+1));
        holder.numbertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.get(0).jumpvalue=position;
               onQuestionClickListner.onQuestionClick();

            }
       });
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView numbertext;
        private View mview;
        ViewHolder(View itemView) {
            super(itemView);
numbertext =itemView.findViewById(R.id.tv);
            mview=itemView;
        } public void setdesctext(String des) {
            numbertext.setText(des);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    String getItem(int id) {
        return numberList.get(id).toString();
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}