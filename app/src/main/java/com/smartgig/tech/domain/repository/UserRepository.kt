package com.smartgig.tech.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartgig.tech.api.UserAPI
import com.smartgig.tech.domain.model.UserRequest
import com.smartgig.tech.domain.model.UserResponse

class UserRepository (private val userAPI:UserAPI){

    private val userLiveData= MutableLiveData<UserResponse>()

    val users:LiveData<UserResponse>
        get()=userLiveData

    suspend fun loginUser(userRequest: UserRequest){
        val response= userAPI.signin(userRequest)
        Log.d("Tag",response.body().toString())
        if(response!=null){
            userLiveData.postValue(response.body())
        }
    }

}