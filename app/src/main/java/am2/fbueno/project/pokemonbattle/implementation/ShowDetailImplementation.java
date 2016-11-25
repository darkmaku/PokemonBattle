package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.adapter.BattleDetailAdapter;
import am2.fbueno.project.pokemonbattle.entity.BattleDetail;
import am2.fbueno.project.pokemonbattle.view.ShowDetailPartialView;

/**
 * Created by FBueno on 11/25/2016.
 */

public class ShowDetailImplementation extends ShowDetailPartialView {
    private ListView battlesList;

    public ShowDetailImplementation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        battlesList = (ListView)getView().findViewById(R.id.lstBattles);
    }

    @Override
    public void setBattlesDetail(List<BattleDetail> battles) {
        BattleDetailAdapter adapter = new BattleDetailAdapter(getView().getContext(),battles);
        battlesList.setAdapter(adapter);
    }
}
