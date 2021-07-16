package com.example.tictactoe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.R
import com.example.tictactoe.utils.Manager

class HomeAdapter(
    private var dataSet: ArrayList<String>,
    private val onClick: (String, Int) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cell_image: ImageView
        val btn_cell: LinearLayout
        val cell_text: TextView

        init {
            cell_image = view.findViewById(R.id.cell_image_id)
            btn_cell = view.findViewById(R.id.btn_cell)
            cell_text = view.findViewById(R.id.cell_text)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell, viewGroup, false)

        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val imgRes = when (dataSet[position]) {
            "x" -> R.drawable.ic_x
            "o" -> R.drawable.ic_o
            else -> R.drawable.empty
        }

        holder.cell_image.setImageResource(imgRes)
        holder.cell_text.text = dataSet[position]

        holder.btn_cell.setOnClickListener {
            onClick.invoke(dataSet[position], position)
        }
    }

    override fun getItemCount() = dataSet.size

    fun reset() {
        Manager.fillBoard()
        dataSet = Manager.board
        notifyDataSetChanged()
        Manager.counter = 1
    }
}