package pl.sda.Lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        AddInterface add = (a, b) -> a + b;
        add.calc(4,2);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

        for(Integer number : numbers){
            System.out.println(number);
        }


        numbers.forEach(n -> System.out.println(n));

        numbers.forEach(System.out::println);

        List<Movie> movies = Arrays.asList(
                new Movie("Tytul", "Jan", LocalDate.of(2012, 02,12),
                        60, Arrays.asList("Michal", "Maciek")),
                new Movie("Tytul2", "Jan", LocalDate.of(2012, 02,12),
                        20, Arrays.asList("Michal", "Maciek"))
        );


        List<String> titles = movies
                .stream()
                .map(f -> f.getTitle())
                .collect(Collectors.toList());

        List<String> directors = movies
                .stream()
                .map(f -> f.getDirector())
                .collect(Collectors.toList());

        System.out.println(titles);
        System.out.println(directors);

        Consumer<String> stringConsumer = n -> System.out.println(n);
        directors.forEach(stringConsumer);

        List<Movie> movieList = movies.stream()
                .filter(f -> f.getPrice() > 50)
                .filter(f -> f.getTitle().length() > 5)
                .collect(Collectors.toList());

        System.out.println(movieList);

        List<String> titles2 = movies
                .stream()
                .filter(f -> f.getPrice() > 10 & f.getPrice() < 30)
                .map(f -> f.getTitle())
                .collect(Collectors.toList());

        System.out.println("******");
        titles2.forEach(System.out::println);

    }
}
