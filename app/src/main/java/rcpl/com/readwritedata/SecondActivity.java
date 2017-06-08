package rcpl.com.readwritedata;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class SecondActivity extends AppCompatActivity {

    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i=getIntent();
        final String s=i.getStringExtra("k1");
        File f1=new File(Environment.getExternalStorageDirectory(),s);
        final String list1[]=f1.list();
        lv1=(ListView)findViewById(R.id.listView2);
        ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list1);
        lv1.setAdapter(adapter1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(SecondActivity.this,ThirdActivity.class);
                intent1.putExtra("k2",s+File.separator+list1[position]);
                startActivity(intent1);
            }
        });
    }
}
