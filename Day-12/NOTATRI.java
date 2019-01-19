import java.util.Arrays;
import java.util.Scanner;

class NOTATRI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(), arr[] = new int[n], first = 0, second = n - 1, third;
            if (n == 0)
                break;
            long ans = 0;
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for (third = n - 1; third > 1; third--) {
                first = 0;
                second = third - 1;
                while (second > first) {
                    if (arr[first] + arr[second] < arr[third]) {
                        ans += second - first;
                        first++;
                    } else {
                        second--;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}