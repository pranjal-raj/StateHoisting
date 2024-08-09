package com.example.roompractice.Navigation

import androidx.compose.runtime.Composable
import com.example.roompractice.Screens.EntryPage

sealed class Screens(val route: String) {
    data object Entry : Screens(route = "entry")
    data object Record : Screens(route = "record")
}