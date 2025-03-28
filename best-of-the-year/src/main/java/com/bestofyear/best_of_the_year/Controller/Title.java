package com.bestofyear.best_of_the_year.Controller;

import com.bestofyear.best_of_the_year.entities.Movie;
import com.bestofyear.best_of_the_year.entities.Songs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Title {
    @GetMapping("/title")
    public String titolo(@RequestParam(name = "titolo") String titolo,
                           Model model) {
        model.addAttribute("titolo", titolo);
        return "title";
    }

    //Migliori Film
    private static List<Movie> getBestMovies() {
        List<Movie> film = new ArrayList<>();
        film.add(new Movie(2,"film1"));
        film.add(new Movie(6,"film2"));
        film.add(new Movie(8,"film3"));
        return film;
    }

    @GetMapping("/movies")
    public String bestMovies(Model model) {
        List<Movie> films = getBestMovies();
        model.addAttribute("film", films);
        return "movie";
    }

    //Migliori Canzoni
    private static List<Songs> getBestSongs() {
        List<Songs> song = new ArrayList<>();
        song.add(new Songs(8,"canzone1"));
        song.add(new Songs(6,"canzone2"));
        song.add(new Songs(2,"canzone3"));
        return song;
    }

    @GetMapping("/songs")
    public String bestSongs(Model model) {
        List<Songs> songs = getBestSongs();
        model.addAttribute("song", songs);
        return "song";
    }

    //Ricerco per id
    @GetMapping("/movies/{id}")
    public String MovieID(@PathVariable("id") int id, Model model){
        List<Movie> films = getBestMovies();
        Movie trovato = null;
        for (Movie f : films){
            if (f.getId() == id){
                model.addAttribute("film", f);
                trovato = f;
                break;
            }
        }
        return "searchID";
    }
}
