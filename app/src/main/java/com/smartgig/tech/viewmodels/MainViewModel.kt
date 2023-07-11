package com.smartgig.tech.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartgig.tech.domain.model.UserRequest
import com.smartgig.tech.domain.model.UserResponse
import com.smartgig.tech.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository):ViewModel() {

    val userRequest = UserRequest(email = "example@example.com", password = "password123")



    init{
        viewModelScope.launch(Dispatchers.IO){
            repository.loginUser(userRequest)
        }
    }

    val users:LiveData<UserResponse>
        get() = repository.users

}