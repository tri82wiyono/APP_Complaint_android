package com.meridianid.farizdotid.mahasiswaapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuaatmItem;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AtmAdapter extends RecyclerView.Adapter<AtmAdapter.AtmHolder>{

    List<SemuaatmItem> semuaatmItemList;
    Context mContext;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };


    public AtmAdapter(Context context, List<SemuaatmItem> atmList){
        this.mContext = context;
        semuaatmItemList = atmList;
    }

    @Override
    public AtmHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atm, parent, false);
        return new AtmHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AtmHolder holder, int position) {
        final SemuaatmItem semuaatmItem = semuaatmItemList.get(position);
        holder.tvLokasiatm.setText(semuaatmItem.getLokasiatm());
        holder.tvAlamat.setText(semuaatmItem.getAlamat());

        String lokasiAtm = semuaatmItem.getLokasiatm();

        String firstCharLokasiATM = lokasiAtm.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharLokasiATM, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return semuaatmItemList.size();
    }

    public class AtmHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivTextDrawable)
        ImageView ivTextDrawable;
        @BindView(R.id.tvLokasiatm)
        TextView tvLokasiatm;
        @BindView(R.id.tvAlamat)
        TextView tvAlamat;

        public AtmHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }

}
