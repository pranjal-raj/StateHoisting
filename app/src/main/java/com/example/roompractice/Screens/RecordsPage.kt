package com.example.roompractice.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roompractice.Models.User

@Composable
fun RecordsPage(
    state: RecordPageState,
    onEvent: (RecordPageEvent)->Unit,
) {
    Scaffold { innerpadding ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Records", fontSize = 40.sp)


            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.Absolute.SpaceAround,
                            modifier = Modifier.fillMaxWidth(1f)
                        ) {
                            Text(text = "NAME", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "DATE", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "TIME", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "CITY", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                items(items = state.userList) { item: User ->
                    Box(modifier = Modifier.fillMaxSize().padding(8.dp).border(width = 2.dp, brush = Brush.linearGradient(colors = listOf(Color.Black,Color.Black)), shape = RectangleShape).padding(8.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth(1f)
                        ) {
                            Text(text = item.name, fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(text = item.dateTime.date, fontSize = 18.sp,)
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(text = item.dateTime.time, fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(text = item.city, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}
