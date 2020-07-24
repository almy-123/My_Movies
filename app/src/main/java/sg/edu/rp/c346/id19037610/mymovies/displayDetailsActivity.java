package sg.edu.rp.c346.id19037610.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class displayDetailsActivity extends AppCompatActivity {

    TextView title, year,genre, watchDate, theatre, description;
    ImageView rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        title = findViewById(R.id.textViewName);
        year = findViewById(R.id.textViewYear);
        rating = findViewById(R.id.imageViewRating);
        genre = findViewById(R.id.textViewGenre);
        watchDate = findViewById(R.id.textViewWatchDate);
        theatre = findViewById(R.id.textViewTheatre);
        description = findViewById(R.id.textViewDescription);

        Intent i = getIntent();
        String t = i.getStringExtra("title");
        String y = i.getStringExtra("year");
        String r = i.getStringExtra("rating");
        String g = i.getStringExtra("genre");
        String d = i.getStringExtra("description");
    }
}
