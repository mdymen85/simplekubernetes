package com.simpletest.kubernetes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KubernetesApplication {

	public static void main(String[] args) {
	
//		var test = Solution.solution("4 5 6 - 7 +");
//		System.out.println(test);
//		
//		test = Solution.solution("13 DUP 4 POP 5 DUP + DUP + -");
//		System.out.println(test);
		
//		var test = Solution.solution("5 6 + - ");
//		System.out.println(test);
		
		var test = Solution.solution("5 6 + -");
		System.out.println(test);
		
//		test = Solution.solution("022");
//		System.out.println(test);
//		System.out.println("letter " + test);
//		
//		test = Solution.solution("");
//		System.out.println("letter " + test);
//		
//		test = Solution.solution("ab");
//		System.out.println("letter " + test);
		
//		SpringApplication.run(KubernetesApplication.class, args);
	}
	
	
	public static class Solution {
		
		public static int solution(String s) {
			
			String[] stringSplitted = s.split("\\s+");
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int i = 0; i < stringSplitted.length; i++) {
				
				if (stringSplitted[i].equals("POP")) {
					stack.pop();
					continue;
				}
				
				if (stringSplitted[i].equals("DUP")) {
					Integer number = stack.pop();			
					stack.push(number);
					stack.push(number);
					continue;
				}
				
				if (stringSplitted[i].equals("+")) {
					Integer element1 = stack.pop();
					Integer element2 = stack.pop();
					
					Integer sum = element1 + element2;
					
					if (sum > Math.pow(2,20) -1) {
						return -1;
					}
					
					stack.push(sum);
					continue;
				}
				
				if (stringSplitted[i].equals("-")) {
					Integer element1 = stack.pop();
					if (stack.empty()) {
						return -1;
					}
					Integer element2 = stack.pop();
					
					Integer substract = element1 - element2;
					
					if (substract < 0) {
						return -1;
					}
					
					stack.push(substract);
					continue;
				}
				
				stack.push(Integer.parseInt(stringSplitted[i]));
				
			}
			
			
			return stack.pop();
		}
		
//		private static String finalnumber(char[] numbers) {
//			
//			var stringnumber = "";
//			for (int i = 0; i < numbers.length; i++) {
//				stringnumber = stringnumber + numbers[i];
//			}
//			
//			return stringnumber;
//			
//		}
//		
//	    public static int solution(String S) {
//	    	
//	    	Set<String> setNumbers = new HashSet<String>();
//	    	for (int i = 0; i < S.length(); i++) {
//	    		for (int j = 0; j < 10; j++) {
//	    			char[] number = S.toCharArray();
//	    			number[i] = String.valueOf(j).toCharArray()[0];
//	    			var numberfinal = finalnumber(number);	    			
//	    			if (Integer.parseInt(numberfinal) % 3 == 0) {
//	    				System.out.println(numberfinal);
//	    				setNumbers.add(numberfinal);
//	    			}
//	    			
//	    		}
//	    	}
//	    	
//	    	return setNumbers.size();
//	    }
//	        if (S.isEmpty()) {
//	            throw new IllegalStateException();
//	        }
//	    	
//	        int[] occurrences = new int[26];
//	        for (char ch : S.toCharArray()) {
////	        	System.out.println("letra " + ch);
//	            occurrences[ch - 'a']++;
////	            System.out.println(ch - 'a');
//	        }
//
//	        char best_char = 'a';
//	        int  best_res  = 0;
//
//	        for (int i = 25; i >= 0; i--) {
//	            if (occurrences[i] >= best_res) {	 
//	                best_char = (char)((int)'a' + i);
//	                best_res  = occurrences[i];
//	                
//	            }
//	        }
////	        System.out.println(Character.toString(best_char));
//	        
//	        return Character.toString(best_char);
//	    }
	}

}
