package com.cyberwalker.fashionstore.login

/* This data class manages all of our states to the UI */
data class SignInState (
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)