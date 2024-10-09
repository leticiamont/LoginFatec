package com.fatecpg.loginfatec.viewmodel

import androidx.lifecycle.ViewModel
import com.fatecpg.loginfatec.model.Usuario

class LoginViewModel : ViewModel() {
    private val usuarios = mutableListOf<Usuario>()

    fun logar(user: Usuario): String {
        val usuarioExistente = usuarios.find { it.login == user.login }
        return if (usuarioExistente != null) {
            when {
                usuarioExistente.bloqueado -> "Usuário bloqueado. Entre em contato com o administrador."
                usuarioExistente.senha == user.senha -> {
                    usuarioExistente.tentativasLogin = 0 // Zera as tentativas após um login bem-sucedido
                    "Login realizado com sucesso"
                }
                else -> {
                    usuarioExistente.tentativasLogin++
                    if (usuarioExistente.tentativasLogin >= 3) {
                        usuarioExistente.bloqueado = true
                        "Usuário bloqueado após 3 tentativas falhas."
                    } else {
                        "Login ou senha incorretos. Tentativa ${usuarioExistente.tentativasLogin} de 3."
                    }
                }
            }
        } else {
            "Usuário não encontrado"
        }
    }

    fun cadastrar(user: Usuario): String {
        return if (usuarios.any { it.login == user.login }) {
            "Usuário já cadastrado!"
        } else {
            usuarios.add(user)
            "Cadastro realizado com sucesso"
        }
    }

    fun getUsuarios(): List<Usuario> {
        return usuarios
    }
}
