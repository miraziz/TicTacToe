
package com.miraziz.www.tictactoe;

// Created by Divya on 1/6/2015.

// The simple 3x3 version of TicTacToe.
// Functions: clearBoard, isEmpty(slot), setMove(value, slot), checkForWinner
public class TicTacToeGame {

    public static final char PLAYER_A = 'X';
    public static final char PLAYER_B = 'O';
    public static final char EMPTY_SLOT = ' ';

    // All slots are empty upon creation.
    private char board[] = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    private final int BOARD_SIZE = board.length;


    // Constructor currently has no parameters.
    public TicTacToeGame() {
    }


    // Clears board values by setting them to ' '.
    public void clearBoard() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            board[i] = EMPTY_SLOT;
        }
    }


    // Checks to see if a given slot is available.
    public boolean isEmpty(int i) {
        return board[i] == EMPTY_SLOT;
    }


    // Checks to ensure a requested move is possible then sets it.
    // Takes two parameters, the first being 'X' or 'O' and the second
    // being the slot in which to insert the value.
    public boolean setMove(char value, int slot) {
        // Ensure slot number is valid before attempting anything.
        if(0 <= slot && slot <= 8) {
            // Then make sure the valid slot is actually available.
            if(isEmpty(slot)) {
                board[slot] = value;
                //  TODO; requires GameService
                //  currently only makes local change
                //  make change to server
                return true;
            }
        }
        // If unsuccessful:
        return false;
    }


    // Returns 3 if Player A has won, 2 if Player B has won, 1 in case of a tie, and 0 otherwise.
    public int checkForWinner() {
        //  TODO;
        //  currently checks locally for a win to display immediate message
        //  make change to server

        // Check for horizontal wins.
        for(int i = 0; i < BOARD_SIZE; i += 3) {
            if(PLAYER_A == board[i] && PLAYER_A == board[i+1] && PLAYER_A == board[i+2]) {
                return 3;
            }
            if (PLAYER_B == board[i] && PLAYER_B == board[i+1] && PLAYER_B == board[i+2]) {
                return 2;
            }
        }

        // Check for vertical wins.
        for(int i = 0; i < 3; i++) {
            if(PLAYER_A == board[i] && PLAYER_A == board[i+3] && PLAYER_A == board[i+6]) {
                return 3;
            }
            if (PLAYER_B == board[i] && PLAYER_B == board[i+3] && PLAYER_B == board[i+6]) {
                return 2;
            }
        }

        // Check for diagonal wins.
        if(PLAYER_A == board[0] && PLAYER_A == board[4] && PLAYER_A == board[8]) {
            return 3;
        }
        if(PLAYER_B == board[0] && PLAYER_B == board[4] && PLAYER_B == board[8]) {
            return 2;
        }

        // Check for a tie (board is full but no one has won).
        boolean check = true;
        int i = 0;
        while(check && i < BOARD_SIZE) {
            if(board[i] == EMPTY_SLOT){
                // Stops checking if an empty slot is detected.
                check = false;
            }
            i += 1;
        }
        if(check) {
            return 1;
        }

        // If no wins are detected:
        return 0;
    }

}
