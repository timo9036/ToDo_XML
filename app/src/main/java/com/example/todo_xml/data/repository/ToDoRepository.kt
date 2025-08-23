package com.example.todo_xml.data.repository

import androidx.lifecycle.LiveData
import com.example.todo_xml.data.ToDoDao
import com.example.todo_xml.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }
}