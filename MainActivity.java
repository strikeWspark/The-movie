package com.dryfire.themovie.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dryfire.themovie.Util.Constant;
import com.dryfire.themovie.Data.MovieRecyclerViewAdapter;
import com.dryfire.themovie.R;
import com.dryfire.themovie.Modal.TheMovie;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieRecyclerViewAdapter movieRecyclerViewAdapter;
    private List<TheMovie> movieList;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = new ArrayList<>();

        movieList = getMovies();

        movieRecyclerViewAdapter = new MovieRecyclerViewAdapter(this,movieList);
        recyclerView.setAdapter(movieRecyclerViewAdapter);
        movieRecyclerViewAdapter.notifyDataSetChanged();






    }

    private List<TheMovie> getMovies() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constant.API_KEY, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray movieArray = response.getJSONArray("results");
                    for(int i = 0;i<movieArray.length();i++){

                        JSONObject movieObj = movieArray.getJSONObject(i);

                        TheMovie theMovie = new TheMovie();

                        theMovie.setTitle(movieObj.getString("original_title"));
                        theMovie.setOverview(movieObj.getString("overview"));
                        theMovie.setRelease_date(movieObj.getString("release_date"));
                        theMovie.setRating(movieObj.getString("rating"));

                        Log.d("Movies: ", theMovie.getTitle());
                        movieList.add(theMovie);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
        return movieList;
    }

}
