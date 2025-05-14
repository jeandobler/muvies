package com.dobler.muvies

import android.app.Application
import com.dobler.data.di.dataModule
import com.dobler.data.repository.MyListRepositoryImplementation
import com.dobler.data.repository.SearchRepositoryImplementation
import com.dobler.domain.repository.MyListRepository
import com.dobler.domain.repository.SearchRepository
import com.dobler.mylist.MyListViewModel
import com.dobler.network.di.networkModule
import com.dobler.search.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class MuviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MuviesApplication)

            modules(
                listOf(
                    networkModule,
                    dataModule,

                    module {
                        single<SearchRepository> { SearchRepositoryImplementation(get()) }
                        single<MyListRepository> { MyListRepositoryImplementation(get()) }
                    },

                    module {
                        viewModel { SearchViewModel(get(), get()) }
                        viewModel { MyListViewModel(get()) }

                    }
                )
            )
        }
    }
}