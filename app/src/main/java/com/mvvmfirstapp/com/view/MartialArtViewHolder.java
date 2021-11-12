package com.mvvmfirstapp.com.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvmfirstapp.com.R;

public class MartialArtViewHolder extends RecyclerView.ViewHolder {
    private final TextView txtMartialArt;
    private final TextView name;
    private final TextView mobileNumber;

    private MartialArtViewHolder(@NonNull View itemView) {
        super(itemView);
        txtMartialArt = itemView.findViewById(R.id.txMartialArts);
        name = itemView.findViewById(R.id.name);
        mobileNumber = itemView.findViewById(R.id.mobileNumber);
    }
    public void bind(String text,String textName,String textMobileNumber){
        txtMartialArt.setText(text);
        name.setText(textName);
        mobileNumber.setText(textMobileNumber);
    }

    public static MartialArtViewHolder create(ViewGroup viewGroup){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item,viewGroup,false);
        return new MartialArtViewHolder(view);

    }
}
