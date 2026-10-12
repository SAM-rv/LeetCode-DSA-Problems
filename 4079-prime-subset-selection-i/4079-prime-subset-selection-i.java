class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> result=new ArrayList<>();
        if(s<2 || n<2)
        return result;
        
        result.add(2);
        int totalSum=2;
        for(int i=3;i<=n;i+=2){
            if(isPrime(i)){
                totalSum+=i;
                if(totalSum<=s)
                    result.add(i);
                else
                break;
            }
        }
        return result;
    }
    public boolean isPrime(int n){
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
            return false;
        }
        return true;
    }
}