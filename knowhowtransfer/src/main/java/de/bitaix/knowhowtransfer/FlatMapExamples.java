package de.bitaix.knowhowtransfer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class FlatMapExamples {

    public void flatMap() {

        List<String> colours1 = Arrays.asList("red", "green");
        List<String> colours2 = Arrays.asList("blue", "grey");

        List<List<String>> coloursOfColours = Arrays.asList(colours1, colours2);

        List<String> flatMapResult = coloursOfColours
            .stream()
            .flatMap(c -> c.stream())
            .collect(Collectors.toList());
        
        System.out.println(flatMapResult);
    }

    public void flatMap_optional() {
        Optional<String> optionalColour = Optional.of("RED");
        Optional<Optional<String>> optOfOpt = Optional.of(optionalColour);

        String col = optOfOpt
                .flatMap(value -> value.map(opt -> opt.toLowerCase()))
                .orElse("blue");
        
        System.out.println(col);
    }

}
