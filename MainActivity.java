package com.example.dheo.SubmissionRecyclerView.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dheo.SubmissionRecyclerView.R;
import com.example.dheo.SubmissionRecyclerView.model.Animal;
import com.example.dheo.SubmissionRecyclerView.profile.ProfileActivity;
import com.example.dheo.SubmissionRecyclerView.utils.AnimalsData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

// TODO 4.0 Kemudian kita modifikasi berkas kelas MainActivity kita inisiasikan RecyclerView yang sudah dibuat di activity_main.
// TODO 4.1 Selanjutnya setelah diinisiasikan, kita akan panggil data yang sudah kita buat di kelas AnimasData.


public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.rv_animal)
    RecyclerView rvAnimal;

    private RecyclerView rvAnimals;
    private ArrayList<Animal> list = new ArrayList<>();
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
       // rvAnimals = findViewById(R.id.rv_animal);
        rvAnimals.setHasFixedSize(true);

        list.addAll(AnimalsData.getListData());
        //showRecyclerList();
    }

    //private void showRecyclerList() {
        //rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        //ListAnimalAdapter listAnimalAdapter = new ListAnimalAdapter(list, getApplicationContext());
        //rvAnimals.setAdapter(listAnimalAdapter);
    //}

    //TODO 4.2 Setelah selesai, saatnya kita pasang menu tersebut di MainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_favorite:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onShowList(ArrayList<Animal> data) {
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        ListAnimalAdapter listAnimalAdapter = new ListAnimalAdapter(list, getApplicationContext());
        rvAnimals.setAdapter(listAnimalAdapter);
    }

    @Override
    public void onError(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDettachView() {
        presenter.onDettach();
    }

    @Override
    protected void onStart() {
        onAttachView();
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        onDettachView();
        super.onDestroy();
    }



}

