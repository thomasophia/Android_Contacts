package at.fh.anda_contacts.data

import androidx.room.Database
import androidx.room.RoomDatabase
import at.fh.anda_contacts.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ANDADatabase : RoomDatabase() {
    abstract fun getContactDao(): ContactDAO
}

