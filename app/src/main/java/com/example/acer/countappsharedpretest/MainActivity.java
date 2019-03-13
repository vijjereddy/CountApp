package com.example.acer.countappsharedpretest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button b1,b2,b3,b4;
    int count=0;
    int colorcode;
    SharedPreferences sp;
    private String spFilename="com.example.acer.countappsharedpretest";
    private String countkey="countkey";
    private String colorkey="colorkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        tv1=findViewById(R.id.tv);
        sp=getSharedPreferences(spFilename,MODE_PRIVATE);

       // if(savedInstanceState!=null)
       // {
            count=sp.getInt(countkey,0);
            colorcode=sp.getInt(colorkey,1);
            if(count!=0)
            {
                tv1.setText(String.valueOf(count));
                tv1.setBackgroundColor(colorcode);

            }
        }//


    public void Black(View view) {
        colorcode=getResources().getColor(R.color.black);
        tv1.setBackgroundColor(colorcode);

    }

    public void Red(View view) {
        colorcode=getResources().getColor(R.color.red);
        tv1.setBackgroundColor(colorcode);
    }

    public void Blue(View view) {
        colorcode=getResources().getColor(R.color.blue);
        tv1.setBackgroundColor(colorcode);
    }

    public void Green(View view) {
        colorcode=getResources().getColor(R.color.green);
        tv1.setBackgroundColor(colorcode);
    }


    public void Count(View view)
    {

        count++;
        tv1.setText(String.valueOf(count));
        //tv1.setText(""+count);

    }
    public void Reset(View view) {
        tv1.setText(String.valueOf(count=0));
    }

    @Override
    protected void onPause() {
        super.onPause();
       // count= Integer.parseInt(tv1.getText().toString());
       // colorcode= Integer.parseInt(tv1.getBackground().toString());
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countkey,count);
        editor.putInt(colorkey,colorcode);
        editor.apply();
        //Toast.makeText(this, "count:+count"+\n "+successfully saved in sp, Toast.LENGTH_SHORT).show();

    }
}
