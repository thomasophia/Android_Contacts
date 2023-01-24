package at.fh.anda_contacts.data

import androidx.lifecycle.LiveData
import androidx.room.*
import at.fh.anda_contacts.Contact

@Dao
interface ContactDAO {

    @Insert
    fun insertContacts(contacts: List<Contact>)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT COUNT(*) from contacts")
    fun getContactCount(): Int

    @Query("SELECT * from contacts WHERE name LIKE '%' || :contactName || '%' ")
    fun getContacts(contactName: String): LiveData<List<Contact>>

    @Query("SELECT * from contacts WHERE id = :contactId")
    fun getContact(contactId: Int): Contact
}
