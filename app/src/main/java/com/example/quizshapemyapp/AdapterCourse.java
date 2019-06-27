package com.example.quizshapemyapp;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterCourse extends RecyclerView.Adapter<AdapterCourse.ViewHolder> {

    private List<Object> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ImageView imgs;
    public Context context;
    // data is passed into the constructor
   AdapterCourse(Context context, List<Object> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.singlecourseview, parent, false);
        context=parent.getContext();

        return new ViewHolder(view);


    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String description = mData.get(position).toString();
        Glide.with(context).load(description).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SelectExamActivity.class);
                context.startActivity(intent);
            }
        });
        holder.setdesctext(description);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView imageView;
        private View mview;
        ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
            mview=itemView;
        } public void setdesctext(String des)
        {

            // TextView tv=mview.findViewById(R.id.textView4);
            // tv.setText("It is ones happy and surprised.flatter them with exquisite");
            // TextView tvin=mview.findViewById(R.id.textView3);
            //tvin.setText("Title");
            //TextView tvins=mview.findViewById(R.id.textView3);
            //tvins.setText("Anand Vihar");

            //TextView tvinn=mview.findViewById(R.id.textView5);
            //tvinn.setText("Rs 1000");
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id).toString();
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}