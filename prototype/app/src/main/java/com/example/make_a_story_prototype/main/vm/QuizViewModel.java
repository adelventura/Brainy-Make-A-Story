package com.example.make_a_story_prototype.main.vm;

import com.example.make_a_story_prototype.main.model.QuizOptions;


import java.util.Random;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class QuizViewModel {

    public interface Callback {
        void onComplete();
    }

    public Callback callback;

    private BehaviorSubject<String[]> options = BehaviorSubject.create();
    private BehaviorSubject<Integer> correctAnswersCount = BehaviorSubject.createDefault(0);

    private int correctOptionIndex;

    public QuizViewModel() {
        shuffle();
    }

    private void shuffle() {
        String[] nextOptions = new String[4];
        String[] availableIncorrectOptions = QuizOptions.getIncorrectOptions();

        Random random = new Random();

        // get random index of answer option
        int incorrectStartIndex = random.nextInt(availableIncorrectOptions.length);
        for (int i = 0; i < 4; i++) {
            String incorrectOption = availableIncorrectOptions[
                    (incorrectStartIndex + i) % availableIncorrectOptions.length
                    ];

            nextOptions[i] = incorrectOption;
        }

        // fill the correct option in a random index
        correctOptionIndex = random.nextInt(4);
        nextOptions[correctOptionIndex] = QuizOptions.getCorrectOption();

        options.onNext(nextOptions);
    }

    // Obervables

    public Observable<String[]> getOptions() {
        return options;
    }

    public Observable<Integer> getCorrectAnswerCount() {
        return correctAnswersCount;
    }

    // Actions

    public void onSelectedAnswer(int option) {
        if (option == correctOptionIndex) {
            onCorrectAnswer();
        } else {
            onIncorrectAnswer();
        }

        shuffle();
    }

    // Utils

    private void onCorrectAnswer() {
        correctAnswersCount.onNext(correctAnswersCount.getValue() + 1);

        if (correctAnswersCount.getValue() == 3) {
            callback.onComplete();
        }
    }

    private void onIncorrectAnswer() {
        correctAnswersCount.onNext(0);
    }


}