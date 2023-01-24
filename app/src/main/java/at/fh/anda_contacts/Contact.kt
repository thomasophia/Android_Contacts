package at.fh.anda_contacts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contacts")
class Contact(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    @ColumnInfo(name = "telephon_number") var telephoneNumber: String,
    var age: Int
) : Serializable

//not used anymore because we are loading data from url
fun createContacts(contactCount: Int) =
    (1..contactCount)
        .map { Contact(0, "Name $it", "Tel Number", 20 + contactCount) }
