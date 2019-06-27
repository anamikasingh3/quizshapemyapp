package com.example.quizshapemyapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class Adapterquestion extends RecyclerView.Adapter<Adapterquestion.ViewHolder> {
    public Context context;
    int i = 0;
    ArrayList<Modelquestions> quizList;
    private AdapterNumbering.ItemClickListener mClickListener;

    Adapterquestion(ArrayList<Modelquestions> quizList, Context context) {
        this.quizList = quizList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final int valofi = quizList.get(position).getJumpvalue();
        holder.seekbar.setMax(quizList.size()-1);
        i = valofi;
        holder.seekbar.setEnabled(false);
        holder.questionnumber.setText("Question " + String.valueOf(i + 1));
        holder.seekbar.incrementProgressBy(valofi);
        new CountDownTimer(1800* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                holder.tvtime.setText("Time Remaining : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                holder.tvtime.setText("Completed");
            }
        }.start();
        holder.question.setText(quizList.get(valofi).getQuestion());
        holder.option1.setText("A       " + quizList.get(valofi).getOption1());
        holder.option2.setText("B       " + quizList.get(valofi).getOption2());
        holder.option3.setText("C       " + quizList.get(valofi).getOption3());
        holder.option4.setText("D       " + quizList.get(valofi).getOption4());
        holder.setQuestioncolors(quizList.get(i).selectedanswer);
       holder.checkReview(i);
        if (i <= 0) {
            holder.previous.setEnabled(false);
        }
        if (i >= quizList.size() - 1) {
            holder.next.setEnabled(false);
        }
        holder.checkForClicks(valofi);
        holder.setQuestioncolors(quizList.get(valofi).selectedanswer);
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.showdia();
            }
        });
        holder.reviewtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.reviewtextview.setBackgroundResource(R.drawable.rounded);
                if (quizList.get(valofi).colorvalue == 1) {
                    quizList.get(valofi).colorvalue = 4;
                    holder.reviewtextview.setBackgroundResource(R.drawable.rounded);
                    holder.reviewtextview.setText("Answer Review");
                } else {
                    quizList.get(i).colorvalue = 3;
                    holder.reviewtextview.setBackgroundResource(R.drawable.rounded);
                    holder.reviewtextview.setText("Question Review");
                }
            }
        });
        if (quizList.get(i).colorvalue == 0) {
            quizList.get(i).colorvalue = 2;
        }
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.seekbar.incrementProgressBy(1);
                if (quizList.get(i).colorvalue == 0) {
                    quizList.get(i).colorvalue = 2;
                }
                i = i + 1;
                holder.checkReview(i);
                holder.setQuestioncolors(quizList.get(i).selectedanswer);
                holder.questionnumber.setText("Question " + String.valueOf(i + 1));
                holder.previous.setEnabled(true);
                if (i >= quizList.size() - 1) {
                    holder.next.setEnabled(false);
                }
                holder.question.setText(quizList.get(i).getQuestion());
                holder.option1.setText("A       " + quizList.get(i).getOption1());
                holder.option2.setText("B       " + quizList.get(i).getOption2());
                holder.option3.setText("C       " + quizList.get(i).getOption3());
                holder.option4.setText("D       " + quizList.get(i).getOption4());
                holder.checkForClicks(i);
                holder.reviewtextview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.reviewtextview.setBackgroundResource(R.drawable.rounded);
                        if (quizList.get(i).colorvalue == 1) {
                            quizList.get(i).colorvalue = 4;
                            holder.reviewtextview.setText("Answer Review");
                        } else {
                            quizList.get(i).colorvalue = 3;
                            holder.reviewtextview.setText("Question Review");
                        }
                    }
                });
                holder.submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.showdia();
                    }
                });
                if (quizList.get(i).colorvalue == 0) {
                    quizList.get(i).colorvalue = 2;
                }
            }
        });
        holder.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.seekbar.incrementProgressBy(-1);
                holder.checkForClicks(i);
                i = i - 1;

               holder.checkReview(i);
                holder.questionnumber.setText("Question " + String.valueOf(i + 1));
                holder.setQuestioncolors(quizList.get(i).selectedanswer);
                holder.next.setEnabled(true);
                holder.question.setText(quizList.get(i).getQuestion());
                holder.option1.setText("A       " + quizList.get(i).getOption1());
                holder.option2.setText("B       " + quizList.get(i).getOption2());
                holder.option3.setText("C       " + quizList.get(i).getOption3());
                holder.option4.setText("D       " + quizList.get(i).getOption4());
                if (i <= 0) {
                    holder.previous.setEnabled(false);
                }
                holder.checkForClicks(i);
                holder.reviewtextview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.reviewtextview.setBackgroundResource(R.drawable.rounded);
                        if (quizList.get(i).colorvalue == 1) {
                            quizList.get(i).colorvalue = 4;
                            holder.reviewtextview.setText("Answer Review");
                        } else {
                            quizList.get(i).colorvalue = 3;
                            holder.reviewtextview.setText("Question Review");
                        }
                    }
                });
                holder.submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.showdia();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    String getItem(int id) {
        return quizList.get(id).toString();
    }

    void setClickListener(AdapterNumbering.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button next, previous, submit;
        TextView option1, option2, option3, option4, question, reviewtextview, questionnumber,tvtime;
        View mview;
SeekBar seekbar;
        ViewHolder(View itemView) {
            super(itemView);

            mview = itemView;
            next = itemView.findViewById(R.id.n);
seekbar=itemView.findViewById(R.id.seekBar2);
tvtime=itemView.findViewById(R.id.tvtime);

            submit = itemView.findViewById(R.id.s);
            previous = itemView.findViewById(R.id.p);
            reviewtextview = itemView.findViewById(R.id.markreview);
            questionnumber = itemView.findViewById(R.id.nums);
            option1 = itemView.findViewById(R.id.t1);
            option2 = itemView.findViewById(R.id.t2);
            option3 = itemView.findViewById(R.id.t3);
            option4 = itemView.findViewById(R.id.t4);
            question = itemView.findViewById(R.id.ques);
            itemView.setOnClickListener(this);
        }

        public void setQuestioncolors(int n) {
            switch (n) {
                case 1:
                    option1.setBackgroundResource(R.drawable.selectedoptionss);
                    option2.setBackgroundResource(R.drawable.optionss);
                    option3.setBackgroundResource(R.drawable.optionss);
                    option4.setBackgroundResource(R.drawable.optionss);
                    break;
                case 2:
                    option2.setBackgroundResource(R.drawable.selectedoptionss);
                    option1.setBackgroundResource(R.drawable.optionss);
                    option3.setBackgroundResource(R.drawable.optionss);
                    option4.setBackgroundResource(R.drawable.optionss);
                    break;
                case 3:
                    option3.setBackgroundResource(R.drawable.selectedoptionss);
                    option2.setBackgroundResource(R.drawable.optionss);
                    option1.setBackgroundResource(R.drawable.optionss);
                    option4.setBackgroundResource(R.drawable.optionss);
                    break;
                case 4:
                    option4.setBackgroundResource(R.drawable.selectedoptionss);
                    option2.setBackgroundResource(R.drawable.optionss);
                    option3.setBackgroundResource(R.drawable.optionss);
                    option1.setBackgroundResource(R.drawable.optionss);
                    break;
                default:
                    option4.setBackgroundResource(R.drawable.optionss);
                    option2.setBackgroundResource(R.drawable.optionss);
                    option3.setBackgroundResource(R.drawable.optionss);
                    option1.setBackgroundResource(R.drawable.optionss);
            }
        }

        public void checkForClicks(final int iValue) {
            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quizList.get(iValue).selectedanswer = 1;
                    if (quizList.get(iValue).colorvalue == 3) {
                        reviewtextview.setText("Answer Review");
                        quizList.get(iValue).colorvalue = 4;
                    } else {
                        quizList.get(iValue).colorvalue = 1;
                    }
                    setQuestioncolors(quizList.get(iValue).selectedanswer);
                }
            });
            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quizList.get(iValue).colorvalue == 3) {
                        quizList.get(iValue).colorvalue = 4;
                        reviewtextview.setText("Answer Review");
                    } else {
                        quizList.get(iValue).colorvalue = 1;
                    }
                    quizList.get(iValue).selectedanswer = 2;
                    setQuestioncolors(quizList.get(iValue).selectedanswer);
                }
            });
            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quizList.get(iValue).colorvalue == 3) {
                        reviewtextview.setText("Answer Review");
                        quizList.get(iValue).colorvalue = 4;
                    } else {
                        quizList.get(iValue).colorvalue = 1;
                    }
                    quizList.get(iValue).selectedanswer = 3;
                    setQuestioncolors(quizList.get(iValue).selectedanswer);
                }
            });
            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quizList.get(iValue).colorvalue == 3) {
                        reviewtextview.setText("Answer Review");
                        quizList.get(iValue).colorvalue = 4;
                    } else {
                        quizList.get(iValue).colorvalue = 1;
                    }
                    quizList.get(iValue).selectedanswer = 4;
                    setQuestioncolors(quizList.get(iValue).selectedanswer);

                }
            });
        }
public void checkReview(int ivalue){
    if (quizList.get(ivalue).colorvalue != 3 && quizList.get(ivalue).colorvalue != 4) {
        reviewtextview.setBackgroundResource(R.drawable.purpleunderreview);
       reviewtextview.setText("Mark As Review");
    } else {
       reviewtextview.setBackgroundResource(R.drawable.rounded);
        if(quizList.get(ivalue).colorvalue == 3 ){
reviewtextview.setText("Question Review");}
        else{
           reviewtextview.setText("Answer Review");
        }
    }
}
        public void showdia() {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Are you sure you want to Submit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
