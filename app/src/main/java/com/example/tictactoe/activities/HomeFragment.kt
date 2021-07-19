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
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onCellClick(cell: String, pos: Int) {
        if (Manager.player1Turn)
            Manager.markCell(pos)
        Manager.identifyWinner()
        if(Manager.draw)
            Snackbar.make(view as View, "DRAW", Snackbar.LENGTH_INDEFINITE).setAction("RETRY"){homeAdapter.reset()}.show()
        if(Manager.player1)
            Snackbar.make(view as View, "PLAYER 1 WIN!", Snackbar.LENGTH_INDEFINITE).setAction("RETRY"){homeAdapter.reset()}.show()
        if(Manager.player2)
            Snackbar.make(view as View, "PLAYER 2 WIN!", Snackbar.LENGTH_INDEFINITE).setAction("RETRY"){homeAdapter.reset()}.show()
        binding.counter.text = Manager.counter.toString()
        binding.turn.text = Manager.playerTurn()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Manager.fillBoard()
        binding.turn.text = "Player1"
        binding.counter.text = Manager.counter.toString()

        val recyclerViewList: RecyclerView = binding.homeRecycler
        homeAdapter = HomeAdapter(Manager.board, ::onCellClick)


        recyclerViewList.apply {
            adapter = homeAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}