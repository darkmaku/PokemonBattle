package am2.fbueno.project.pokemonbattle.implementation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.view.base.View;

public class MainImplementation extends View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponent();
    }

    public void gotoDetails() {
        Intent intent = new Intent(this, UserDetailImplementation.class);
        startActivity(intent);
    }

    private void gotoBattle(){
        Intent intent = new Intent(this, BattleImplementation.class);
        startActivity(intent);
    }

    private void initializeComponent(){
        TextView txtBattle = (TextView)findViewById(R.id.txtBattleGo);
        txtBattle.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                gotoBattle();
            }
        });
        TextView txtDetails = (TextView) findViewById(R.id.txtDetailGo);
        txtDetails.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                gotoDetails();
            }
        });
    }
}
