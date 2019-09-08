package com.example.dheo.SubmissionRecyclerView.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dheo.SubmissionRecyclerView.R;
import com.example.dheo.SubmissionRecyclerView.detail.DetailAnimalActivity;
import com.example.dheo.SubmissionRecyclerView.model.Animal;

import java.util.ArrayList;

// TODO 3.0 Membuat sebuah adapter yang akan memformat bagiamana tiap element dari koleksi data ditampilkan

// TODO 3.1 Membuat kelas  ListAnimalAdapter
public class ListAnimalAdapter extends RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder> {

    // TODO 3.5 Membuat Constructor untuk list
    public ArrayList<Animal> listAnimal;

    Context context ;


    public ListAnimalAdapter(ArrayList<Animal> listAnimal,Context context) {
        this.listAnimal = listAnimal;
        this.context = context;

     }

    //TODO 3.2 Membuat kelas ListViewHolder, alt + enter pada warna merah di tulisan .ListViewHolder diatas.
    //TODO 3.3 Membuat metode onCreateVIewHolder, onBindViewHolder, getItemCount, karena masi ada garis merah diatas maka kita alt+enter lagi dan implemet methode
    //TODO 3.6 Melengkapi Kode hasil turunan dari RecyclerView.Adapter
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_animal, viewGroup, false);
        return new ListViewHolder(view);
     }


    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        final Animal animal = listAnimal.get(position);

        //TODO 3.7 get data dari intent sesuai tipe data
        final String photo = animal.getPhoto();
        final String name = animal.getName();
        final String detail = animal.getDetail();

        //TODO 3.8 digunakan untuk menampilkan gambar
        Glide.with(holder.itemView.getContext())
                .load(photo)
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        //TODO 3.9 tampilkan ke view dalam bentuk text
        holder.tvName.setText(name);
        holder.tvDetail.setText(detail);

        //TODO 3.9.1 event listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO 3.9.2 Melakukan Intent Detail Animal
                Intent intent = new Intent(context, DetailAnimalActivity.class);
                intent.putExtra(DetailAnimalActivity.EXTRA_ANIMAL,animal);
                //TODO 3.9.3
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

     }

    @Override
    public int getItemCount() {
        return listAnimal.size();
    }
    // TODO 3.4 Membuat Constructor Matching Super
    class ListViewHolder extends RecyclerView.ViewHolder {
       //TODO 3.9.3 Deklarasi variable
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemView) {
            super(itemView);
            // TODO 3.9.4 inisialisasi / hub dengan id nya masing-masing
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
          }
        }
     }