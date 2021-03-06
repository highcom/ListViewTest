package com.highcom.listviewtest;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewAdapter extends SimpleAdapter {

    private LayoutInflater inflater;
    private List<? extends Map<String, ?>> listData;

    // 各行が保持するデータ保持クラス
    public class ViewHolder {
        TextView text1;
        TextView text2;
    }

    public ListViewAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        // this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        // ビューを受け取る
        View view = convertView;

        if (view == null) {
            // 画面起動時にViewHolderを作成する
            view = inflater.inflate(R.layout.row, parent, false);

            holder = new ViewHolder();
            holder.text1 = (TextView) view.findViewById(android.R.id.text1);
            holder.text2 = (TextView) view.findViewById(android.R.id.text2);

            view.setTag(holder);
        } else {
            // 行選択時などは既に作成されているものを取得する
            holder = (ViewHolder) view.getTag();
        }

        String text1 = ((HashMap<?, ?>) listData.get(position)).get("text1").toString();
        String text2 = ((HashMap<?, ?>) listData.get(position)).get("text2").toString();
        holder.text1.setText(text1);
        holder.text2.setText(text2);

        // セル上にあるボタンの処理
        Button btn = (Button) view.findViewById(R.id.rowbutton);
        btn.setTag(position);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 選択したセルの文字を赤色にする
                holder.text1.setTextColor(Color.RED);
            }
        });

        return view;
    }
}
