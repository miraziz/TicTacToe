
package com.miraziz.www.tictactoe;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends ActionBarActivity implements View.OnClickListener {

    // To be honest, I don't understand what these lines are saying.
    private static TicTacToeActivity _instance;

    public static TicTacToeActivity getInstance() {
        return _instance;
    }

    // Create the TicTacToeGame object.
    private TicTacToeGame myGame;

    // Store buttons and text from xml. (?)
    private Button[] buttons;
    private TextView information;

    // Booleans.
    private boolean gameOver;
    private boolean myTurn;

    // To alternate between 'X' and 'O'.
    private char alternating;

    // public TicTacToeActivity() {
    // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        // Set buttons to array values.
        buttons = new Button[9];
        buttons[0] = (Button) findViewById(R.id.b0);
        buttons[1] = (Button) findViewById(R.id.b1);
        buttons[2] = (Button) findViewById(R.id.b2);
        buttons[3] = (Button) findViewById(R.id.b3);
        buttons[4] = (Button) findViewById(R.id.b4);
        buttons[5] = (Button) findViewById(R.id.b5);
        buttons[6] = (Button) findViewById(R.id.b6);
        buttons[7] = (Button) findViewById(R.id.b7);
        buttons[8] = (Button) findViewById(R.id.b8);

        information = (TextView) findViewById(R.id.gameInformation);

        myGame = new TicTacToeGame();
        startNewGame();

    }

    // function to start game
    private void startNewGame() {

        myGame.clearBoard();
        gameOver = false;
        myTurn = true;
        alternating = 'X';

        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setOnClickListener(this);
        }

        information.setText("Player 1 will go first.");

    }

    // function to see if it's your turn (check for lastMove / Status from server)

    // if you can move, set move based on location and player (send to server)

    // Function to see if someone has won (local check).
    public void checkResults() {

        int result = myGame.checkForWinner();

        if(result == 0) {
            return;
        }

        if(result == 3) {
            information.setText("Player 1 wins.");
            gameOver = true;
        }
        else if(result == 2) {
            information.setText("Player 2 wins.");
            gameOver = true;
        }
        else if(result == 1) {
            information.setText("It's a tie.");
            gameOver = true;
        }
        else {
            information.setText("Something has gone wrong.");
            gameOver = true;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tic_tac_toe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setMove(char player, int location) {

        myGame.setMove(player, location);

        buttons[location].setEnabled(false);
        buttons[location].setText(String.valueOf(player));

        if(player == 'X') {
            buttons[location].setTextColor(Color.rgb(0,200, 0));
        }
        else {
            buttons[location].setTextColor(Color.rgb(200,0,0));
        }

    }


    @Override
    // parameter v stands for the view that was clicked
    public void onClick(View v) {

        // getID() returns identifier
        // ex. if(v.getID() == R.id.b2) {...}
        Button clicked = (Button) v;
        int move = -1;

        if(clicked.isEnabled() && !gameOver) {
            for(int i = 0; i < buttons.length; i++) {
                if(buttons[i].getId() == clicked.getId()) {
                    move = i;
                    break;
                }
            }
        }

        if(move != -1) {
            // This setMove is DIFFERENT from myGame.setMove.
            setMove(alternating, move);
            if(alternating == 'X') {
                alternating = 'O';
                information.setText("Go, Player Two.");
            } else {
                alternating = 'X';
                information.setText("Go, Player One.");
            }
            checkResults();
        }

    }
}
