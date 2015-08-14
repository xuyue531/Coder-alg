package com.coder.alg.sort;

import java.util.Comparator;

import com.coder.common.StdOut;

public abstract class BaseSort {

	protected static void exch(Comparable[] a, int j, int i) {
		Comparable tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;
	}
	
	protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

	protected static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	protected static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	protected static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	protected static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	protected static boolean isSorted(Object[] a, Comparator comparator) {
		return isSorted(a, 0, a.length - 1, comparator);
	}

	// is the array sorted from a[lo] to a[hi]
	protected static boolean isSorted(Object[] a, int lo, int hi,
			Comparator comparator) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1], comparator))
				return false;
		return true;
	}
	
	protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }


}
