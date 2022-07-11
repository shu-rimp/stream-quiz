package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
    	
    	return Arrays.stream(STRING_ARR)
    		.map(t -> t.length())
    		.reduce(0, Integer::sum);
    } // quiz1

    public int quiz2() {
        
    	return Arrays.stream(STRING_ARR)
    			.mapToInt(String::length)
    			.max()
    			.orElse(-1);
    } // quiz2

    public List<Integer> quiz3() {
    	
    	return new Random().ints(1, 46)
    			.distinct()
    			.limit(6)
    			.boxed()
    			.sorted()
    			.collect(Collectors.toList());
    } // quiz3

    public List<Integer[]> quiz4() {
        return Collections.emptyList();
    } // quiz4

} // end class
