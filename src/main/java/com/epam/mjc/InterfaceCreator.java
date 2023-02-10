package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s : list) {
                if (!(s.length() > 0))
                    return false;
                char c = s.charAt(0);
                if (!(c >= 'A' && c <= 'Z'))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> addList = new ArrayList<>();
            for (Integer item : list) {
                if (item % 2 == 0)
                    addList.add(item);
            }
            list.addAll(addList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values
                .stream()
                .filter(s -> isValuesStartWithUpperCase().test(List.of(s)))
                .filter(s -> s.endsWith("."))
                .filter(s -> s.split("\\s").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            HashMap<String, Integer> map = new HashMap<>();
            list.forEach(s -> map.put(s, s.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            integers.addAll(integers2);
            return integers;
        };

    }
}
