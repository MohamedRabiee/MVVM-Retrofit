package com.example.mvvmretrofit.viewmodel.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmretrofit.R;
import com.example.mvvmretrofit.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<PostModel> postsList = new ArrayList<>();
    LayoutInflater inflater;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.post_item_view,parent,false);
//        return new ViewHolder(view);
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.userTV.setText(postsList.get(position).getUserId()+"");
        holder.bodyTV.setText(postsList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setList(List<PostModel> postsList)
    {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV , userTV , bodyTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIdTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);

        }
    }
}
