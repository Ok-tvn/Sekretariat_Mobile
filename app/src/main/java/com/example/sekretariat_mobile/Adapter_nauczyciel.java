package com.example.sekretariat_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_nauczyciel extends RecyclerView.Adapter<Adapter_nauczyciel.MyViewHolder> {

    Context context;
    ArrayList<Nauczyciel_klasa> list;

    public Adapter_nauczyciel(Context context, ArrayList<Nauczyciel_klasa> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.nauczyciel_karta,parent,false);
        return new Adapter_nauczyciel.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Nauczyciel_klasa nauczyciel = list.get(position);
        holder.imie.setText(nauczyciel.getImie());
        holder.drugie_imie.setText(nauczyciel.getDrugie_imie());
        holder.imiona_rodzicow.setText(nauczyciel.getImiona_rodzicow());
        holder.klasy.setText(nauczyciel.getKlasy());
        holder.nazwisko.setText(nauczyciel.getNazwisko());
        holder.nazwisko_panienskie.setText(nauczyciel.getNazwisko_panienskie());
        holder.pesel.setText(nauczyciel.getPesel());
        holder.plec.setText(nauczyciel.getPlec());
        holder.zajecia.setText(nauczyciel.getZajecia());
        holder.wychowastwo.setText((nauczyciel.getWychowastwo()));
        holder.zdjecie.setText(nauczyciel.getZdjecie());
        holder.data_urodzenia.setText((nauczyciel.getData_urodzenia()));
        holder.data_zatrudnienia.setText(nauczyciel.getData_zatrudnienia());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView imie,drugie_imie,imiona_rodzicow,klasy,nazwisko,nazwisko_panienskie,pesel,plec,zajecia,wychowastwo,zdjecie,data_urodzenia,data_zatrudnienia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imie= itemView.findViewById(R.id.imie);
            drugie_imie = itemView.findViewById(R.id.drugie_imie);
            imiona_rodzicow= itemView.findViewById(R.id.imie_rodzice);
            klasy = itemView.findViewById(R.id.klasy);
            nazwisko= itemView.findViewById(R.id.nazwisko);
            nazwisko_panienskie = itemView.findViewById(R.id.pan_nazwisko);
            pesel= itemView.findViewById(R.id.pesel);
            plec = itemView.findViewById(R.id.plec);
            zajecia= itemView.findViewById(R.id.zajecia);
            wychowastwo = itemView.findViewById(R.id.wychowastwo);
            zdjecie = itemView.findViewById(R.id.zdjecie);
            data_urodzenia= itemView.findViewById(R.id.data_urodzenia);
            data_zatrudnienia = itemView.findViewById(R.id.data_zatrudnienia);
        }
    }
}
