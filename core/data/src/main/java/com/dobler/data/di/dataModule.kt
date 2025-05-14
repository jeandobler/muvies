package com.dobler.data.di

import android.app.Application
import androidx.room.Room
import com.dobler.data.db.AppDatabase
import org.koin.dsl.module

val dataModule = module{

    single {
        Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java,
            "muvies_database"
        ).build()
    }

    single { get<AppDatabase>().searchDao() }
}
