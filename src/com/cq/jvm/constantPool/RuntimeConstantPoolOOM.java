/**
 * Taylor Chan's works for practice
 */
package com.cq.jvm.constantPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taylor
 * @date 2013-3-2
 * @version 1.0
 *
 */
public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		int i = 0;
		while(true){
			ls.add(String.valueOf(i++).intern());
		}
	}
}
