package at.fh.anda_contacts.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import at.fh.anda_contacts.Contact
import at.fh.anda_contacts.data.ContactRepository


class ListViewModel(private val contactRepository: ContactRepository) : ViewModel() {
    private val searchTerm = MutableLiveData("")

    fun onSearchTermEntered(searchTerm: String) {
        this.searchTerm.value = searchTerm
    }

    fun readAll() = Transformations.switchMap(searchTerm) {
        contactRepository.readAll(it)
    }

    suspend fun load(): List<Contact> {
       val contacts = contactRepository.load()
        return contacts
    }

    override fun onCleared() {
    super.onCleared()
}
}