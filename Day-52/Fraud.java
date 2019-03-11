import java.util.*;

public class Fraud{

	public static int partition(double a[], int beg, int end) { 
        int left, right, loc, flag;
        double temp;
        Random r = new Random();
        loc = (int) r.nextInt((end - beg) + 1) + beg;
        double t = a[loc];
        a[loc] = a[beg];
        a[beg] = t;
        loc = left = beg;
        right = end;
        flag = 0;
        while(flag != 1){
            while((a[loc] <= a[right]) && (loc!=right))
                right--;
            if(loc==right)
                flag =1;
            else if(a[loc]>a[right]){
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if(flag!=1){            
                while((a[loc] >= a[left]) && (loc!=left))            
                left++;
                if(loc==left)            
                    flag =1;
                else if(a[loc] <a[left]){
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }

	public static void quick_sort(double a[], int beg, int end, int req) { 
        int loc;
        if(beg<end){
            loc = partition(a, beg, end);
            if(loc >= req)
                quick_sort(a, beg, loc-1, req);
            else{
                quick_sort(a, beg, loc-1, req);
                quick_sort(a, loc+1, end, req);
            }
        } 
    }

	public static double median(double[] arr){
        quick_sort(arr, 0, arr.length-1, (arr.length/2));
        // System.out.println(Arrays.toString(arr));
        if(arr.length%2 == 0){
            int index = arr.length/2;
            // System.out.println(arr[index]);
            // System.out.println(arr[index-1]);
            return (arr[index]+arr[index-1])/2.0;
        }
        else
            return arr[arr.length/2];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();
        double[] arr = new double[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextDouble();
        int count = 0;
        for(int i=d; i<n; i++){
            double[] temp = Arrays.copyOfRange(arr, i-d, i);
            double med = median(temp);
            // System.out.println(med);
            if(arr[i] >= (2*med))
                count++;
        }
        System.out.println(count);
    }
}