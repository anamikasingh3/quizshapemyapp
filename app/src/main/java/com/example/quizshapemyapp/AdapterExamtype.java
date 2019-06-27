package com.example.quizshapemyapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterExamtype extends RecyclerView.Adapter<AdapterExamtype.ViewHolder> {
    public Context context;
    int totalamount=0;
    ArrayList<ModelExamType> productList;
  //  private OnProductClickListener onProductClickListener;
    private ItemClickListener mClickListener;
   AdapterExamtype(ArrayList<ModelExamType> productList, Context context) {
        this.productList = productList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleexamselection, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Uri image = productList.get(position).getImagetitle();
        holder.examname.setText(productList.get(position).getTitles());
        holder.examquestion.setText(productList.get(position).getQuestions());
        holder.examtime.setText(productList.get(position).getMinutes());

        Glide.with(this.context)
                .load(image)
                .into(holder.examimage);
        holder.examimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,InstructionPage.class);
                context.startActivity(intent);
            }
        });
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,InstructionPage.class);
                context.startActivity(intent);
            }
        });
       // holder.calculatedquantity.setText(String.valueOf(model.quantity));
      }
    @Override
    public int getItemCount() {
        return productList.size();
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView examname,examquestion,examtime;
        ImageView examimage;
        LinearLayout ll;


        ViewHolder(View itemView) {
            super(itemView);
            ll=itemView.findViewById(R.id.ll);
           examname = itemView.findViewById(R.id.examname);
          examquestion = itemView.findViewById(R.id.examquestion);
           examtime= itemView.findViewById(R.id.examtime);
           examimage = itemView.findViewById(R.id.examimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
