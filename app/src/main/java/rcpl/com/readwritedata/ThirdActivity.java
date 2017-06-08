package rcpl.com.readwritedata;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThirdActivity extends AppCompatActivity {

    EditText ed;
    TextView tv;
    String s3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent i1=getIntent();
        String s1=i1.getStringExtra("k2");
        String s4="Hello World";
        tv=(TextView)findViewById(R.id.textView);
        File f3=new File(Environment.getExternalStorageDirectory(),s1);
        Toast.makeText(this, ""+s1, Toast.LENGTH_SHORT).show();
        try {
            FileOutputStream fos=new FileOutputStream(f3);
            byte b[]=s4.getBytes();
            fos.write(s4.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f3);
            int data;
            while (fis.available() > 0) {
                data = fis.read();
                s3=s3+(char)data;
            }
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(s3);
    }
}
