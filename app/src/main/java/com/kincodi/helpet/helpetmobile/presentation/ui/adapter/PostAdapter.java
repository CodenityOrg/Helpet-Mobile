package com.kincodi.helpet.helpetmobile.presentation.ui.adapter;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.squareup.picasso.Picasso;
import java.util.List;
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> posts;
    View.OnClickListener listener ;

    public PostAdapter(List<Post> mPosts) {
        posts = mPosts;
    }

    public void addPosts(List<Post> mPosts) {
        posts.addAll(mPosts);
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new PostViewHolder(v, listener);
    }
    @Override public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        holder.bind(posts.get(position),context);
    }
    @Override public int getItemCount() {
        return posts.size();
    }

    public void onClickItem(View.OnClickListener mListener) {
        listener = mListener;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView description;

        public PostViewHolder(View v, View.OnClickListener listener) {
            super(v);
            img =  v.findViewById(R.id.imgPets);
            description = v.findViewById(R.id.txtDescription);

            v.setOnClickListener(listener);
        }
        public void bind(final Post post,Context context){

            Picasso.with(context)
                    .load(post.getPhotos().get(0).getThumbnailPath())
                    .into(img);

            description.setText(post.getDescription());
        }

    }
}
