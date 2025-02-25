package br.com.cerniauskas.bookpedia.book.data.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseContructor: RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase

}