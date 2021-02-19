package edu.quinnipiac.ser210.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import edu.quinnipiac.ser210.myapplication.TicTacToe;

public class GameActivity extends AppCompatActivity {

    private TicTacToe ttt = new TicTacToe();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void onClickSquare(View view) {
        //check to see if empty: if not, fill slot and let computer move
        ttt.setMove(0,0/*id of clicked box*/);

    }
}