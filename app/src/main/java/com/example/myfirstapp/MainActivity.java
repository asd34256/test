package com.example.myfirstapp;

import java.io.File;
import java.io.FileInputStream;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


//    public static MainActivity mainActivity;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter<TaskViewHolder> adapter;

    public static ArrayList<Task> tasks = new ArrayList<>();
//    private ListView listView;
//    private String[] designPatterns;
//    private String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        tasks = new ArrayList<>();
//        mainActivity = this;


//        try {
//            String dirPath = getFilesDir().getAbsolutePath();
//            File file = new File(dirPath);
//            try {
////                tasks = (ArrayList<Task>)loadSerializedObject(file);
//                FileInputStream f = new FileInputStream(dirPath);
//                ObjectInputStream o = new ObjectInputStream(f);
//                tasks = (ArrayList<Task>)o.readObject();
//
//            } catch(NullPointerException e) {
//
//
//            }
////            tasks.add(task);
//        } catch (NullPointerException e) {
//
//        }
//        tasks = (ArrayList<Task>)loadSerializedObject(file);
//
//        Intent intent = getIntent();
//        String title = intent.getStringExtra(DisplayMessageActivity.TXT_TITLE);
//        String content = intent.getStringExtra(DisplayMessageActivity.TXT_CONTENT);

//        tasks.add(new Task(title, content));


        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        this.layoutManager = new LinearLayoutManager(this);

        this.adapter = new TaskAdapter(tasks);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);


        //this.listView = (ListView) findViewById(R.id.listView);
//        this.designPatterns = getResources().getStringArray(R.array.design_patterns);
//        this.descriptions = getResources().getStringArray(R.array.design_patterns_description);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, designPatterns);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int  position, long id) {
//                String description = descriptions[position];
//                Toast.makeText(MainActivity.this, description, Toast.LENGTH_SHORT).show();
//            }
//
//        });
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }
    @Override
    protected void onResume() {
        super.onResume();

//    adapter.notifyDataSetChanged();

        SharedPreferences tsk = getSharedPreferences("tsk", MODE_PRIVATE);

            String title = tsk.getString("InfoTitle", "");
            if(title != "") {
                String content = tsk.getString("InfoContent", "");
                Task task = new Task(title, content);
                tasks.add(task);
                SharedPreferences.Editor editor = tsk.edit();
                editor.clear();
                editor.commit();

                saveObject(tasks);
            }


    }

    public void saveObject(ArrayList<Task> tasks) {
        try {
            String dirPath = getFilesDir().getAbsolutePath();
            File file = new File(dirPath);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(tasks);
            oos.flush();
            oos.close();
            Toast.makeText(this,"저장됐다", Toast.LENGTH_SHORT).show();
        } catch(Exception e) {

            Log.v("Save Error : ", e.getMessage());
            e.printStackTrace();
        }
    }

    public Object loadSerializedObject(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream((new FileInputStream(file)));
            Object obj = ois.readObject();

            return obj;
        } catch(Exception e) {

            Log.v("Load Error : ", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//    }

    /**Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        finish();
    }

//    public List<Task> getTasks() {
//        return tasks;
//    }

//    private List<Task> getTasks() {
//        // Create a List of movies
//        List<Task> movies = new ArrayList<>();
//        movies.add(new Task("Star Wars", "J.J. Abrams"));
//        movies.add(new Task("The Martian", "Ridley Scott"));
//        movies.add(new Task("Crimson Peak", "Guillermo del Toro"));
//        movies.add(new Task("Pan", "Joe Wright"));
//        movies.add(new Task("Knock Knock", "Eli Roth"));
//        movies.add(new Task("Sicario", "Denis Villeneuve"));
//        movies.add(new Task("The Walk", "Robert Zemeckis"));
//        movies.add(new Task("Black Mass", "Scott Cooper"));
//        movies.add(new Task("Goosebumps", "Rob Letterman"));
//        movies.add(new Task("Dope", "Rick Famuyiwa"));
//
//        return movies;
//    }
}