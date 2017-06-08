package rcpl.com.readwritedata;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        File f= Environment.getExternalStorageDirectory();
        File Rishav=new File(Environment.getExternalStorageDirectory(),"Rishav");
        File f2=new File(Environment.getExternalStorageDirectory(),"Rishav"+File.separator+"abc.txt");
        if(!Rishav.exists()) {
            Rishav.mkdir();
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final String list[]=f.list();
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("k1",list[position]);
                startActivity(intent);
            }
        });
    }
}
