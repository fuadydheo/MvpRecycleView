package com.example.dheo.SubmissionRecyclerView.main;

import com.example.dheo.SubmissionRecyclerView.base.BaseView;
import com.example.dheo.SubmissionRecyclerView.model.Animal;

import java.util.ArrayList;

public interface MainContract {
        interface Presenter{
            void getData();
        }

        interface View extends BaseView {
            void onShowList(ArrayList<Animal> data);
            void onError(String Message);
        }


    }
