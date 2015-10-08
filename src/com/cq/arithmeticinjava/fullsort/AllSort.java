package com.cq.arithmeticinjava.fullsort;

public class AllSort {
	
	public static void main(String[] args) {
		char[] array = new char[]{'a','b','c'};
		sort(array,0,array.length -1);
	}

	public static void sort(char[] c, int begin, int end) {
		if (begin == end) {// 如果begin等于end说明，数组中的元素交换完毕，可以进行打印输出
			for (int i = 0; i <= end; i++) {// 循环数组，进行输出操作
				System.out.print(c[i]);
			}
			System.out.println();// 换行控制符
		} else {// 如果元素还没有交换完毕，继续进行递归
			for (int i = begin; i <= end; i++) {
				char temp = c[begin];// 将首元素与其后的第i个元素进行交换
				c[begin] = c[i];
				c[i] = temp;
				// 递归循环调用
				sort(c, begin + 1, end);
				// 还原数组
				c[i] = c[begin];
				c[begin] = temp;
			}
		}
	}

}
