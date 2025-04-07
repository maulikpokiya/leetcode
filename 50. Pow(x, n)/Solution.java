class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if(n < 0) {
            n = n * -1;
            x = 1.0 / x;
        }
        double res = 1;

        while(n != 0) {
            if(n % 2 == 1) {
                res = res * x;
                n--;
            }

            x = x * x;
            n = n / 2;
        }
        return res;
    }
}
