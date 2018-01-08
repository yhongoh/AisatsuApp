package jp.techacademy.hongou.yuka.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView1);
    }

        @Override
        public void onClick(View v) {
            showTimePickerDialog();
            }

        private void showTimePickerDialog() {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            /*
                            挨拶の分岐を記載
                            2:00 ~ 9:59 では「おはよう」
                            10:00 ~ 17:59 では「こんにちは」
                            18:00 ~ 1:59 では「こんばんは」
                            */

                            if (2 <= hourOfDay && hourOfDay < 10){
                                mTextView.setText("おはよう");
                            }else if (10 <= hourOfDay && hourOfDay < 18){
                                mTextView.setText("こんにちは");}
                            else if (hourOfDay < 2 || hourOfDay >= 18){
                                mTextView.setText("こんばんは");
                            }

                        }
                    },
                    9,
                    0,
                    true);
        timePickerDialog.show();
        }
}


