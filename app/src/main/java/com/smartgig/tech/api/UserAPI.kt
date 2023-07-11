package com.smartgig.tech.api

import com.smartgig.tech.domain.model.UserRequest
import com.smartgig.tech.domain.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST()
    suspend fun signin(@Body userRequest:UserRequest):Response<UserResponse>



}