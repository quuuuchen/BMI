package com.peggy.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWeight = findViewById(R.id.ed_weight);   //findViewbyID找到該元件記憶體位置，為View型態
        edHeight = findViewById(R.id.ed_height);
        result = findViewById(R.id.result);
        Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Help")
                        .setMessage("北七不知道BMI是啥?")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    public void bmi(View view){   //onclick時傳入值的規範，需傳入View view
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height*height);
        Log.d("Main activity","bmi:"+bmi);
        //Toast 浮動顯示
        Toast.makeText(this,"your BMI is:"+bmi,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("BMI",bmi); //intent帶著bmi的值到下個activity
        startActivity(intent);

        //alert dialog對話框
        /*result.setText(getString(R.string.your_bmi_is)+bmi);
        new AlertDialog.Builder(this)
                .setTitle(R.string.bmi)
                .setMessage(getString(R.string.your_bmi_is)+bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {  //對話框按鈕
                    @Override
                    public void onClick(DialogInterface dialog, int which) {   //匿名類別(原本listen是null)
                        edHeight.setText("");
                        edWeight.setText("");
                    }
                })
                .show();*/
    }
}
