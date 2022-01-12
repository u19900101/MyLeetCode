package class02;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
	/*
	堆排序扩展题目
	已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
	素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的
	排序算法针对这个数据进行排序。
	* */
	public void sortedArrDistanceLessK(int[] arr, int k) {
		//小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int index = 0;
		for (; index < Math.min(arr.length, k); index++) {
			heap.add(arr[index]);
		}
		int i = 0;
		for (; index < arr.length; i++, index++) {
			heap.add(arr[index]);
			arr[i] = heap.poll();
		}
		while (!heap.isEmpty()) {
			arr[i++] = heap.poll();
		}
	}

	@Test
	public void T_(){
		//自定义比较器为大根堆
		// PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new ACom());
		//不加比较器为小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(10);
		heap.add(13);
		heap.add(4);
		heap.add(1);
		heap.add(9);
		heap.add(25);
		while (!heap.isEmpty()) {
			System.out.println(heap.poll());
		}
	}
}

class ACom implements Comparator<Integer> {


	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}
