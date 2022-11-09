package com.android254.domain.utils

//import androidx.sqlite.db.SimpleSQLiteQuery
//import androidx.sqlite.db.SupportSQLiteQuery


class SimpleQueryBuilder {
    private var _query: String = ""

    fun table(tableName: String): SimpleQueryBuilder {
        _query = "SELECT * FROM $tableName"
        return this
    }

    fun where(field: String, condition: String = "=", value: String): SimpleQueryBuilder {
        _query = " WHERE $field $condition '$value'"
        return this
    }

//    fun get(): SupportSQLiteQuery {
//        return SimpleSQLiteQuery(_query)
//    }
}