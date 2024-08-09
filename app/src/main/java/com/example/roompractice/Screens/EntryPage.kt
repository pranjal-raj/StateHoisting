package com.example.roompractice.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.roompractice.Navigation.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun EntryPage(
    navController: NavController,
    state: EntryPageState,
    onEvent: (EntryPageEvent)->Unit
    ) {
    Scaffold { innerpadding->
        Column(modifier = Modifier
            .padding(innerpadding)
            .fillMaxSize(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            TextField(value =state.name , onValueChange = {onEvent(EntryPageEvent.SetName(it))},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = { Text(text = "Name") })
            Spacer(modifier = Modifier.height(20.dp))
            TextField(value =state.city , onValueChange = {onEvent(EntryPageEvent.SetCity(it))},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                placeholder = { Text(text = "City")})

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                onEvent(EntryPageEvent.SubmitUser)
                //navController.navigate(route = Screens.Record.route)
            }) {
                Box(modifier = Modifier.fillMaxWidth(0.5f), contentAlignment = Alignment.Center){ Text(text = "Submit", fontSize = 32.sp) }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate(route = Screens.Record.route)
            }) {
                Box(modifier = Modifier.fillMaxWidth(0.6f), contentAlignment = Alignment.Center){ Text(text = "View Records", fontSize = 32.sp) }
            }
        }
    }

}
