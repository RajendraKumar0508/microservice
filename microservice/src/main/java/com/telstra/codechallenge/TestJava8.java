package com.telstra.codechallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//list of number 3,2,2,4,9,1,0,9,4 //find unique qure.
		
		Integer a[]= new Integer[] {3,2,2,4,9,1,0,9,4};
		List<Integer>  list= Arrays.asList(a);
		
		List<Integer>  uniqueSqure=list.stream().map(x -> x*x).distinct().collect(Collectors.toList());
		
		System.out.println (uniqueSqure);
		
		
		uniqueSqure.forEach(x -> System.out.println (x));
		
		
		
		
		
		
		
	}

}

//9,4,16,81,1,0}