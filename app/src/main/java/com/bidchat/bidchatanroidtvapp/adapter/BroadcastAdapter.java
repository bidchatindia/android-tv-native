package com.bidchat.bidchatanroidtvapp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bidchat.bidchatanroidtvapp.Model.Broadcast;
import com.bidchat.bidchatanroidtvapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BroadcastAdapter extends RecyclerView.Adapter<BroadcastAdapter.BillViewHolder> {

    List<Broadcast> bills;
    Context context;
    private BroadcastiewHolderListener mcallback;

    public enum BillHolderType {CashCounter, Delivery}

    public interface BroadcastiewHolderListener {
        void onChildClicked(Broadcast broadcast);
        //Type of view to be presented here
    }

    public BroadcastAdapter(Context context, List<Broadcast> bills, BroadcastiewHolderListener listener) {
        this.context = context;
        this.bills = bills;
        this.mcallback = listener;
    }

    public void setListener(BroadcastiewHolderListener listener) {
        this.mcallback = listener;
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BillViewHolder holder = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_broadcast, parent, false);
        holder = new BillViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        final Broadcast broadcast = bills.get(position);
        /*populate the current details here*/
        holder.txtVidThumb.setText("Tags" + broadcast.getHash_tag1() + broadcast.getHash_tag2());
        Picasso.with(context)
                .load(broadcast.getVideo_thumb_url())
                .into(holder.ivVidThumb);
        holder.txtVidThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcallback.onChildClicked(broadcast);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //Todo: need to find out what this can be used for(Performance improvement)
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    static class BillViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_vid_thumb)
        ImageView ivVidThumb;
        @Bind(R.id.txt_vid_thumb)
        TextView txtVidThumb;
        View parentView;

        BillViewHolder(View view) {
            super(view);
            parentView = view;
            ButterKnife.bind(this, view);
        }
    }
}