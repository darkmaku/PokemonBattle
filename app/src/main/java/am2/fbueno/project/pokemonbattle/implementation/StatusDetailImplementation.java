package am2.fbueno.project.pokemonbattle.implementation;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.UserDetailPresenter;
import am2.fbueno.project.pokemonbattle.view.StatusDetailPartialView;
import am2.fbueno.project.pokemonbattle.view.UserDetailView;

public class StatusDetailImplementation extends StatusDetailPartialView {

    public StatusDetailImplementation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_status_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txtBattle = (TextView)getView().findViewById(R.id.txtBattle);
        TextView txtVictories = (TextView)getView().findViewById(R.id.txtVictories);
        TextView txtLoses = (TextView)getView().findViewById(R.id.txtLoses);
        txtBattle.setText(getUserDetailView().showBattles());
        txtVictories.setText(getUserDetailView().showVictories());
        txtLoses.setText(getUserDetailView().showLoses());
        txtBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().showBattles();
            }
        });
        txtVictories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().showVictories();
            }
        });
        txtLoses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserDetailView().showLoses();
            }
        });
    }



}
