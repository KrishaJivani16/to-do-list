package com.example.to_dolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private Button addTaskButton;
    private ListView taskListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> tasks;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);

        dbHelper = new DatabaseHelper(this);
        tasks = dbHelper.getAllTasks();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        taskListView.setAdapter(adapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString();
                if (!task.isEmpty()) {
                    dbHelper.addTask(task);
                    tasks.add(task);
                    adapter.notifyDataSetChanged();
                    taskInput.setText("");
                    Toast.makeText(MainActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String selectedTask = tasks.get(position);
                dbHelper.deleteTask(selectedTask);
                tasks.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Task Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
