package com.example.roompractice.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.roompractice.Screens.EntryPage
import com.example.roompractice.Screens.RecordsPage
import com.example.roompractice.Screens.UserViewModel


@Composable
fun Navigation(modifier: Modifier = Modifier, viewModel: UserViewModel) {
    val navController : NavHostController = rememberNavController()
    val entryState by viewModel.stateEntry.collectAsState()
    val recordState by viewModel.stateRecord.collectAsState()
    NavHost(navController = navController, startDestination = "entry" )
    {
        composable(Screens.Entry.route){
            EntryPage(navController,entryState, viewModel::onEntryEvent)
        }
        composable(route = Screens.Record.route)
        {
            RecordsPage(recordState, viewModel::onRecordEvent)
        }

    }
}