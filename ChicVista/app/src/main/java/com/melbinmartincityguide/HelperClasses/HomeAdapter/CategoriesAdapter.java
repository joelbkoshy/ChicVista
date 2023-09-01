package com.melbinmartincityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melbinmartincityguide.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {
    ArrayList<CategoriesHelperClass> categoriesList;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        return new AdapterAllCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        CategoriesHelperClass helperClass = categoriesList.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.gettitle());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
        }
    }
}
