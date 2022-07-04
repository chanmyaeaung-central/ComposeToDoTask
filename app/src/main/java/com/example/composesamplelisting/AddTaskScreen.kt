package com.example.composesamplelisting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskScreen(viewModel: AddTaskViewModel) {

    val openDialog = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {


        val tasks = viewModel.tasksLiveData.collectAsState().value

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                ListItem(
                    task = task,
                    onDeleteClick = {
                        viewModel.deleteTask(it)
                    }, onDoneClick = {
                        viewModel.completeTask(it)
                    })
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                openDialog.value = true
            }) {
                Text(
                    text = "Add Tasks",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

    }

    if (openDialog.value) {

        val text = remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Column() {
                    TextField(value = text.value, onValueChange = {
                        text.value = it
                    })
                }
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            openDialog.value = false
                            viewModel.addTask(Task(text.value))
                        }
                    ) {
                        Text("Add to List")
                    }
                }
            }
        )
    }

}
