package com.example.todo_xml.di

import android.content.Context
import androidx.room.Room
import com.example.todo_xml.data.ToDoDao
import com.example.todo_xml.data.ToDoDatabase
import com.example.todo_xml.data.repository.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltModules {

    @Provides
    @Singleton
    fun provideToDoDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ToDoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoDao(database: ToDoDatabase): ToDoDao {
        return database.toDoDao()
    }

    @Provides
    @Singleton
    fun provideToDoRepository(toDoDao: ToDoDao): ToDoRepository {
        return ToDoRepository(toDoDao)
    }


}