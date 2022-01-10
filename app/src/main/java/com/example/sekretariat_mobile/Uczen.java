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

public class Uczen extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter_uczen Adapter_uczen;
    ArrayList<Uczen_klasa> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uczen);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Uczniowie");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        Adapter_uczen = new Adapter_uczen(this,list);
        recyclerView.setAdapter(Adapter_uczen);

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
    }
}