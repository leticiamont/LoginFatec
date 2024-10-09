package com.fatecpg.loginfatec.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fatecpg.loginfatec.databinding.ActivityLoginBinding
import com.fatecpg.loginfatec.model.Usuario
import com.fatecpg.loginfatec.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener { handleLogin() }
        binding.btnCadastrar.setOnClickListener { handleCadastro() }

        // Adiciona um botão para o administrador visualizar os usuários
        binding.fabLista.setOnClickListener {
            startActivity(Intent(this, AdminActivity::class.java))
        }
    }

    private fun handleLogin() {
        val user = getUsuarioFromInputs()
        val retorno = viewModel.logar(user)
        Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
    }

    private fun handleCadastro() {
        val user = getUsuarioFromInputs()
        val retorno = viewModel.cadastrar(user)
        Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
    }

    private fun getUsuarioFromInputs(): Usuario {
        val login = binding.edtLogin.text.toString()
        val senha = binding.edtSenha.text.toString()
        return Usuario(login, senha)
    }
}
