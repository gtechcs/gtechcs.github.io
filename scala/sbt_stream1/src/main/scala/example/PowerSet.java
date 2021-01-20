
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PowerSet {
	
	public static void main(String[] args) {
		List<String> input = Arrays.asList("1","2","3");
		List<List<String>>  result = powerSet(input);
		printList(result);
		
	}
	
	public static List<List<String>> powerSet (List<String> num) {
		List<List<String>> result = new ArrayList<>();
		powerSetRecurse(num, 0, result, new ArrayList<>());

		return result;
	}

	public static void powerSetRecurse (List<String> num, int index, List<List<String>> result, List<String> intermediate) {
		if(index == num.size()) {
			System.out.println(intermediate.size());
			result.add(intermediate);
			return;
		}
		
		String value = num.get(index);
		//Include
		intermediate.add(value);
		List<String> intermediateC =new ArrayList<>(intermediate);
		powerSetRecurse(num, index+1, result, intermediateC);

		//Do not include
		intermediate.remove(intermediate.size() - 1);
		List<String> intermediateD =new ArrayList<>(intermediate);
		powerSetRecurse(num, index+1, result, intermediateD);
		
	}	

	public static void printList (List<List<String>> result) {
		System.out.println();
		System.out.print("[");
		for(int i =0; i< result.size(); i++) {
			System.out.print("[");
			List<String> r = result.get(i);
			for(int j = 0; j< r.size(); j++) {
				System.out.print(r.get(j));
				if(j != r.size() - 1) {
					System.out.print(",");
				}
			}			
			System.out.print("]");
			System.out.print(",");
		}
		System.out.print("]");

	}	
	
}