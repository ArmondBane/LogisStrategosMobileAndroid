package com.goodcomp.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StratagemEntity.TABLE_NAME)
data class StratagemEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_NAME)
    val name: String,

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    val description: String,

    @ColumnInfo(name = COLUMN_FACTION)
    val faction: String,

    @ColumnInfo(name = COLUMN_STYLE)
    val style: String,

    @ColumnInfo(name = COLUMN_COST)
    val cost: String,

    @ColumnInfo(name = COLUMN_EFFECT)
    val effect: String,

    @ColumnInfo(name = COLUMN_PICTURE_URI)
    val pictureUri: Int,
) {

    companion object {
        const val TABLE_NAME = "stratagem_table"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_FACTION = "faction"
        private const val COLUMN_STYLE = "style"
        private const val COLUMN_COST = "cost"
        private const val COLUMN_EFFECT = "effect"
        private const val COLUMN_PICTURE_URI = "pictureUri"
    }
}