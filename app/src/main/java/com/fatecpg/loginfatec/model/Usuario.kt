package com.fatecpg.loginfatec.model

data class Usuario(
    val login: String,
    val senha: String,
    var bloqueado: Boolean = false,
    var tentativasLogin: Int = 0
)
