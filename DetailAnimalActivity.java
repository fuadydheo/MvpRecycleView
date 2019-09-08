package com.example.dheo.SubmissionRecyclerView.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dheo.SubmissionRecyclerView.R;
import com.example.dheo.SubmissionRecyclerView.model.Animal;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

// TODO 5.0 Membuat Class DetailAnimalActivity
public class DetailAnimalActivity extends AppCompatActivity {

    // TODO 5.2 Mendeklarasikan Key
    public static final String EXTRA_ANIMAL = "EXTRA_ANIMAL";

    // TODO 5.3 Mendeklarsikan Variable
    //TextView tvDetailTitle;
    //TextView tvDetailDescription;
    ImageView ivDetailPhoto;
    @BindView(R.id.img_detail_photo)
    CircleImageView imgDetailPhoto;
    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;
    @BindView(R.id.tv_detail_description)
    TextView tvDetailDescription;

    // TODO 5.1 membuat methode onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_animal);
        ButterKnife.bind(this);


        // TODO 5.9.1 Mengganti Nama tampilan Actiobar posisi yang atas
        getSupportActionBar().setTitle(getString(R.string.DetailPage));

        // TODO 5.4  inisialisasi / hub dengan id nya masing-masing
        // tvDetailTitle = findViewById(R.id.tv_detail_title);
        // tvDetailDescription = findViewById(R.id.tv_detail_description);
        // ivDetailPhoto = findViewById(R.id.img_detail_photo);


        // TODO 5.5 untuk mengambil data dari Animals data dengan key
        Animal animal = getIntent().getParcelableExtra(EXTRA_ANIMAL);

        // TODO 5.6 Menampilkan ke view dalam bentuk Gmabar
        Glide.with(getApplicationContext())
                .load(animal.getPhoto())
                .into(ivDetailPhoto);


        // TODO 5.7 Menapilkan ke view dalam bentuk text
        tvDetailTitle.setText(animal.getName());
        tvDetailDescription.setText(animal.getDetail());


    }

    // TODO 5.8 Methode untuk Kembali ke tampilan atau activity awal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                // TODO 5.9 Intent
                Intent myIntent = new Intent();
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
