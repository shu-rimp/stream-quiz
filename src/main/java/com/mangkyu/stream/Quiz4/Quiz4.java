package com.mangkyu.stream.Quiz4;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        init();
    } // comparator

    private void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    } // init

    public List<Transaction> quiz1() {
        return transactions.stream()
        		.filter(t -> t.getYear() == 2020)
        		.sorted((o1, o2) -> o1.getValue() - o2.getValue())
        		.collect(Collectors.toList());
    } // quiz1

    public List<String> quiz2() {
        return transactions.stream()
        		.map(t -> t.getTrader().getCity())
        		.distinct()
        		.collect(Collectors.toList());
    } // quiz2

    public List<Trader> quiz3() {
        return transactions.stream()
        		.map(t -> t.getTrader())
        		.distinct()
        		.filter(t -> t.getCity().equals("Seoul"))
        		.sorted(Comparator.comparing(Trader::getName))
        		.collect(Collectors.toList());
    } // quiz3

    public String quiz4() {
        return transactions.stream()
        		.map(t -> t.getTrader().getName())
        		.distinct()
        		.sorted()
        		.collect(Collectors.joining(","));
    } // quiz4

    public boolean quiz5() {
        return transactions.stream()
        		.map(t -> t.getTrader().getCity())
        		.anyMatch(t -> t.equals("Busan"));
    } // quiz5

    public List<Integer> quiz6() {
        return transactions.stream()
        		.filter(t -> t.getTrader().getCity().equals("Seoul"))
        		.map(Transaction::getValue)
        		.collect(Collectors.toList());
    } // quiz6

    public Integer[] quiz7() {
    	
    	Integer[] arr = new Integer[2];
    	
    	arr[0] = transactions.stream()
    			.map(Transaction::getValue)
    			.reduce(0, Integer::max);
    	
    	arr[1] = transactions.stream()
    			.min(Comparator.comparing(Transaction::getValue))
    			.orElseThrow(NoSuchElementException::new).getValue();
    	
        return arr;
    } // quiz7

} // end class
