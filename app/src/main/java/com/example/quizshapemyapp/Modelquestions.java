package com.example.quizshapemyapp;

public class Modelquestions {
    String question;
    String option1;
    String option2;
    int jumpvalue;
    int colorvalue;
    String option3;
    String option4;
    int selectedanswer;
    String answerstring;
    Modelquestions(){}

    public Modelquestions(int colorvalue,int jumpvalue,String question, String option1, String option2, String option3, String option4, String answerstring) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.colorvalue=colorvalue;
        this.selectedanswer = selectedanswer;
        this.answerstring = answerstring;
        this.jumpvalue=jumpvalue;
    }

    public int getColorvalue() { return colorvalue; }
    public void setColorvalue(int colorvalue) { this.colorvalue = colorvalue; }
    public int getJumpvalue() {
        return jumpvalue;
    }
    public void setJumpvalue(int jumpvalue) {
        this.jumpvalue = jumpvalue;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public int getSelectedanswer() {
        return selectedanswer;
    }
    public void setSelectedanswer(int selectedanswer) {
        this.selectedanswer = selectedanswer;
    }
    public String getAnswerstring() {
        return answerstring;
    }
    public void setAnswerstring(String answerstring) {
        this.answerstring = answerstring;
    }

}
