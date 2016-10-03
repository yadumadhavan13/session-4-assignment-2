package com.example.y.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String>namelist,numberlist;
    private TextView nametext,numbertext;
    private Myadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametext = (TextView) findViewById(R.id.name_text);
        numbertext = (TextView) findViewById(R.id.number_text);
        listView = (ListView) findViewById(R.id.list_view);

        namelist = new ArrayList<>();
        namelist.add("Name1");
        namelist.add("Name2");
        namelist.add("Name3");
        namelist.add("Name4");
        namelist.add("Name5");
        namelist.add("Name6");
        namelist.add("Name7");

        numberlist = new ArrayList<>();
        numberlist.add("Phonenumber1");
        numberlist.add("Phonenumber2");
        numberlist.add("Phonenumber3");
        numberlist.add("Phonenumber4");
        numberlist.add("Phonenumber5");
        numberlist.add("Phonenumber6");
        numberlist.add("Phonenumber7");

        adapter = new Myadapter();
        listView.setAdapter(adapter);



    }
    public class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return namelist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            viewholder holder;
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.row_view,parent,false);
                holder = new viewholder();
                holder.bindview(convertView);
                convertView.setTag(holder);
                Log.e("MainActivity","convertview is null");
            }else {
                holder = (viewholder) convertView.getTag();
            }
            holder.nametext.setText(namelist.get(position));
            holder.numbertext.setText(numberlist.get(position));
            return convertView;


        }

    }
    public class viewholder{
        TextView nametext,numbertext;
        void bindview(View convertview){
            Log.e("MainActivity","convertview is not null");
            nametext = (TextView) convertview.findViewById(R.id.name_text);
            numbertext = (TextView) convertview.findViewById(R.id.number_text);

        }

    }
}
