package org.andrei;

import java.util.HashMap;
import java.util.Map;

public class Maps {
	public static void main(String[] args) {
		
		//Map<String,String> comida=new HashMap<String,String>();
		
		Map<String,String> comida= Map.ofEntries(
				Map.entry("pepe","fabada"),
				Map.entry("juan", "lenguado")
				);
		/*
		 * comida.put("pepe","fabada");
		 * comida.put("juan", "lenguado");
		 */
		System.out.println(comida.get("pepe"));
		System.out.println(comida.get("juan"));
		
		for(String c: comida.values()) {
			System.out.println(c);
		}
		for(String k: comida.keySet()) {
			System.out.println("("+k+")"+comida.get(k));
		}
	}
}

