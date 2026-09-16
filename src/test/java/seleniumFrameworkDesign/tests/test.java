package seleniumFrameworkDesign.tests;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="nissiebenezer";
		Map<Character,Integer> hm=new HashMap<>();
		for(Character ch:name.toCharArray()) {
			hm.put(ch, hm.getOrDefault(ch, 0)+1);
		}
		System.out.println(hm.entrySet());

	}

}
