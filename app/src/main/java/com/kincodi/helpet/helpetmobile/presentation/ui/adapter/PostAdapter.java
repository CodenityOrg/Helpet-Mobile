package com.kincodi.helpet.helpetmobile.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.model.Pet;

import java.util.List;

/**
 * Created by Julio on 13/03/2018.
 */

public class PostAdapter /*extends RecyclerView.Adapter<PostAdapter.PostViewHolder>*/ {
/*
    private List<Pet> items;

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pet, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder holder, int position) {
        holder.urls.setImageResource(items.get(position).getUrls());
        holder.description.setText(items.get(position).getDescription());
        holder.details.setText(items.get(position).getDetails());
        holder.address.setText(items.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private ImageView urls;
        private TextView description;
        private TextView address;
        private TextView details;

        public PostViewHolder(View v) {
            super(v);
            urls = (ImageView) v.findViewById(R.id.imgPets);
            description = (TextView) v.findViewById(R.id.txtDescription);
            address = (TextView) v.findViewById(R.id.txtAddress);
            details = (TextView) v.findViewById(R.id.txtDetails);

        }
    }
*/
}
