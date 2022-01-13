package com.example.sekretariat_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pracownik extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter_pracownik Adapter_pracownik;
    ArrayList<Pracownik_klasa> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pracownik);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Pracownicy");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Adapter_pracownik = new Adapter_pracownik(this,list);
        recyclerView.setAdapter(Adapter_pracownik);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Pracownik_klasa pracownik = dataSnapshot1.getValue(Pracownik_klasa.class);
                    list.add(pracownik);
                }
                Adapter_pracownik.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}