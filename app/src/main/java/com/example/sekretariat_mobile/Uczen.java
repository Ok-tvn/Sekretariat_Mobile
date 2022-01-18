package com.example.sekretariat_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Uczen extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter_uczen Adapter_uczen;
    ArrayList<Uczen_klasa> list;
    Spinner spinner_uczen;
    String kategoria;
    EditText input_uczen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uczen);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Uczniowie");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        input_uczen = findViewById(R.id.szukaj_inp_uczen);

        list = new ArrayList<>();
        Adapter_uczen = new Adapter_uczen(this,list);
        recyclerView.setAdapter(Adapter_uczen);
        Button przycisk_szukaj = (Button) findViewById(R.id.btn_szukaj_uczen);
        spinner_uczen = findViewById(R.id.spinner_szukaj_uczen);

        String[] spinner_uczen_kategorie = getResources().getStringArray(R.array.kategoria_uczen);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, spinner_uczen_kategorie);
        spinner_uczen.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                    list.add(uczen);
                }
                Adapter_uczen.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        przycisk_szukaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kategoria=="data_urodzenia"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.data_urodzenia.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (kategoria == "drugie_imie") {
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.drugie_imie.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="imie"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.imie.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                } else if (kategoria == "imiona_rodzicow") {
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.imiona_rodzicow.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria == "klasa"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.klasa.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="nazwisko"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.nazwisko.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="nazwisko_panienskie"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.nazwisko_panienskie.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="pesel"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.pesel.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="plec"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.plec.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(kategoria=="zajecia_dodatkowe"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.zajecia_dodatkowe.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {


                        }
                    });

                }else if(kategoria=="zdjecie"){
                    database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                Uczen_klasa uczen = dataSnapshot1.getValue(Uczen_klasa.class);
                                if(uczen.zdjecie.contains(input_uczen.getText().toString())==true){
                                    list.add(uczen);
                                }else{

                                }

                            }
                            Adapter_uczen.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.spinner_szukaj_uczen){
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
            kategoria=valueFromSpinner;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}