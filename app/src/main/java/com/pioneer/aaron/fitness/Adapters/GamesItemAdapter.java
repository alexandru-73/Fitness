package com.pioneer.aaron.fitness.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pioneer.aaron.fitness.Interface.RecyclerViewItemClickListener;
import com.pioneer.aaron.fitness.R;

import java.util.List;

/**
 * Created by Aaron on 9/6/15.
 */
public class GamesItemAdapter extends RecyclerView.Adapter<GamesItemAdapter.ItemViewHolder>{
    private List<GamesItemModel> modelList;
    private RecyclerViewItemClickListener mItemClickListener;

    public GamesItemAdapter(List<GamesItemModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item_layout, parent, false);
        return new ItemViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        GamesItemModel model = modelList.get(position);
        holder.game_thumbnail.setImageResource(model.game_thumbnail);
        holder.game_name.setText(model.game_name);
        holder.game_participant.append(model.game_participant);
        holder.game_countdown.append(model.game_countdown);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setOnItemClickListener(RecyclerViewItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;

    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView game_thumbnail;
        private TextView game_name;
        private TextView game_participant;
        private TextView game_countdown;
        private RecyclerViewItemClickListener mItemClickListener;

        public ItemViewHolder(View itemView, RecyclerViewItemClickListener itemClickListener) {
            super(itemView);
            game_thumbnail = (ImageView) itemView.findViewById(R.id.game_thumbnail);
            game_name = (TextView) itemView.findViewById(R.id.game_name);
            game_participant = (TextView) itemView.findViewById(R.id.game_participant);
            game_countdown = (TextView) itemView.findViewById(R.id.game_countdown);
            this.mItemClickListener = itemClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
