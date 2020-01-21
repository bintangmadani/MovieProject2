package com.example.movieproject2.listproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject2.R;
import com.example.movieproject2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListWatchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mcontext;
    private ArrayList<WatchModel> modelList;

    private OnItemClickListener mItemClickListener;

    public ListWatchAdapter(Context context, ArrayList<WatchModel> modelList) {
        this.mcontext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<WatchModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_project_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ViewHolder) {
            final WatchModel model = getItem(position);
            ViewHolder genericVieHolder = (ViewHolder) holder;

            genericVieHolder.itemTextTitle.setText(model.getTitle());

            if (model.getOverview().length()>50){
                genericVieHolder.itemTextOverview.setText(model.getOverview().substring(0,49)+" ... ");
            }else{
                genericVieHolder.itemTextOverview.setText(model.getPoster());
            }

            genericVieHolder.imagePoster.setImageResource(model.getPoster());
        }

    }

    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private WatchModel getItem(int position) { return modelList.get(position); }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, WatchModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePoster;
        private TextView itemTextTitle;
        private TextView itemTextOverview;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.imagePoster = itemView.findViewById(R.id.imageposter);
            this.itemTextTitle = itemView.findViewById(R.id.item_text_title);
            this.itemTextOverview = itemView.findViewById(R.id.item_text_overview);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));

                }
            });

        }

    }

}
