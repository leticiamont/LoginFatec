package com.fatecpg.loginfatec.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatecpg.loginfatec.databinding.ActivityAdminBinding
import com.fatecpg.loginfatec.viewmodel.LoginViewModel

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o RecyclerView para exibir a lista de usuários
        binding.recyclerViewUsuarios.layoutManager = LinearLayoutManager(this)
        val usuarios = viewModel.getUsuarios()
        binding.recyclerViewUsuarios.adapter = UsuarioAdapter(usuarios)
    }
}
