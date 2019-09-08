package com.example.dheo.SubmissionRecyclerView.base;

public interface BasePresenter<V extends BaseView> {

        void onAttach(V view);
        void onDettach();

    }
