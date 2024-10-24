package com.example.testmixrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcvUser = findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.ic_launcher_background,"User1",true));
        list.add(new User(R.drawable.ic_launcher_background,"User2",true));
        list.add(new User(R.drawable.ic_launcher_background,"User3",true));
        list.add(new User(R.drawable.ic_launcher_background,"User4",true));

        list.add(new User(R.drawable.ic_launcher_background,"User1",false));
        list.add(new User(R.drawable.ic_launcher_background,"User2",false));
        list.add(new User(R.drawable.ic_launcher_background,"User3",false));
        list.add(new User(R.drawable.ic_launcher_background,"User4",false));

        return list;
    }
}