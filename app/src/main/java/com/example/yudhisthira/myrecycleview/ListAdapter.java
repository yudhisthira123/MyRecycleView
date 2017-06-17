package com.example.yudhisthira.myrecycleview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by yudhisthira on 16/06/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {

    Context     context;
    List<Item>  itemList = new ArrayList<>();
    Picasso     picasso;

    public ListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;

        picasso = new Picasso.Builder(context).executor(Executors.newSingleThreadExecutor()).build();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int index) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_view, viewGroup, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int index) {

        Item item = itemList.get(index);

        itemHolder.cardName.setText(item.name);
        itemHolder.cardAddress.setText(item.address);
//        itemHolder.cardImage.setImageDrawable();
//        itemHolder.cardView.setCardBackgroundColor(item.intValue);


        picasso.load(R.drawable.ic_launcher_round).into(itemHolder.cardImage);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onViewRecycled(ItemHolder holder) {

        picasso.cancelRequest(holder.cardImage);

    }

    public void setData(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        protected ImageView cardImage;
        protected TextView cardName;
        protected TextView cardAddress;
        protected CardView cardView;

        public ItemHolder(View itemView) {
            super(itemView);
            cardImage = (ImageView)itemView.findViewById(R.id.cardImage);
            cardName = (TextView)itemView.findViewById(R.id.cardName);
            cardAddress = (TextView)itemView.findViewById(R.id.cardAddress);
            cardView = (CardView)itemView;
        }


    }

}
