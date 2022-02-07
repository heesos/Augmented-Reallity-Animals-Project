package com.google.ar.university.project.app;



import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private clickListener listener;
    private int videoPosition;

    RecyclerViewAdapter(Context mContext,clickListener listener){
        this.mContext = mContext;
        this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.files_list,parent,false);
        return new FileLayoutHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FileLayoutHolder)holder).videoTitle.setText(Constant.allMediaList.get(position).getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(Constant.allMediaList.get(position));

        Glide.with(mContext)
                .load(uri).thumbnail(0.1f).into(((FileLayoutHolder)holder).thumbnail);


    }

    @Override
    public int getItemCount() {
        return Constant.allMediaList.size();
    }

    class FileLayoutHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView thumbnail;
        TextView videoTitle;
        ImageView ic_share_btn;
        clickListener clickListener;

        public FileLayoutHolder(@NonNull View itemView,clickListener clickListener) {
            super(itemView);


            thumbnail = itemView.findViewById(R.id.thumbnail);
            videoTitle = itemView.findViewById(R.id.videotitle);
            ic_share_btn = itemView.findViewById(R.id.ic_more_btn);
            this.clickListener=clickListener;
            itemView.setOnClickListener(this);
//            ic_share_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onIconShareClick();
//                }
//            });
//
//            thumbnail.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onThumbnailClick(videoPosition);
//                }
//            });

        }

        @Override
        public void onClick(View v) {
            clickListener.onThumbnailClick(getAdapterPosition());
        }
    }

    public interface clickListener {
        void onIconShareClick();
        void onThumbnailClick(int position);
    }

}