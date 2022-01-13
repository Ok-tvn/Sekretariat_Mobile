package com.example.sekretariat_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_uczen extends RecyclerView.Adapter<Adapter_uczen.MyViewHolder> {

    Context context;
    ArrayList<Uczen_klasa>list;



    public Adapter_uczen(Context context, ArrayList<Uczen_klasa> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.uczen_karta,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Uczen_klasa uczen = list.get(position);
        holder.imie.setText(uczen.getImie());
        holder.drugie_imie.setText(uczen.getDrugie_imie());
        holder.imiona_rodzicow.setText(uczen.getImiona_rodzicow());
        holder.klasa.setText(uczen.getKlasa());
        holder.nazwisko.setText(uczen.getNazwisko());
        holder.nazwisko_panienskie.setText(uczen.getNazwisko_panienskie());
        holder.pesel.setText(uczen.getPesel());
        holder.plec.setText(uczen.getPlec());
        holder.zajecia_dodatkowe.setText(uczen.getZajecia_dodatkowe());
        holder.zdjecie.setText(uczen.getZdjecie());
        holder.data_urodzenia.setText(uczen.getData_urodzenia());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView imie,drugie_imie,imiona_rodzicow,klasa,nazwisko,nazwisko_panienskie,pesel,plec,zajecia_dodatkowe,zdjecie,data_urodzenia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imie= itemView.findViewById(R.id.imie);
            drugie_imie = itemView.findViewById(R.id.drugie_imie);
            imiona_rodzicow= itemView.findViewById(R.id.imie_rodzice);
            klasa = itemView.findViewById(R.id.etat);
            nazwisko= itemView.findViewById(R.id.nazwisko);
            nazwisko_panienskie = itemView.findViewById(R.id.pan_nazwisko);
            pesel= itemView.findViewById(R.id.pesel);
            plec = itemView.findViewById(R.id.plec);
            zajecia_dodatkowe= itemView.findViewById(R.id.opis_stanowiska);
            zdjecie = itemView.findViewById(R.id.zdjecie);
            data_urodzenia= itemView.findViewById(R.id.data_urodzenia);
        }
    }

}
