package com.andikajayaw.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andikajayaw.recyclerview1.adapter.TodoAdapter
import com.andikajayaw.recyclerview1.model.Todo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Learn recyclerview", true),
            Todo("Follow Android Dev", true),
            Todo("Learn Android", true),
            Todo("Eat some curry", false)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos: RecyclerView = findViewById(R.id.rv_todo)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        val btnAddToDo: Button = findViewById(R.id.btnAddTodo)
        val etToDo: EditText = findViewById(R.id.et_todo)

        btnAddToDo.setOnClickListener {
            val title = etToDo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1 )
        }
    }
}