package com.example.exam_login_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String[] top_exam = new String[]{"成人高考", "成人中专自学考试", "成人大专自学考试", "在职研究生", "在职博士生", "在职博士后"};
    int[] top_exam_icon = new int[]{R.drawable.gaokao, R.drawable.zhongzhuan, R.drawable.dazhuan, R.drawable.yanjiusheng,
            R.drawable.boshisheng, R.drawable.boshihou};
    String[] exam_tips = new String[]{"已报名6234人", "已报名5231人", "已报名7631人", "已报名2311人",
            "已报名1131人", "已报名354人"};
    private ListView exam_list;
    private ArrayList<Map<String, Object>> listview;
    private SimpleAdapter adapter;
    private MaterialButton download;
    private ImageView appicon;
    private TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exam_list = findViewById(R.id.exam_list);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View app_list_id = layoutInflater.inflate(R.layout.exam_list_style, null);
        listview = new ArrayList<>();
        for (int i = 0; i < top_exam.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("exam_name", top_exam[i]);
            map.put("exam_icon", top_exam_icon[i]);
            map.put("exam_tips", exam_tips[i]);
            listview.add(map);
        }

        MyAdapter adapter = new MyAdapter(getApplicationContext(),listview,R.layout.exam_list_style,new String[]{"exam_name","exam_icon","exam_tips"},new int[]{R.id.app_name,R.id.app_icon,R.id.app_detail});
        exam_list.setAdapter(adapter);
        exam_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),Detail.class);
                i.putExtra("image",String.valueOf(top_exam_icon[position]));
                i.putExtra("examname",top_exam[position]);
                i.putExtra("tips",exam_tips[position]);
                startActivity(i);
                finish();
            }
        });
    }

    public class MyAdapter extends SimpleAdapter{

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            final MaterialButton apply = view.findViewById(R.id.apply);

            apply.setOnClickListener(new android.view.View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    apply.setText("正在跳转..");
                    Handler install = new Handler();
                    install.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(getApplicationContext(),SelectDetail.class);
                            i.putExtra("nowapply",top_exam[position]);
                            startActivity(i);
                            finish();
                        }
                    },3000);


                }
            });
            return view;
        }
    }
}