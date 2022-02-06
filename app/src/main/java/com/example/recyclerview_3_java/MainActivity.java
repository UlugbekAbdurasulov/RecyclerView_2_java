package com.example.recyclerview_3_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List <Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for(int i = 0; i<30; i++){
            if(i == 0 || i == 5 || i == 16 || i == 25){
                members.add(new Member("Abdurasulov"+i,"Ulug'bek"+i,false));
            }else {
                members.add(new Member("Abdurasulov"+i,"Azizbek"+i,true));
            }
        }
        return members;
    }
}
