import java.io.*;
import java.util.*;
class Help 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] arr = new int[n][6];
            for(int i=0; i<n; i++){
                arr[i][0] = sc.nextInt(); //x1
                arr[i][1] = sc.nextInt(); //y1
                arr[i][2] = sc.nextInt(); //x2
                arr[i][3] = sc.nextInt(); //y2
                arr[i][4] = sc.nextInt(); //x3
                arr[i][5] = sc.nextInt(); //y3
            }
            int min_index = 0;
            int max_index = 0;
            double min = Math.abs(0.5*(((arr[0][0]-arr[0][4])*(arr[0][3]-arr[0][1]))-((arr[0][0]-arr[0][2])*(arr[0][5]-arr[0][3])))); 
            double max = Math.abs(0.5*(((arr[0][0]-arr[0][4])*(arr[0][3]-arr[0][1]))-((arr[0][0]-arr[0][2])*(arr[0][5]-arr[0][3]))));
            for(int i=1; i<n; i++){
                double area = Math.abs(0.5*(((arr[i][0]-arr[i][4])*(arr[i][3]-arr[i][1]))-((arr[i][0]-arr[i][2])*(arr[i][5]-arr[i][3]))));
                if(area > max){
                    max = area;
                    max_index = i;
                }
                else if(area < min){
                    min = area;
                    min_index = i;
                }
            }
            min_index++;
            max_index++;
            System.out.println(min_index + " " + max_index);
        }
    }
}
