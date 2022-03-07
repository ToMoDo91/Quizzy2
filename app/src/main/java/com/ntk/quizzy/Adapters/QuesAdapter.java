package com.ntk.quizzy.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ntk.quizzy.Database.QuestionModel;
import com.ntk.quizzy.R;

import java.util.ArrayList;
import java.util.List;

public class QuesAdapter extends RecyclerView.Adapter<QuesAdapter.QuesHolder> {
    private List<QuestionModel> listOfQues = new ArrayList<>();

    @NonNull
    @Override
    public QuesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ques_item, parent, false);
        return new QuesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuesHolder holder, int position) {
        QuestionModel currentQuestion = listOfQues.get(position);
        holder.textViewTitle.setText(currentQuestion.getTitle());
        holder.textViewAnswerOne.setText(currentQuestion.getAnswerOne());
        holder.textViewAnswerTwo.setText(currentQuestion.getAnswerTwo());
        holder.textViewAnswerThree.setText(currentQuestion.getAnswerThree());
        holder.textViewAnswerFour.setText(currentQuestion.getAnswerFour());
        holder.NumbRightAnswer.setText(String.valueOf(currentQuestion.getRightAnswer()));
    }

    @Override
    public int getItemCount() {
        return listOfQues.size();
    }

    public void setQues(List<QuestionModel> listOfQues) {
        this.listOfQues = listOfQues;
        notifyDataSetChanged();
    }

    public QuestionModel GetQuestionAt(int position) {
        return listOfQues.get(position);
    }

    class QuesHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle;
        private TextView textViewAnswerOne;
        private TextView textViewAnswerTwo;
        private TextView textViewAnswerThree;
        private TextView textViewAnswerFour;
        private TextView NumbRightAnswer;

        public QuesHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.TextViewTitle);
            textViewAnswerOne = itemView.findViewById(R.id.TextViewAnswerOne);
            textViewAnswerTwo = itemView.findViewById(R.id.TextViewAnswerTwo);
            textViewAnswerThree = itemView.findViewById(R.id.TextViewAnswerThree);
            textViewAnswerFour = itemView.findViewById(R.id.TextViewAnswerFour);
            NumbRightAnswer = itemView.findViewById(R.id.NumbRightAnswer);
        }
    }
}