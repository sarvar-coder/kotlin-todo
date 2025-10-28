package com.bss.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bss.todoapp.ui.theme.TodoAppTheme

data class TodoItem(
    val text: String,
    var isChecked: Boolean = false
)

var todoList = listOf(
    TodoItem(
        text = "Wash dishes",
        isChecked = false
    ),
    TodoItem(
        text = "Read book",
        isChecked = false
    ),
    TodoItem(
        text = "Do laundry",
        isChecked = false
    ),
    TodoItem(
        text = "Make bed ",
        isChecked = false
    ),
    TodoItem(
        text = "Clean house",
        isChecked = true
    ),
    TodoItem(
        text = "Wash dishes",
        isChecked = false
    ),
    TodoItem(
        text = "Read book",
        isChecked = false
    ),
    TodoItem(
        text = "Do laundry",
        isChecked = false
    ),
    TodoItem(
        text = "Make bed ",
        isChecked = false
    ),
    TodoItem(
        text = "Clean house",
        isChecked = true
    ),
    TodoItem(
        text = "Wash dishes",
        isChecked = false
    ),
    TodoItem(
        text = "Read book",
        isChecked = false
    ),
    TodoItem(
        text = "Do laundry",
        isChecked = false
    ),
    TodoItem(
        text = "Make bed ",
        isChecked = false
    ),
    TodoItem(
        text = "Clean house",
        isChecked = true
    ),
    TodoItem(
        text = "Wash dishes",
        isChecked = false
    ),
    TodoItem(
        text = "Read book",
        isChecked = false
    ),
    TodoItem(
        text = "Do laundry",
        isChecked = false
    ),
    TodoItem(
        text = "Make bed ",
        isChecked = false
    ),
    TodoItem(
        text = "Clean house",
        isChecked = true
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                ToDoListScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ToDoListScreen() {
    LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
        items(todoList.size) { index ->
            TodoItemScreen(index)
        }
    }
}

@Composable
fun TodoItemScreen(index: Int) {
    val todo = todoList[index]
    var isChecked = remember { todo.isChecked }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = todo.text,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Button(
                onClick = {
                    isChecked = true
                },
            ) {
                Icon(
                    imageVector = if (isChecked) Icons.Rounded.CheckCircle else Icons.Rounded.Clear,
                    contentDescription = "Check",
                    tint = if (isChecked) Color.Green else Color.Red
                )
            }
        }
    }
}