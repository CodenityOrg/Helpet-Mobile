package com.kincodi.helpet.helpetmobile.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.kincodi.helpet.helpetmobile.R;
import com.stripe.android.net.RequestOptions;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Julio on 20/03/2018.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.FileViewHolder> {

    private final ArrayList<String> paths;
    private final Context context;
    private int imageSize;

    public ImageAdapter(Context context,ArrayList<String> paths) {
        this.paths = paths;
        this.context = context;
        setColumnNumber(context,3);
    }

    @Override public ImageAdapter.FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        return new FileViewHolder(view);
    }

    private void setColumnNumber(Context context, int columnNum) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        imageSize = widthPixels / columnNum;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.FileViewHolder holder, int position) {
        String path = paths.get(position);
        Glide.with(context)
                .load(new File(path))
                .apply(com.bumptech.glide.request.RequestOptions.centerCropTransform()
                .dontAnimate()
                .override(imageSize,imageSize)
                .placeholder(R.mipmap.ic_launcher))
                .thumbnail(0.5f)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return paths.size();
    }

    public class FileViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        public FileViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.iv_photo);
        }
    }
}
