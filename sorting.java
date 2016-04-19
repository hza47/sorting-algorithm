package test;

import java.util.Arrays;

public class sorting {
	 private static int N ;
	public static void quickSort(int[] input, int left ,int right){
		if(input.length==0 || input==null){
			return;
		}
		if(left>=right){
			return;
		}
		int pivot = input[(left+right)/2];
		int i = left;
		int j = right;
		while(i<= j){
			while(input[i]<pivot)
				i++;
			while(input[j]>pivot){
				j--;
			}		
			if(i<=j){
				int temp = input[i];
				input[i] = input[j];
				input[j]=temp;
				i++;
				j--;
			}			
		}
		quickSort(input, left, j);
		quickSort(input, i,right);
		
	}
	public static void heapsort(int[] arr){
		heapify(arr);
		for(int a =N; a>=0;a--){
			swap(arr, a, 0);
			N = N-1;
			maxHeap(arr, 0);
			
		}
	}
	public static void heapify(int[] arr){
		 N = arr.length-1;
	        for (int i = N/2; i >= 0; i--)
	            maxHeap(arr, i);    
	} 
	
	public static void maxHeap(int[] arr, int i){
        int left = 2*i ;  
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxHeap(arr, max);
        }
		
	}
	public static void swap(int[] arr, int first, int second){
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	} 
	public static void mergeSort(int[] arr){
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
	}
	public static void mergeSort(int[] arr, int[] helper, int low, int high){
		if(low<high){
			int middle = (low+high)/2;
			mergeSort(arr, helper, low, middle);
			mergeSort(arr,helper, middle+1, high);
			Join(arr, helper, middle, low, high);
		}
		
	}
	public static void Join(int[] arr, int[] helper, int middle, int low, int high){
		for(int a = low; a<=high;a++){
			helper[a] = arr[a];
		}
		int left = low;
		int right = middle+1;
		int index = low;
		while(left<=middle && right <=high){
			if(helper[left]>helper[right]){
				arr[index] = helper[right];
				right++;
			}
			else{
				arr[index] = helper[left];
				left++;
			}
			index++;
		}
		for(int a = 0; a<= middle-left;a++){
				arr[index+a] = helper[left+a];
		}
		
	}
	public static int magic(int[] arr){
		return magic(arr, 0, arr.length);
	}
	public static int magic(int[] arr, int left, int right){
		int middle = (left+right)/2;
		int result =-1;
		if(left>=right){
			return -1;
		}
		if(arr[middle]==middle){
			return middle;
		}
		if(arr[middle]<middle)
			result= magic(arr, middle+1, right);
		else{
			result= magic(arr, left, middle);
		}
		return result;
		
	}
	
	public static int magic2(int[] arr, int left, int right){
		int middle = (left+right)/2;
		if(left>=right){
			return -1;
		}
		if(arr[middle]==middle){
			return middle;
		}
		if(arr[middle]>middle){
		//	System.out.println("middle is : "+ middle);
		//	System.out.println("left is : "+ left);
			int result1 =magic2(arr, left, middle);
			if(result1>=0){
				return result1;
			}
			int result2 = magic2(arr, arr[middle], right);
			return result2;
		}
		else{
			int result1 =magic2(arr, middle+1, right);
			if(result1>=0){
				return result1;
			}
			int result2 = magic2(arr, left, arr[middle]);
			return result2;
		}
	}
	public static void main(String[] args){
		int [] test = {4,5,2,7,3,0};
		int [] tes2=  {-5,0,2,10,15};
		int[] test3 = {-10,-5,1,2,2,3,4,7,9,12,13};
		//quickSort(test, 0, test.le  ngth-1);
	//	mergeSort(test);
//		for (int i = 0; i < test.length; i++)
//            System.out.print(test[i]+" ");  
//		System.out.println("fjdjf");
		System.out.println(magic2(test3, 0, test3.length));
		
		
	}
	

}
