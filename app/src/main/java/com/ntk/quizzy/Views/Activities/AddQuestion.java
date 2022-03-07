package com.ntk.quizzy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ntk.quizzy.R;
import com.ntk.quizzy.ViewModels.AddQuesViewModel;

public class AddQuestion extends AppCompatActivity {

    private EditText addQTitle, addQop1, addQop2, addQop3, addQop4, addRight;
    private Button save;

    private AddQuesViewModel AQVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        ///Binding
        addQTitle = findViewById(R.id.addQTitle);
        addQop1 = findViewById(R.id.addQop1);
        addQop2 = findViewById(R.id.addQop2);
        addQop3 = findViewById(R.id.addQop3);
        addQop4 = findViewById(R.id.addQop4);
        addRight = findViewById(R.id.addRight);
        save = findViewById(R.id.addQsave);
        ///Binding

        /////// Bind ViewModel ///////
        AQVM = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(AddQuesViewModel.class);
        /////// Bind ViewModel ///////

        /////////////////// startQuiz Section ///////////////////
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean x = AQVM.AddQuesToRepo(addQTitle.getText().toString(), addQop1.getText().toString(), addQop2.getText().toString(), addQop3.getText().toString(), addQop4.getText().toString(), addRight.getText().toString());
                        if (x) {
                            Toast.makeText(AddQuestion.this, "Saved", Toast.LENGTH_SHORT).show();
                            close();

                        } else {
                            Toast.makeText(AddQuestion.this, "Please add logical question", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );
        /////////////////// startQuiz Section ///////////////////


    }

    public void close() {
        this.finish();
    }

}