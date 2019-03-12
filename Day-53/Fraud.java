import java.util.*;

public class Fraud{
    static int[] arr;
    static int[] freq;

    public static void UpdateFrequence(int start, int end, int prev){
        if(prev == -1){
            for(int i=start; i<=end; i++)
                freq[arr[i]]++;
        }
        else{
            freq[prev]--;
            freq[arr[end]]++;
        }
    }

    public static double FindMedianEven(int a){
        int count = 0;
        int index = 0;
        int i=0;
        while(count <= a){
            index = i;
            count += freq[i++];
        }
        return (index+(index+1))/2.0;
    }

    public static double FindMedianOdd(int a){
        int count = 0;
        int index = 0;
        int i=0;
        while(count < a){
            index = i;
            count += freq[i++];
        }
        return (double) index;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();
        arr = new int[n];
        freq = new int[201];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int count = 0;
        int prev = -1;
        int start = 0;
        int end = d-1;
        int current = d;
        if(d%2 == 0){
            int a = d/2;
            while(current != n){
                UpdateFrequence(start, end, (prev == -1 ? -1 : arr[prev]));
                double med = FindMedianEven(a);
                if(arr[current] >= (2*med))
                    count++;
                current++;
                prev = start;
                start++;
                end++;
            }
        }
        else{
                int a = (d/2)+1;
           while(current != n){
                UpdateFrequence(start, end, (prev == -1 ? -1 : arr[prev]));
                double med = FindMedianOdd(a);
                if((double) arr[current] >= (2*med))
                    count++;
                current++;
                prev = start;
                start++;
                end++;
            } 
        }
        System.out.println(count);
    }
}