package com.example.roompractice.Screens

sealed interface RecordPageEvent {
    data object LoadRecords : RecordPageEvent
}