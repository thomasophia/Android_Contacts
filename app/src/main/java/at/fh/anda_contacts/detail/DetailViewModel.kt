package at.fh.anda_contacts.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import at.fh.anda_contacts.data.ContactRepository


class DetailViewModel(private val savedStateHandle: SavedStateHandle, private val contactRepository: ContactRepository) : ViewModel() {       //savedSH im Konstruktor
    private val contact = contactRepository.read(
        savedStateHandle["contact"]!!
    )

    override fun onCleared() {
        super.onCleared()
        Log.e("DetailViewModel", "onCleared")
    }

    fun onNameChanged(newName: String) {
        contact.name = newName
    }

    fun save() {
        contactRepository.save(contact)
    }

    fun delete() {
        contactRepository.delete(contact)
    }


}