
package com.miraziz.www.tictactoe;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TicTacToeActivity extends ActionBarActivity implements View.OnClickListener {

    // Store buttons and text from xml. (?)
    private Button[] buttons;
    private TextView information;

    // Booleans.
    private boolean gameOver;
    private boolean myTurn;

    private TicTacToeGame myGame;

    public TicTacToeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        // set buttons to values
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


    }

    // function to start game
    private void startNewGame() {

    }

    // function to see if it's your turn (check for lastMove / Status from server)

    // if you can move, set move based on location and player (send to server)

    // function to see if someone has won (local check)
    public void checkResults() {

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

    @Override
    // parameter v stands for the view that was clicked
    public void onClick(View v) {
        // getID() returns identifier
        // ex. if(v.getID() == R.id.b2) {...}

    }
}
