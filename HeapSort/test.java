package Test;
import java.util.Arrays;
import java.util.Comparator;

public class test {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  
        a[idx1] = a[idx2];  
        a[idx2] = t;
    }

    //--- a[left]～a[right]를 힙으로 만들기 ---//
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];        // 뿌리
        int child;                 // 큰 쪽의 자식
        int parent;                // 부모

        //부모에서 자식으로 내려가면서 정렬
        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;        // 왼쪽의 자식
            int cr = cl + 1;                // 오른쪽의 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;    // 큰 쪽
            
            //부모가 크다면 멈춤
            if (temp >= a[child])
                break;
            
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    //--- 힙 정렬 ---//
    static void heapSort(int[] a, int n) {
    	
    	// n은 배열의 크기, n-1은 마지막 인덱스를 가리키고있고 자식이 없다(정렬 할 필요가 없다) 
    	// (n-1)/2은 n-1의 부모노드이다
    	// 그러므로 (n-1)/2 부터 정렬을 시작하는것이 효율적이다
    	
    	//힙 생성
        for (int i = (n - 1) / 2; i >= 0; i--)    // a[i]~a[n-1]를 힙으로 만듦
            downHeap(a, i, n - 1);

        // 힙을 만들었다면 첫번쨰 요소가 가장 큰 값이 된다
        // 첫번째 요소와 마지막 요소를 교환하여  배열의 뒷쪽에 가장 큰 값이 들어가게 된다
        // 정렬을 한 요소를(큰값) 제외하고 다시 힙을 생성하여 그중에 가장 큰 값을 찾는다
        // 이 과정을 반복하여 큰 값들이 배열의 뒷쪽부터 정렬되어 정렬이 완성된다
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);                       // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1);               // a[0] ~ a[i-1]을 힙으로 만듦
        }
        
    }

    public static void main(String[] args) {
        
        int[] x = {3,8,2,4,7,5,6,1,9};


        heapSort(x, x.length);    // 배열 x를 힙정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}













