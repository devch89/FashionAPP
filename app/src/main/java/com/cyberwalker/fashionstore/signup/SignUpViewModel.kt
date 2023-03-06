package com.cyberwalker.fashionstore.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberwalker.fashionstore.data.AuthRepository
import com.cyberwalker.fashionstore.login.GoogleSignInState
import com.cyberwalker.fashionstore.util.Resource
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    /* We use channel here to send information between two Coroutines */
    val _signUpState = Channel<SignUpState>() // sending some info inside this channel
    val signUpState = _signUpState.receiveAsFlow() // receiving something in this channel

    fun createUser(email: String, password:String) =
        viewModelScope.launch {
            repository.registerUser(email,password).collect{ result ->
                // we need to collect all the states
                when(result){
                    is Resource.Success -> {
                        _signUpState.send(SignUpState(isSuccess = "User Created Successful"))

                    }

                    is Resource.Loading -> {
                        _signUpState.send(SignUpState(isLoading = true))

                    }

                    is Resource.Error ->{
                        _signUpState.send(SignUpState(isError = result.message))

                    }
                }
            }
        }
}
