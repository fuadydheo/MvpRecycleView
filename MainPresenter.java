package com.example.dheo.SubmissionRecyclerView.main;

import com.example.dheo.SubmissionRecyclerView.base.BasePresenter;
import com.example.dheo.SubmissionRecyclerView.utils.AnimalsData;

public class MainPresenter implements BasePresenter<MainContract.View>, MainContract.Presenter {

        MainContract.View view;

        public MainPresenter(MainContract.View view){
            this.view = view;
        }


        @Override
        public void onAttach(MainContract.View view) {
            this.view = view;
        }

        @Override
        public void onDettach() {
            this.view = null;
        }

        @Override
        public void getData() {
            view.onShowList(AnimalsData.getListData());
            view.onError("Gagal Dalam Ambil Data");
        }



    }
