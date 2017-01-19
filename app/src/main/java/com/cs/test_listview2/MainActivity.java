package com.cs.test_listview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv_main;
    private Adpter adpter;
    private String[] string = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };
    private String [] name={"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lv_main = (ListView) findViewById(R.id.lv_main);
        adpter=new Adpter(this);
        int size=string.length;
        for (int i = 0; i < size; i++) {
            adpter.addSeparatorItem(string[i]);
            for (int k = 0; k < name.length; k++) {
                adpter.addItem("item " + name[k]);

            }
        }
        lv_main.setAdapter(adpter);
        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = adapterView.getId();
                Toast.makeText(MainActivity.this, "i>>>>>>"+i+"l????"+l, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
