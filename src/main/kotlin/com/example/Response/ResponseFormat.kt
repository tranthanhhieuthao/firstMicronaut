package com.example.Response

data class ResponseFormat(var data: Any? = null, var message: String)  {

    enum class MessageCode {
        FAIL, SUCCESS, BAD_REQUEST, NOT_EXITS
    }
}
