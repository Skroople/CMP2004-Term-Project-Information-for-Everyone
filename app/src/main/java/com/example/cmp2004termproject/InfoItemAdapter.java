package com.example.cmp2004termproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cmp2004termproject.model.InfoItem;
import java.util.List;

public class InfoItemAdapter extends RecyclerView.Adapter<InfoItemAdapter.ViewHolder> {

    private List<InfoItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(InfoItem item);
    }

    public InfoItemAdapter(List<InfoItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InfoItem item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvSummary.setText(item.getSummary());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSummary;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvItemTitle);
            tvSummary = itemView.findViewById(R.id.tvItemSummary);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(items.get(position));
                        }
                    }
                }
            });
        }
    }
}