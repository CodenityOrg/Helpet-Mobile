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
    //private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }
    private List<Post> posts;
    public PostAdapter(List posts,OnItemClickListener listener) {
        this.posts = posts;
        posts = new ArrayList<>(posts);
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new PostViewHolder(v);
    }
    @Override public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }
    @Override public int getItemCount() {
        return posts.size();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private TextView kind;
        private TextView race;
        public PostViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.txtName);
            description = (TextView) v.findViewById(R.id.txtDescription);
            kind = (TextView) v.findViewById(R.id.txtKind);
            race = (TextView) v.findViewById(R.id.txtRace);
        }
        public void bind(final Post post){
            name.setText(post.getName());
            description.setText(post.getDescription());
            race.setText(post.getRace());
            kind.setText(post.getKind());
        }
        /*963749339*/
    }

}
