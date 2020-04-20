package com.dryfire.themovie.Data;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dryfire.themovie.Modal.TheMovie;
import com.dryfire.themovie.R;


import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<TheMovie> movieList;
    public MovieRecyclerViewAdapter(Context context,List<TheMovie> movieList){
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TheMovie theMovie = movieList.get(position);

        holder.title.setText("Title" + theMovie.getTitle());
        holder.overview.setText("Overview" + theMovie.getOverview());
        holder.release_date.setText("Release Date: " + theMovie.getRelease_date());
        holder.rating.setText("Rating: "+ theMovie.getRating()+"/10");

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView overview;
        TextView release_date;
        TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            overview = (TextView) itemView.findViewById(R.id.overview);
            release_date = (TextView) itemView.findViewById(R.id.releasedate);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
