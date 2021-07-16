package com.example.tictactoe.models

class Player (var turn: Boolean, var score: Int){

    fun changeTurn(isTurn: Boolean){
        turn = !isTurn
    }

    fun updateScore(points: Int){
        score += points
    }

}