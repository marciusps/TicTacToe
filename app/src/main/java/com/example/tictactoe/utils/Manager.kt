package com.example.tictactoe.utils

object Manager {
    var board: ArrayList<String> = ArrayList()
    var boardMap: HashMap<Int, String> = HashMap()
    var counter = 1
    var player1Turn = true
    var player1Win = false
    var player2Win = false

    fun fillBoard() {
        board = ArrayList()
        for(i in 1..9){
            board.add(i.toString())
            boardMap[i] = ""
        }
    }

    fun markCell(position: Int){
        if( player1Turn)
            board[position] = "x"
        if(!player1Turn)
            board[position] = "o"
        counter++
        player1Turn = !player1Turn
    }

    fun isClickable(position: Int): Boolean{
        return boardMap[position] == ""
    }

    fun player1Win() {
        if ((boardMap[0] == "x" && boardMap[1] == "x" && boardMap[2] == "x") ||
            (boardMap[3] == "x" && boardMap[4] == "x" && boardMap[5] == "x") ||
            (boardMap[6] == "x" && boardMap[7] == "x" && boardMap[8] == "x") ||
            (boardMap[0] == "x" && boardMap[4] == "x" && boardMap[8] == "x") ||
            (boardMap[2] == "x" && boardMap[4] == "x" && boardMap[6] == "x") ||
            (boardMap[0] == "x" && boardMap[3] == "x" && boardMap[6] == "x") ||
            (boardMap[1] == "x" && boardMap[4] == "x" && boardMap[7] == "x") ||
            (boardMap[2] == "x" && boardMap[5] == "x" && boardMap[8] == "x")
        ) {player1Win = true}
    }

    fun player2Win() {
        if ((boardMap[0] == "o" && boardMap[1] == "o" && boardMap[2] == "o") ||
            (boardMap[3] == "o" && boardMap[4] == "o" && boardMap[5] == "o") ||
            (boardMap[6] == "o" && boardMap[7] == "o" && boardMap[8] == "o") ||
            (boardMap[0] == "o" && boardMap[4] == "o" && boardMap[8] == "o") ||
            (boardMap[2] == "o" && boardMap[4] == "o" && boardMap[6] == "o") ||
            (boardMap[0] == "o" && boardMap[3] == "o" && boardMap[6] == "o") ||
            (boardMap[1] == "o" && boardMap[4] == "o" && boardMap[7] == "o") ||
            (boardMap[2] == "o" && boardMap[5] == "o" && boardMap[8] == "o")
        ) {player2Win = true}
    }
}