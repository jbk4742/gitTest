package com.example.dmap.androidstudy_0926;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    private static int BTN_COUNT = 9;
    private GridLayout btnGrid;
    private TextView score;
    private Button[] buttons = new Button[BTN_COUNT];

    private int BtnCount = 0;
    private int score_num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrid = (GridLayout) findViewById(R.id.Grid_test);
        score = (TextView) findViewById(R.id.text_test);

        for(int i = 0; i<BTN_COUNT; i++){
            Button btn = new Button(this);
            btn.setOnClickListener(this);
            buttons[i] = btn;
            btnGrid.addView(btn);
        }
        Random random = new Random();

        for(int i=0; i<BTN_COUNT;i++){
            buttons[i].setText((random.nextInt(9) + 1)+"");
        }
    }


    public void onClick(View v){

        Button currentBtn = (Button) v;
        currentBtn.setBackgroundColor(Color.RED);
        BtnCount++;
        if(BtnCount==BTN_COUNT) {
            Toast.makeText(this, "완료", Toast.LENGTH_SHORT).show();
            score_num+=100;
            score.setText("점수는 : "+score_num);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
