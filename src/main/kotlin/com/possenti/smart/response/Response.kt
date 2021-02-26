package com.possenti.smart.response

class Response<T> (
        val erros: ArrayList<String> = arrayListOf(),
        val data: T? = null
)