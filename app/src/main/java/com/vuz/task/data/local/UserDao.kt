package com.vuz.task.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE login = :login")
    fun getInfoByLogin(login: String?): Observable<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?): Completable
}