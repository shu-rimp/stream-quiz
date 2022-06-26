package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {
    	
        return WORDS.stream()
        		.map(t -> t.substring(0, 1))
        		.collect(Collectors.toMap(key -> key, val -> 1, (ov, nv) -> ++nv));
    } // quiz1

    public String quiz2() {
    	
        return WORDS.stream()
        		.filter(t -> t.length() >= 2)
        		.map(t -> t.substring(0, 1).toUpperCase())
        		.collect(Collectors.joining(" "));
    } // quiz2

}
