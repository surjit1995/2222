package com.livedata.with.roomdb.marc.oliva.roomdbwithlivedata.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by ThinkSoft on 19/12/2017.
 */
@Dao
interface DaoContact {
    @Query("select * from contactdata")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("select * from contactdata where idContact in (:id)")
    fun getContactById(id: Int): Contact

    @Query("delete from contactdata")
    fun deleteAllContacts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}