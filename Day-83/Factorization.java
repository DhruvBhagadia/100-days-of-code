public class Solution {
    public int isPrime(int A) {
        if(A == 1)
            return 0;
        for(int i=2; i<=Math.sqrt(A); i++)
            if(A%i == 0)
                return 0;
        return 1;
    }

    public ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=2; i<=A; i++)
            if(isPrime(i))
                a.add(i);
        Collections.sort(a);
        return a;
    }

    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for(int i=1; i<=Math.sqrt(A); i++){
            if(A%i == 0){
                arrlist.add(i);
                if(i < Math.sqrt(A))
                    arrlist.add(A/i);
            }
        }
        Collections.sort(arrlist);
        return arrlist;
    }
}