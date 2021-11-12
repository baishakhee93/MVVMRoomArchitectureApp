package com.mvvmfirstapp.com.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvmfirstapp.com.room_database.MartialArt;

public class MartialArtListAdapter extends ListAdapter<MartialArt, MartialArtViewHolder> {

    private ListItemLongClickListner mListItemLongClickListner;

    protected MartialArtListAdapter(ListItemLongClickListner listItemLongClickListner,@NonNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
       this.mListItemLongClickListner=listItemLongClickListner;
    }


    @NonNull
    @Override
    public MartialArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MartialArtViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MartialArtViewHolder holder, int position) {
        MartialArt martialArt=getItem(position);
        holder.bind(martialArt.getFavMartialArt(),martialArt.getFavName(),martialArt.getFavMobileNumber());

        holder.itemView.setOnLongClickListener(view ->{
         mListItemLongClickListner.listItmLongClicked(martialArt);
           return true;
        });

    }



    public static class MartialArtDiff extends DiffUtil.ItemCallback<MartialArt>{

        @Override
        public boolean areItemsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem.getFavMartialArt().equals(newItem.getFavMartialArt());
        }
    }
}
