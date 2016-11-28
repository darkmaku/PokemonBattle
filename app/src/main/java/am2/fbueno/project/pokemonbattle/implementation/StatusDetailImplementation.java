package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import am2.fbueno.project.pokemonbattle.view.StatusDetailPartialView;
import am2.fbueno.project.pokemonbattle.R;

public class StatusDetailImplementation extends StatusDetailPartialView {
    private TextView txtBattle;
    private TextView txtVictories;
    private TextView txtLoses;

    public StatusDetailImplementation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_status_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtBattle = (TextView)getView().findViewById(R.id.txtBattle);
        txtBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().getUserDetailPresenter().showVictories();
            }
        });

        txtVictories = (TextView)getView().findViewById(R.id.txtVictories);
        txtVictories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().getUserDetailPresenter().showVictories();
            }
        });

        txtLoses = (TextView)getView().findViewById(R.id.txtLoses);
        txtLoses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().getUserDetailPresenter().showLooses();
            }
        });
    }

    @Override
    public void setVictories(int value) {
        txtVictories.setText(Integer.toString(value));
    }

    @Override
    public void setLoses(int value) {
        txtLoses.setText(Integer.toString(value));
    }

    @Override
    public void setBattles(int value) {
        txtBattle.setText(Integer.toString(value));
    }
}
