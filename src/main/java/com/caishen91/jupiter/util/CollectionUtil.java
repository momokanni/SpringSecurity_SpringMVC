package com.caishen91.jupiter.util;

import java.util.*;

public class CollectionUtil {
	
	
	public static void putElement(Map map, Object key, Object value) {
		List lst = (List)map.get(key);
		if (lst == null) {
			lst = new ArrayList();
			map.put(key, lst);
		}
		lst.add(value);
	}
	
	public static void putElement2(Map map, Object key, Object value) {
		Set lst = (Set)map.get(key);
		if (lst == null) {
			lst = new HashSet();
			map.put(key, lst);
		}
		lst.add(value);
	}
	
	public static void putElement3(Map map, Object key, Object value, Comparator comparator) {
		Set lst = (Set)map.get(key);
		if (lst == null) {
			lst = new TreeSet(comparator);
			map.put(key, lst);
		}
		lst.add(value);
	}
}

