package sg.edu.rp.c346.id19037610.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovies);
        alMovieList = new ArrayList<>();
        Calendar m1 = Calendar.getInstance();
        m1.set(2014,11,15);
        String m1Desc = "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes " +
                "to save the planet from Loki and his army.";
        Movie movie1 = new Movie("The Avengers", 2012, "pg13",
                "Action | Sci-Fi", m1,"Golden Village - Bishan", m1Desc);
        alMovieList.add(movie1);

        Calendar m2 = Calendar.getInstance();
        m2.set(2015,5,15);
        String m2Desc = "A crop-dusting plane with a fear of heights lives " +
                "his dream of competing in a famous around-the-world aerial race.";
        Movie movie2 = new Movie("Planes", 2013, "pg", "Animation | Comedy",
                m2, "Cathay - AMK Hub", m2Desc);
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this,R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDetail = new Intent(MainActivity.this, displayDetailsActivity.class);

                Movie currentMovie = alMovieList.get(position);
                intentDetail.putExtra("title", currentMovie.getTitle());
                intentDetail.putExtra("year", currentMovie.getYear());
                intentDetail.putExtra("rating", currentMovie.getRated());
                intentDetail.putExtra("genre", currentMovie.getGenre());
                intentDetail.putExtra("watchedOn", currentMovie.getWatched_on());
                intentDetail.putExtra("theatre", currentMovie.getIn_theatre());
                intentDetail.putExtra("description", currentMovie.getDescription());
                startActivity(intentDetail);
            }
        });




    }
}
