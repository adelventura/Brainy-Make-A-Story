package com.example.make_a_story_prototype.main.Home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.Util.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

/**
 * Class for Story Template Selection activities, including redirection to each story screen.
 */

public class StorySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_selection);

        View view = findViewById(R.id.relative_layout);
        View root = view.getRootView();
        root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryLight));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Util.themeStatusBar(this, true);
        Util.addBackArrow(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Story Templates");

    }

    /**
     * goes to the story screen for "The Special Invention"
     * @param v view
     */
    public void SpecialInventionCardOnClick(View v) {
        Toast.makeText(this, "Todo: Special Invention Story", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "The Wacky Costume Party"
     * @param v view
     */
    public void WackyCostumePartyCardOnClick(View v) {
        Toast.makeText(this, "Todo: The Wacky Costume Party", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "Santa's Mixed-up Helper Elf"
     * @param v view
     */
    public void SantasElfCardOnClick(View v) {
        Toast.makeText(this, "Todo: Santa's Mixed-up Helper Elf", Toast.LENGTH_SHORT).show();
    }

    /**
     * goes to the story screen for "The Space Alien"
     * @param v view
     */
    public void SpaceAlienCardOnClick(View v) {
        Toast.makeText(this, "Todo: The Space Alien Story", Toast.LENGTH_SHORT).show();
    }
}
