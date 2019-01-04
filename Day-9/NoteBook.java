import java.util.Scanner;
public class NoteBook {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int cas = 1; cas <= T; cas++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            int n = sc.nextInt();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                if (p >= x - y && c <= k) {
                    flag = true;
                }
            }
            System.out.println(flag ? "LuckyChef" : "UnluckyChef");
        }
    }
}