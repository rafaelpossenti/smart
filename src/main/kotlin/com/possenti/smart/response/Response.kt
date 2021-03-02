package com.possenti.smart.response

class Response<T> (
        val erros: ArrayList<String> = arrayListOf(),
        var data: T? = null
)