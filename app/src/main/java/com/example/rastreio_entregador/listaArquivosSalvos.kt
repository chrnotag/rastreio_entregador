package com.example.rastreio_entregador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rastreio_entregador.databinding.ActivityListaArquivosSalvosBinding

class listaArquivosSalvos : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaArquivosSalvosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var files: Array<String> = this.fileList()

        val adapter = AdapterRecycler(files)
        val layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val recycler = binding.recyclerView
        recycler.adapter = adapter
        recycler.layoutManager = layoutManager
    }
}