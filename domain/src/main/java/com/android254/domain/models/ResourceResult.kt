package com.android254.domain.models

sealed class ResourceResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : ResourceResult<T>(data)
    class Error<T>(message: String, data: T? = null, networkError: Boolean = false) : ResourceResult<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : ResourceResult<T>(null)
    class Empty : ResourceResult<Nothing>(null)
}