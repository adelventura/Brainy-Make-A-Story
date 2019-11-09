package com.example.make_a_story_prototype.main.vm;

import com.example.make_a_story_prototype.main.model.CategoryCardItem;
import com.example.make_a_story_prototype.main.model.WordCardItem;

public class WordCardItemViewModel {
    public WordCardItem cardItem;

    public int backgroundColor;
    public int contrastColor;
    public boolean isUnlocked;

    public WordCardItemViewModel(WordCardItem cardItem, int backgroundColor, int contrastColor, boolean isUnlocked) {
        this.cardItem = cardItem;
        this.backgroundColor = backgroundColor;
        this.contrastColor = contrastColor;
        this.isUnlocked = isUnlocked;
    }
}
