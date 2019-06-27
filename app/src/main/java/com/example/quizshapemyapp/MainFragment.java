package com.example.quizshapemyapp;



import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements AdapterCourse.ItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<Object> image = new ArrayList<>();
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/g"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/h"));

        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/i"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/d"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/j"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/g"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/h"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/i"));

        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/j"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/d"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/g"));
        image.add(Uri.parse("android.resource://com.example.quizshapemyapp/drawable/h"));
        RecyclerView recyclerViewm = view.findViewById(R.id.rv);

        recyclerViewm.setLayoutManager(new GridLayoutManager(getContext(), 2));
        AdapterCourse adapterCourse;

       adapterCourse = new AdapterCourse(getContext(), image);
       // adapterCourse.setClickListener(getActivity());
        recyclerViewm.setAdapter(adapterCourse);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked a button!", Toast.LENGTH_SHORT).show();
            }
        });
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter());
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    private class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            // Create some layout params
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

            // Create some text
            TextView textView = getTextView(container.getContext());
            textView.setText(String.valueOf(position));
            textView.setLayoutParams(layoutParams);

            RelativeLayout layout = new RelativeLayout(container.getContext());
            layout.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.colorPrimary));
            layout.setLayoutParams(layoutParams);

            layout.addView(textView);
            container.addView(layout);
            return layout;
        }

        private TextView getTextView(Context context) {
            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(30);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}