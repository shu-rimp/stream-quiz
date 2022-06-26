package com.mangkyu.stream.Quiz1;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

public class Quiz1 {

    public Map<String, Integer> quiz1() throws Exception {
    	List<String[]> user = readCsvLines();
    	
        return user.stream()
        		.map(t -> t[1].replace(" ", ""))
        		.flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
        		// toMap(KeyMapper, ValueMapper, mergeFunction)
        		.collect(Collectors.toMap(key -> key, val -> 1, (oldVal, newVal) -> newVal += oldVal));
    } // quiz1

    public Map<String, Integer> quiz2() throws Exception {
    	List<String[]> user = readCsvLines();
    	
        return user.stream()
        		.filter(name -> name[0].substring(0, 1).equals("정"))
//        		.filter(name -> name[0].startsWith("정")) 예시답안
        		.map(t -> t[1].replace(" ", ""))
        		.flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
        		.collect(Collectors.toMap(key -> key, val -> 1, (oldVal, newVal) -> ++newVal));
    } // quiz2

    public int quiz3() throws Exception {
    	List<String[]> user = readCsvLines();
    	
        return user.stream()
        		.map(line -> countLike(line[2], "좋아", 0))
        		.reduce(0, Integer::sum);
    } // quiz3

    private List<String[]> readCsvLines() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        
        return csvReader.readAll();
    } // readCsvLines
    
    private int countLike(String str, String target, int index) {
    	int idx = str.indexOf(target, index);
    	if(idx >= 1) {
    		return 1 + countLike(str, target, idx + target.length());
    	}
    	
    	return 0;
    } // countLike

}
