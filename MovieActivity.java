package jw.dramatifycinema;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MovieActivity extends AppCompatActivity {

    TextView movieTitle, moviePrice, levelOfDrama;
    CheckBox checkboxWatched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieTitle = findViewById(R.id.movieTitle);
        moviePrice = findViewById(R.id.moviePrice);
        levelOfDrama = findViewById(R.id.levelOfDrama);
        checkboxWatched = findViewById(R.id.checkBoxWatched);

        // Get data from Intent
        String title = getIntent().getStringExtra("title");
        double price = getIntent().getDoubleExtra("price", 0);
        int dramaRating = getIntent().getIntExtra("dramaRating", 0);
        boolean watched = getIntent().getBooleanExtra("watched", false);

        // Display movie info
        movieTitle.setText(title);
        moviePrice.setText("Price: $" + price);
        levelOfDrama.setText("Drama: " + "★".repeat(dramaRating));
        checkboxWatched.setChecked(watched);

        // Optional: update watched status if you implement persistence
        checkboxWatched.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
            // Save change to SharedPreferences or Room DB
        });
    }
}
