package com.example.tictactoe.utils

import androidx.core.text.isDigitsOnly

object Manager {
    var board: ArrayList<String> = ArrayList()
    var counter = 1
    var player1Turn = true
    var draw = false
    var player1 = false
    var player2 = false

    fun fillBoard() {
        board = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    }

    fun playerTurn(): String {
        if (player1Turn)
            return "Player 1"
        return "Player 2"
    }

    fun markCell(position: Int) {
        if (!player1Win() && !player2Win()) {
            board[position] = "x"
            counter++
            player1Turn = !player1Turn
            if (!player1Win()) {
                botMove()
            }
        }
    }

    fun identifyWinner() {
        if (counter == 11 && !player1Win() && !player2Win()) {
            draw = true
        }
        if (player1Win()) {
            player1 = true
        }
        if (player2Win()) {
            player2 = true
        }
    }

    fun player1Win(): Boolean {
        if ((board[0] == "x" && board[1] == "x" && board[2] == "x") ||
            (board[3] == "x" && board[4] == "x" && board[5] == "x") ||
            (board[6] == "x" && board[7] == "x" && board[8] == "x") ||
            (board[0] == "x" && board[4] == "x" && board[8] == "x") ||
            (board[2] == "x" && board[4] == "x" && board[6] == "x") ||
            (board[0] == "x" && board[3] == "x" && board[6] == "x") ||
            (board[1] == "x" && board[4] == "x" && board[7] == "x") ||
            (board[2] == "x" && board[5] == "x" && board[8] == "x")
        ) return true
        return false
    }

    fun player2Win(): Boolean {
        if ((board[0] == "o" && board[1] == "o" && board[2] == "o") ||
            (board[3] == "o" && board[4] == "o" && board[5] == "o") ||
            (board[6] == "o" && board[7] == "o" && board[8] == "o") ||
            (board[0] == "o" && board[4] == "o" && board[8] == "o") ||
            (board[2] == "o" && board[4] == "o" && board[6] == "o") ||
            (board[0] == "o" && board[3] == "o" && board[6] == "o") ||
            (board[1] == "o" && board[4] == "o" && board[7] == "o") ||
            (board[2] == "o" && board[5] == "o" && board[8] == "o")
        ) return true
        return false
    }

    fun botMove() {
        counter++
        player1Turn = !player1Turn

        if (board[0] == "x" && board[4].isDigitsOnly() && board[8].isDigitsOnly()) {
            board[4] = "o"; return
        }
        if (board[0].isDigitsOnly() && board[4].isDigitsOnly() && board[8] == "x") {
            board[4] = "o"; return
        }
        if (board[2] == "x" && board[4].isDigitsOnly() && board[6].isDigitsOnly()) {
            board[4] = "o"; return
        }
        if (board[2].isDigitsOnly() && board[4].isDigitsOnly() && board[6] == "x") {
            board[4] = "o"; return
        }
        //rsrsr
        if (board[0] == "o" && board[1] == "o" && board[2].isDigitsOnly()) {
            board[2] = "o"; return
        }
        if (board[0] == "o" && board[1].isDigitsOnly() && board[2] == "o") {
            board[1] = "o"; return
        }
        if (board[0].isDigitsOnly() && board[1] == "o" && board[2] == "o") {
            board[0] = "o"; return
        }

        if (board[3].isDigitsOnly() && board[4] == "o" && board[5] == "o") {
            board[3] = "o"; return
        }
        if (board[3] == "o" && board[4].isDigitsOnly() && board[5] == "o") {
            board[4] = "o"; return
        }
        if (board[3] == "o" && board[4] == "o" && board[5].isDigitsOnly()) {
            board[5] = "o"; return
        }

        if (board[6].isDigitsOnly() && board[7] == "o" && board[8] == "o") {
            board[6] = "o"; return
        }
        if (board[6] == "o" && board[7].isDigitsOnly() && board[8] == "o") {
            board[7] = "o"; return
        }
        if (board[6] == "o" && board[7] == "o" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }

        if (board[0].isDigitsOnly() && board[4] == "o" && board[8] == "o") {
            board[0] = "o"; return
        }
        if (board[0] == "o" && board[4].isDigitsOnly() && board[8] == "o") {
            board[4] = "o"; return
        }
        if (board[0] == "o" && board[4] == "o" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }

        if (board[2].isDigitsOnly() && board[4] == "o" && board[6] == "o") {
            board[2] = "o"; return
        }
        if (board[2] == "o" && board[4].isDigitsOnly() && board[6] == "o") {
            board[4] = "o"; return
        }
        if (board[2] == "o" && board[4] == "o" && board[6].isDigitsOnly()) {
            board[6] = "o"; return
        }

        if (board[0].isDigitsOnly() && board[3] == "o" && board[6] == "o") {
            board[0] = "o"; return
        }
        if (board[0] == "o" && board[3].isDigitsOnly() && board[6] == "o") {
            board[3] = "o"; return
        }
        if (board[0] == "o" && board[3] == "o" && board[6].isDigitsOnly()) {
            board[6] = "o"; return
        }

        if (board[1].isDigitsOnly() && board[4] == "o" && board[7] == "o") {
            board[1] = "o"; return
        }
        if (board[1] == "o" && board[4].isDigitsOnly() && board[7] == "o") {
            board[4] = "o"; return
        }
        if (board[1] == "o" && board[4] == "o" && board[7].isDigitsOnly()) {
            board[7] = "o"; return
        }

        if (board[2].isDigitsOnly() && board[5] == "o" && board[8] == "o") {
            board[2] = "o"; return
        }
        if (board[2] == "o" && board[5].isDigitsOnly() && board[8] == "o") {
            board[5] = "o"; return
        }
        if (board[2] == "o" && board[5] == "o" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }
        //rsrsr
        if (board[0] == "x" && board[1] == "x" && board[2].isDigitsOnly()) {
            board[2] = "o"; return
        }
        if (board[0] == "x" && board[1].isDigitsOnly() && board[2] == "x") {
            board[1] = "o"; return
        }
        if (board[0].isDigitsOnly() && board[1] == "x" && board[2] == "x") {
            board[0] = "o"; return
        }

        if (board[3].isDigitsOnly() && board[4] == "x" && board[5] == "x") {
            board[3] = "o"; return
        }
        if (board[3] == "x" && board[4].isDigitsOnly() && board[5] == "x") {
            board[4] = "o"; return
        }
        if (board[3] == "x" && board[4] == "x" && board[5].isDigitsOnly()) {
            board[5] = "o"; return
        }

        if (board[6].isDigitsOnly() && board[7] == "x" && board[8] == "x") {
            board[6] = "o"; return
        }
        if (board[6] == "x" && board[7].isDigitsOnly() && board[8] == "x") {
            board[7] = "o"; return
        }
        if (board[6] == "x" && board[7] == "x" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }

        if (board[0].isDigitsOnly() && board[4] == "x" && board[8] == "x") {
            board[0] = "o"; return
        }
        if (board[0] == "x" && board[4].isDigitsOnly() && board[8] == "x") {
            board[4] = "o"; return
        }
        if (board[0] == "x" && board[4] == "x" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }

        if (board[2].isDigitsOnly() && board[4] == "x" && board[6] == "x") {
            board[2] = "o"; return
        }
        if (board[2] == "x" && board[4].isDigitsOnly() && board[6] == "x") {
            board[4] = "o"; return
        }
        if (board[2] == "x" && board[4] == "x" && board[6].isDigitsOnly()) {
            board[6] = "o"; return
        }

        if (board[0].isDigitsOnly() && board[3] == "x" && board[6] == "x") {
            board[0] = "o"; return
        }
        if (board[0] == "x" && board[3].isDigitsOnly() && board[6] == "x") {
            board[3] = "o"; return
        }
        if (board[0] == "x" && board[3] == "x" && board[6].isDigitsOnly()) {
            board[6] = "o"; return
        }

        if (board[1].isDigitsOnly() && board[4] == "x" && board[7] == "x") {
            board[1] = "o"; return
        }
        if (board[1] == "x" && board[4].isDigitsOnly() && board[7] == "x") {
            board[4] = "o"; return
        }
        if (board[1] == "x" && board[4] == "x" && board[7].isDigitsOnly()) {
            board[7] = "o"; return
        }

        if (board[2].isDigitsOnly() && board[5] == "x" && board[8] == "x") {
            board[2] = "o"; return
        }
        if (board[2] == "x" && board[5].isDigitsOnly() && board[8] == "x") {
            board[5] = "o"; return
        }
        if (board[2] == "x" && board[5] == "x" && board[8].isDigitsOnly()) {
            board[8] = "o"; return
        }

        for (i in 0..8) {
            if (board[i] != "x" && board[i] != "o") {
                board[i] = "o"; return
            }
        }
    }
}