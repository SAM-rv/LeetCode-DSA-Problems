import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> result = new ArrayList<>();
        if (s < 2 || n < 2) return result;

        boolean[] primes = new boolean[n+1];
        java.util.Arrays.fill(primes,true);
        primes[0]=false;
        primes[1]=false;
        int limit=(int)Math.sqrt(n);
        for (int i =2;i<=limit;i++) {
            if(primes[i]){
                for(int j=i*i;j<=n;j+=i)
                primes[j]=false;
            }
        }

        int totalSum = 0;
        for (int i=0;i<n+1;i++) {
            if(primes[i]){
            totalSum += i;
            if (totalSum <= s) {
                result.add(i);
            } else {
                break;
            }
            }
        }
        return result;
    }
}
