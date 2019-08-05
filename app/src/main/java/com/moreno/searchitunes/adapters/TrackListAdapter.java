package com.moreno.searchitunes.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.moreno.searchitunes.R;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.TrackListViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrackListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int HEADER_TYPE = 0;
    private static int ITEM_TYPE = 1;
    List<Track> trackList = new ArrayList<>();
    private TrackListViewModel viewModel;

    public interface OnItemClickListener {
        void onItemClick(Track item);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public TrackListAdapter(TrackListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
        notifyDataSetChanged();
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        if (i == HEADER_TYPE){
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.header_list_item, viewGroup, false);
            return new HeaderViewHolder(binding);
        }else{
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.track_list_item, viewGroup, false);
            return new ItemViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Track track = trackList.get(i);
        if (viewHolder.getItemViewType() == HEADER_TYPE){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder)viewHolder;
            headerViewHolder.bind(viewModel);
        }else {
            ItemViewHolder itemViewHolder = (ItemViewHolder)viewHolder;
            itemViewHolder.bind(track,viewModel,onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return trackList != null ? trackList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return HEADER_TYPE;
        else
            return ITEM_TYPE;
    }
}
