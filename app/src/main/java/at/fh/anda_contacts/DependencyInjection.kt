package at.fh.anda_contacts

import android.app.Application
import androidx.room.Room
import at.fh.anda_contacts.data.ANDADatabase
import at.fh.anda_contacts.data.ContactRepository
import at.fh.anda_contacts.detail.DetailViewModel
import at.fh.anda_contacts.list.ListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

var appModule = module {
    single {
        Room.databaseBuilder(
            get(), ANDADatabase::class.java, "ANDA").
        allowMainThreadQueries().build()
    }
    single { createHttpClient() }
    singleOf(::ContactRepository)
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailViewModel)
}

class ANDAApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ANDAApplication)
            modules(appModule)
        }
    }
}