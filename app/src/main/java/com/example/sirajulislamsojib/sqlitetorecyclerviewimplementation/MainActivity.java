package com.example.sirajulislamsojib.sqlitetorecyclerviewimplementation;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int data = 0;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_showData);
        try {
            if(loadData()!=0){
                data = loadData();
            }
        }catch (Exception e){
            textView.setText(e.getMessage());
        }
        textView.setText(String.valueOf(data));
    }

    private int loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data Store",
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt("data",0);

    }

    public void Increase(View view) {
        data++;
        saveData(data);
        textView.setText(String.valueOf(data));
    }

    public void Decrease(View view) {
        data--;
        saveData(data);
        textView.setText(String.valueOf(data));
    }

    private void saveData(int data) {
        SharedPreferences sharedPreferences = getSharedPreferences("Data Store",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("data",data);
        //editor.commit() writes data instantly!
        editor.apply(); //apply() does it in background!
    }

}
