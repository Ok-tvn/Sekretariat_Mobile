package com.example.sekretariat_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_pracownik extends RecyclerView.Adapter<Adapter_pracownik.MyViewHolder>{

    Context context;
    ArrayList<Pracownik_klasa> list;

    public Adapter_pracownik(Context context, ArrayList<Pracownik_klasa> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pracownik_karta,parent,false);
        return new Adapter_pracownik.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pracownik_klasa pracownik = list.get(position);
        holder.imie.setText(pracownik.getImie());
        holder.drugie_imie.setText(pracownik.getDrugie_imie());
        holder.imiona_rodzicow.setText(pracownik.getImiona_rodzicow());
        holder.etat.setText(pracownik.getEtat());
        holder.nazwisko.setText(pracownik.getNazwisko());
        holder.nazwisko_panienskie.setText(pracownik.getNazwisko_panienskie());
        holder.pesel.setText(pracownik.getPesel());
        holder.plec.setText(pracownik.getPlec());
        holder.opis_stanowiska.setText(pracownik.getOpis_stanowiska());
        holder.zdjecie.setText(pracownik.getZdjecie());
        holder.data_urodzenia.setText((pracownik.getData_urodzenia()));
        holder.data_zatrudnienia.setText(pracownik.getData_zatrudnienia());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView imie,drugie_imie,imiona_rodzicow,etat,nazwisko,nazwisko_panienskie,pesel,plec,opis_stanowiska,zdjecie,data_urodzenia,data_zatrudnienia;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imie= itemView.findViewById(R.id.imie);
            drugie_imie = itemView.findViewById(R.id.drugie_imie);
            imiona_rodzicow= itemView.findViewById(R.id.imie_rodzice);
            etat = itemView.findViewById(R.id.etat);
            nazwisko= itemView.findViewById(R.id.nazwisko);
            nazwisko_panienskie = itemView.findViewById(R.id.pan_nazwisko);
            pesel= itemView.findViewById(R.id.pesel);
            plec = itemView.findViewById(R.id.plec);
            opis_stanowiska= itemView.findViewById(R.id.opis_stanowiska);
            zdjecie = itemView.findViewById(R.id.zdjecie);
            data_urodzenia= itemView.findViewById(R.id.data_urodzenia);
            data_zatrudnienia = itemView.findViewById(R.id.data_zatrudnienia);
        }
    }
}
