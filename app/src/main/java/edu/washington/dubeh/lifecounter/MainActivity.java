package edu.washington.dubeh.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void buttonClick(View v) {
        Button b = (Button) v;
        String player = b.getTag().toString();
        String value = b.getText().toString();
        int id = getResources().getIdentifier(player, "id", getPackageName());
        TextView lifeText = (TextView) findViewById(id);
        TextView loser = (TextView) findViewById(R.id.loser);
        int life = Integer.parseInt(lifeText.getText().toString());
        switch(b.getText().toString()) {
            case "+":
                life++;
            break;
            case "+5":
                life = life + 5;
            break;
            case "-":
                life--;
            break;
            default:
                life = life - 5;
            break;
        }
        lifeText.setText(String.valueOf(life));
        if(life <= 0) {
            loser.setText("player " + player.charAt(6) + " LOSES!");
        }
    }
}