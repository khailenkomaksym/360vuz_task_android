package com.vuz.task.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey @ColumnInfo(name = "_id") val id: Int?,
                     @ColumnInfo(name = "login") val login: String?,
                     @ColumnInfo(name = "avatar_url") val avatarUrl: String?,
                     @ColumnInfo(name = "type") val type: String?,
                     @ColumnInfo(name = "public_repos") val public_repos: Int?)