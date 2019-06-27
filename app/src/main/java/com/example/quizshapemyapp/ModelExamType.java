package com.example.quizshapemyapp;

import android.net.Uri;

public class ModelExamType {
    String minutes ;

    public ModelExamType(Uri imagetitle, String minutes, String questions, String titles) {
        this.minutes = minutes;
        this.questions = questions;
        this.titles = titles;
        this.imagetitle = imagetitle;
    }
ModelExamType(){}
    String questions;

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public Uri getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(Uri imagetitle) {
        this.imagetitle = imagetitle;
    }

    String titles;
   Uri imagetitle;
}
