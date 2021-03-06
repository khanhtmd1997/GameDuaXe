package com.example.administrator.testgame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton ibtnPlay;
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 10;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                //kieerm tra win ONE
                if(skOne.getProgress()>= skOne.getMax()){
                    //máy 5.0 mới chạy được hàm this.cancel();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"ONE WIN",Toast.LENGTH_SHORT).show();
                    //kiểm tra đặt cược
                    if(cbOne.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác! :>",Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi! :<",Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                //kieerm tra win TWO
                if(skTwo.getProgress()>= skTwo.getMax()){
                    //máy 5.0 mới chạy được hàm this.cancel();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"TWO WIN",Toast.LENGTH_SHORT).show();
                    //kiểm tra đặt cược
                    if(cbTwo.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this," Bạn đoán chính xác! :>",Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi! :<",Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                //kieerm tra win THREE
                if(skThree.getProgress()>= skThree.getMax()){
                    //máy 5.0 mới chạy được hàm this.cancel();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"THREE WIN",Toast.LENGTH_SHORT).show();
                    //kiểm tra đặt cược
                    if(cbThree.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác! :>",Toast.LENGTH_SHORT).show();

                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi! :<",Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }else {
                    Toast.makeText(MainActivity.this,"Vui Lòng Đặt Cược Trước Khi Chơi!",Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    //bo chech 2,3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    //bo chech 2,3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    //bo chech 2,3
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox(){
         cbOne.setEnabled(true);
         cbTwo.setEnabled(true);
         cbThree.setEnabled(true);
    }
    private void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.textviewDiemSo);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        skOne = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree = (SeekBar) findViewById(R.id.seekbarThree);

    }
}
