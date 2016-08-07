/**
 * Date Aug 7, 2016 1:22:51 PM
 * Author: Mohamed265
 */
package com.smacrs.timemanagment.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smacrs.timemanagment.core.entities.lut.BaseLut;

/**
 * @author Mohamed265
 */
public class Utils {

	public static <T, K> ArrayList<T> convertLutMapToLutList(HashMap<K, T> map) {
		ArrayList<T> list = new ArrayList<>();
		for (K key : map.keySet())
			list.add(map.get(key));
		return list;
	}

	public static <K> HashMap<Integer, K> convertLutListToLutMap(List<K> list) {
		HashMap<Integer, K> map = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			map.put(((BaseLut) list.get(i)).getId(), list.get(i));
		}
		return map;
	}

}
