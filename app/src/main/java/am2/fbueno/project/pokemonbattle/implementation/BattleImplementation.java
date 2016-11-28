package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.BattlePresenter;
import am2.fbueno.project.pokemonbattle.view.BattleView;

/**
 * Created by FBueno on 11/26/2016.
 */

public class BattleImplementation extends BattleView {
    private TextView txtWinner;
    private TextView txtLooser;
    private TextView txtOpponent;
    private Button btnSearch;
    private Button btnStart;

    public BattleImplementation(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        initialize();
    }

    @Override
    public void setOpponentId(String opponentId) {
        txtOpponent.setText(opponentId);
    }

    @Override
    public String getOpponentId() {
        return txtOpponent.getText().toString();
    }

    @Override
    public void setResultBattle(String winner, int winnerScore, String looser, int looserScore) {
        txtWinner.setText(winner + " - "+winnerScore);
        txtLooser.setText(looser+ " - " + looserScore);
    }

    private void initialize(){
        setBattlePresenter(BattlePresenter.Make(this));
        txtWinner = (TextView)findViewById(R.id.txtWinnerResult);
        txtLooser = (TextView)findViewById(R.id.txtLooserResult);
        txtOpponent = (TextView) findViewById(R.id.txtOpponent);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBattlePresenter().startBattle();
            }
        });
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBattlePresenter().findOpponent();
            }
        });
    }
}
