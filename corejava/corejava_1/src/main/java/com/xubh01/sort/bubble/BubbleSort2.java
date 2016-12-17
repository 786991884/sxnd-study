package com.xubh01.sort.bubble;

import java.util.Arrays;

public class BubbleSort2 {

	public static void main(String[] args) {
		int[] arr ={9,8,7,6,5};
		sort(arr);
	}
	//第二版本，减少每一趟的次数
	public static void sort(int[] arr){
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //趟数
			System.out.println("第"+(j+1)+"趟");
			for(int i=0;i<len-1-j;i++){ //次数
				System.out.print("第"+(i+1)+"次");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}

}
