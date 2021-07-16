package com.example.tictactoe.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.adapters.HomeAdapter
import com.example.tictactoe.databinding.FragmentHomeBinding
import com.example.tictactoe.utils.Manager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val onCellClick2: (String, Int) -> Unit = { cell, pos ->
        println("asdasd")
    }

    private fun onCellClick(cell: String, pos: Int) {
        //Manager.markCell(cell.toInt())
        //  println("aaa")
        binding.counter.text = Manager.counter.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Manager.fillBoard()
        binding.turn.text = "Player1"
        binding.counter.text = "0"

        val recyclerViewList: RecyclerView = binding.homeRecycler
        val homeAdapter = HomeAdapter(Manager.board, ::onCellClick)

        recyclerViewList.apply {
            adapter = homeAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        binding.btnReset.setOnClickListener {
            homeAdapter.reset()
        }
    }
}