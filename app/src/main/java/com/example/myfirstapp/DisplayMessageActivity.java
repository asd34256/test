package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {

    CheckBox ckb_date;
//
//    public static String TXT_TITLE = "com.example.myfirstapp.TITLE";
//    public static String TXT_CONTENT = "com.example.myfirstapp.CONTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        setup();
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);

//        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
//        layout.addView(textView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setup() {
        ckb_date = (CheckBox)findViewById(R.id.checkBox);
        ckb_date.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(findViewById(R.id.date).getVisibility() == View.GONE)
                findViewById(R.id.date).setVisibility(View.VISIBLE);
            else
                findViewById(R.id.date).setVisibility(View.GONE);
        }
    };

    public void save(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        EditText editText2 = (EditText) findViewById(R.id.edit_message2);

        if(editText.getText().toString().trim().equals("")) {
            Toast toast = Toast.makeText(this,"제목을 입력하세요",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            String title = editText.getText().toString();
            String content = editText2.getText().toString();


            SharedPreferences tsk = getSharedPreferences("tsk", MODE_PRIVATE);
            SharedPreferences.Editor editor = tsk.edit();
            editor.putString("InfoTitle", title);
            editor.putString("InfoContent", content);
            editor.commit();

//            File file = new File(getFilesDir().getAbsolutePath(), "filename");
//            FileOutputStream outputStream;
//
//            try {
//                outputStream = openFileOutput("filename", Context.MODE_PRIVATE);
//                outputStream.write("string".getBytes());
//                outputStream.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            Task task = new Task(title, content);
//            MainActivity.mainActivity.tasks.add(task);

//            Intent intent = new Intent(this, MainActivity.class);
//            intent.putExtra(TXT_TITLE, title);
//            intent.putExtra(TXT_CONTENT, content);
//            startActivityForResult(intent, 0);
        }



        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }

}
