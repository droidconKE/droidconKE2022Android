/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.domain.models

sealed class ResourceResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : ResourceResult<T>(data)
    class Error<T>(message: String, data: T? = null, val networkError: Boolean = false) : ResourceResult<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : ResourceResult<T>(null)
    class Empty <T>(message: String) : ResourceResult<T>(null)
}