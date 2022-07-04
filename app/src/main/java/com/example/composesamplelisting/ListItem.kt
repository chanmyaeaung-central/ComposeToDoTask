package com.example.composesamplelisting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(task: Task,onDeleteClick:(Task)->Unit,onDoneClick:(Task)->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .background(Color.White),
    ) {

        Text(
            text = task.title,
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 10.dp, bottom = 10.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier) {

            IconButton(modifier = Modifier.then(
                Modifier
                    .size(48.dp)
                    .background(Color.Red)),
                onClick = { onDeleteClick.invoke(task) }) {
                Icon(
                    Icons.Filled.Delete,
                    "contentDescription",
                    tint = Color.White
                )
            }

            IconButton(modifier = Modifier.then(
                Modifier
                    .size(48.dp)
                    .background(if (task.isCompleted) Color.Green else Color.White)),
                onClick = { onDoneClick(task) }) {
                Icon(
                    if (task.isCompleted) Icons.Filled.CheckCircle else Icons.Filled.Done,
                    "contentDescription",
                    tint = if (task.isCompleted) Color.White else Color.Black
                )
            }
        }
    }
}