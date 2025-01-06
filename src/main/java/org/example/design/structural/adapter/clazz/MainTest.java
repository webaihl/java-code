package org.example.design.structural.adapter.clazz;

import org.example.design.structural.adapter.MoviePlayer;

public class MainTest {

    public static void main(String[] args) {

        MoviePlayer player = new MoviePlayer();
//        JPMoviePlayerAdapter adapter = new JPMoviePlayerAdapter(player);
//
//
//        adapter.play();
        player.play();

    }
}
