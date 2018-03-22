package com.kincodi.helpet.helpetmobile.presentation.ui.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.model.Post;

import java.util.ArrayList;
import java.util.List;
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    public PostAdapter(List items) {
        this.items = items;
        items = new ArrayList<>(items);
    }
    private List<Post> items;
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new PostViewHolder(v);
    }
    @Override public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {
        holder.bind(items.get(position));
    }
    @Override public int getItemCount() {
        return items.size();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView images;
        private TextView description;
        private TextView location;
        private TextView race;
        public PostViewHolder(View v) {
            super(v);
            images = (TextView) v.findViewById(R.id.txtName);
            description = (TextView) v.findViewById(R.id.txtDescription);
            location = (TextView) v.findViewById(R.id.txtAddress);
            race = (TextView) v.findViewById(R.id.txtDetails);
        }
        public void bind(final Post post){
            images.setText(post.getImages());
            description.setText(post.getDescription());
            location.setText(post.getLocation());
            race.setText(post.getRace());
        }
    }

}
