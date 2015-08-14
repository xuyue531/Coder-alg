package com.coder.alg.sort.Shell;

import com.coder.alg.sort.BaseSort;

public class Shell extends BaseSort {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		//选择步长
		while (h < N/3) {
			h = 3*h + 1;
		}
		while (h > 0) {
			//从h位置开始逐个调整元素位置，每个元素只与自己组内的元素做比较，即以步长h选择要比较的元素
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			h = h/3;
		}
		assert isSorted(a);
	}
	
	public static void main(String[] args) {
		Integer[] a = {1, 3, 7, 2, 4, 6, 5};
		Shell.sort(a);
	}
	
}
