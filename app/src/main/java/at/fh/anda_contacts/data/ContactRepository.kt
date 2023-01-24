package at.fh.anda_contacts.data

import android.util.Log
import androidx.lifecycle.LiveData
import at.fh.anda_contacts.ApiContact
import at.fh.anda_contacts.Contact
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

//lateinit var repository: ContactRepository                //not needed anymore after implementing dependency injection

class ContactRepository(private val andaDatabase: ANDADatabase, private val httpClient: HttpClient) {
    val contactDAO = andaDatabase.getContactDao()

    fun save(contact: Contact) {
        contactDAO.updateContact(contact)
    }

    fun delete(contact: Contact) {
        contactDAO.deleteContact(contact)
    }

    fun read(contactId: Int): Contact {
        return contactDAO.getContact(contactId)
    }

    fun readAll(contactName: String): LiveData<List<Contact>> {
        return contactDAO.getContacts(contactName)
    }

    suspend fun load(): List<Contact> {
        //contactDAO.insertContacts(createContacts(5))          //not used anymore because we load data from url
        val apiContacts: List<ApiContact> = httpClient.get("https://my-json-server.typicode.com/GithubGenericUsername/find-your-pet/contacts").body()
        val contacts = apiContacts.map { Contact(it.id, it.name, it.telephoneNumber.toString(), it.age) }
        Log.e("test", contacts.toString() )
        return contacts

    }
}