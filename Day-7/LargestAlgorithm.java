// Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long max = 0;
        int length = h.length;;
        int current, element, left, right, countr, countl, count;
        for(int i=0; i<h.length; i++){
            current = i;
            element = h[current];
            left = current-1;
            right = current+1;
            countr = 0;
            countl = 0;
            count = 1;
            while((right < length) && (h[right] >= element)){
                countr++;
                right++;
            }
            while((left >= 0) && (h[left] >= element)){
                countl++;
                left--;
            }
            count += countl + countr;
            if(element*count > max){
                max = element*count;
            }
        }
        return max;
    }