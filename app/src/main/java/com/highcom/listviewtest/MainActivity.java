package com.highcom.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Map<String, String> data;
    public static List<Map<String, String>> dataList;
    public static ListView listView;
    public static ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<Map<String, String>>();

        // ListViewに表示するためのDATAを作成する
        int MAXDATA = 10;
        for (int i = 0; i < MAXDATA; i++) {
            data = new HashMap<String, String>();
            data.put("text1", "タイトル" + i);
            data.put("text2", "サブ" + i);
            dataList.add(data);
        }

        // アダプターにデータを渡す
        adapter = new ListViewAdapter(
                this,
                dataList,
                R.layout.row,
                new String[] { "text1", "text2" },
                new int[] { android.R.id.text1,
                        android.R.id.text2 });

        // アダプターにDATAをSETする
        listView = (ListView) findViewById(R.id.mainlist);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);

    }
}
