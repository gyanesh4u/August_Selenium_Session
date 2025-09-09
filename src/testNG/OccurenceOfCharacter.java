package testNG;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfCharacter {

	public static void main(String[] args) {
		
		String s="hello world";
		char[] ch = s.toCharArray();
		//String[] str = s.split(" ");
		
		Map<Character,Integer> map=new HashMap<Character, Integer>();
		
		for(char c:ch) {
			//if(!String.valueOf(c).isBlank())
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
			
		}
		System.out.println(map);
	
	}
}
