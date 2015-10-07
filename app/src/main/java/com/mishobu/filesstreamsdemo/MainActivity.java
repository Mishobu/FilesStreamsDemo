package com.mishobu.filesstreamsdemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String linea;

        TextView tv = (TextView) findViewById(R.id.text_view2);
        tv.append("\nLeer datos de /res/raw/text1.txt");
        InputStream input = getResources().openRawResource(R.raw.text1);
        InputStreamReader stream = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(stream,1000);

        try {
            while(true) {
                linea  = buffer.readLine();
                if(linea == null)
                    break;
                tv.append("\n" + linea);
            }
            input.close();
            stream.close();
            buffer.close();

        } catch (Exception e) {
            tv.append("\n");
        }
        tv.append("\nFin de Archivo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
