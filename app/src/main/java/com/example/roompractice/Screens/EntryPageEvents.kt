package com.example.roompractice.Screens

sealed interface EntryPageEvent {
    data object SubmitUser : EntryPageEvent
    data class SetName(val name : String) : EntryPageEvent
    data class SetCity(val city : String) : EntryPageEvent

}