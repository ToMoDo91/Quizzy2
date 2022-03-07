package com.ntk.quizzy.Database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Ques_table")
public
class QuestionModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Title")
    private String title;

    @ColumnInfo(name = "AnswerOne")
    private String answerOne;

    @ColumnInfo(name = "AnswerTwo")
    private String answerTwo;

    @ColumnInfo(name = "AnswerThree")
    private String answerThree;

    @ColumnInfo(name = "AnswerFour")
    private String answerFour;

    @ColumnInfo(name = "RightAnswer")
    private int rightAnswer;

    public QuestionModel(String title, String answerOne, String answerTwo, String answerThree, String answerFour, int rightAnswer) {
        this.title = title;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.rightAnswer = rightAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

}