package com.example.roompractice.Screens

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roompractice.Models.DateTime
import com.example.roompractice.Models.Room.User_DAO
import com.example.roompractice.Models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserViewModel(
    val dao : User_DAO
) : ViewModel() {

    private var _stateEntry = MutableStateFlow<EntryPageState>(EntryPageState())
    private var _userList = dao.getAllRecordsOrderedByName().stateIn(viewModelScope, SharingStarted.WhileSubscribed(),
        emptyList()
    )
    val stateEntry : StateFlow<EntryPageState> = _stateEntry
    private var _stateRecord = MutableStateFlow(RecordPageState())
    val stateRecord  = combine(_stateRecord,_userList){_stateRecord,_userList->
        _stateRecord.copy(userList=_userList)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(),RecordPageState())

    fun onEntryEvent(event : EntryPageEvent)
    {
        when(event)
        {
            is EntryPageEvent.SetCity -> {
                _stateEntry.update { it.copy(city = event.city) }
                Log.d("TAG",_stateEntry.value.city)
            }
            is EntryPageEvent.SetName -> {
                _stateEntry.update { it.copy(name = event.name) }
                Log.d("TAG",event.name)
            }
            EntryPageEvent.SubmitUser -> {

                val formatterDate = DateTimeFormatter.ofPattern("yyy-MM-dd")
                val formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss")


                viewModelScope.launch {

                    val it = LocalDateTime.now()
                    if(_stateEntry.value.name.isNotBlank()&&_stateEntry.value.city.isNotBlank()) {
                        dao.upsert(
                            User(
                                name = _stateEntry.value.name,
                                city = _stateEntry.value.city,
                                dateTime = DateTime(date =  "${it.dayOfMonth}/${it.monthValue}/${it.year}", "${it.hour}:${it.minute}")
                            )
                        )

                        _stateEntry.update { it.copy(name = "", city = "") }
                    }
                    else{
                        //
                    }
                }
            }
        }
    }

    fun  onRecordEvent(e : RecordPageEvent)
    {
        when(e){
            RecordPageEvent.LoadRecords -> {
                viewModelScope.launch {

                }
            }
        }
    }
}


class UserViewModelFactory(val dao: User_DAO) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return UserViewModel(dao) as T
    }
}