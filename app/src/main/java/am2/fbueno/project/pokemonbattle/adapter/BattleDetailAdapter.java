package am2.fbueno.project.pokemonbattle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.entity.BattleDetail;

/**
 * Created by FBueno on 11/24/2016.
 */

public class BattleDetailAdapter extends BaseAdapter {
    private Context context;
    private List<BattleDetail> battles;

    public BattleDetailAdapter(Context context, List<BattleDetail> battles) {
        this.context = context;
        this.battles = battles;
    }

    @Override
    public int getCount() {
        return battles.size();
    }

    @Override
    public Object getItem(int i) {
        return battles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_battles, null);
            ViewHolder holder = new ViewHolder();
            holder.txtWinner = (TextView)v.findViewById(R.id.txtWinner);
            holder.txtWinnerScore = (TextView)v.findViewById(R.id.txtWinnerScore);
            holder.txtLooser = (TextView)v.findViewById(R.id.txtLooser);
            holder.txtLooserScore = (TextView)v.findViewById(R.id.txtLooserScore);
            v.setTag(holder);
        }
        BattleDetail entry = battles.get(i);
        if(entry != null) {
            ViewHolder holder = (ViewHolder)v.getTag();
            holder.txtWinner.setText(entry.getWinner());
            holder.txtWinnerScore.setText(Integer.toString(entry.getWinnerScore()));
            holder.txtLooser.setText(entry.getLooser());
            holder.txtLooserScore.setText(Integer.toString(entry.getLooserScore()));
        }
        return v;
    }

    static class ViewHolder
    {
        TextView txtWinner;
        TextView txtWinnerScore;
        TextView txtLooser;
        TextView txtLooserScore;
    }
}
