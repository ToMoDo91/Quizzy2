package com.ntk.quizzy.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ntk.quizzy.Database.QuestionModel;
import com.ntk.quizzy.Repositories.Repository;

public class AddQuesViewModel extends AndroidViewModel {

    private Repository repo;

    public AddQuesViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
    }

    public boolean AddQuesToRepo(String Title, String An1, String An2, String An3, String An4, String RightAn) {

        if (
                Title != null && !Title.trim().isEmpty() &&
                        An1 != null && !An1.trim().isEmpty() &&
                        An2 != null && !An2.trim().isEmpty() &&
                        An3 != null && !An3.trim().isEmpty() &&
                        An4 != null && !An4.trim().isEmpty() &&
                        RightAn != null && !RightAn.trim().isEmpty()) {

            if (isInteger(RightAn)) {

                int Right = Integer.parseInt(RightAn);
                if (1 <= Right && Right <= 4) {


                    QuestionModel Nq = new QuestionModel(Title, An1, An2, An3, An4, Right);
                    repo.insert(Nq);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }
        return false;
    }

    //Not needed just extra :-)
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}


