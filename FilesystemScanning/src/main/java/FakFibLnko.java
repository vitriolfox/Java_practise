public class FakFibLnko {

    public static long faktorialis(long szam){
        int eredmeny = 1;

        for(int i=1; i<=szam; i++) {
            eredmeny = eredmeny * i;
        }
        return eredmeny;
    }


    public static long fibonacci2(long n)  {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fibonacci2(n - 1) + fibonacci2(n - 2);
        }
    }

    public static int fibonacciArray(int n){
        Integer[] fibonacciTomb = new Integer[n+1];
        fibonacciTomb[0] = 0;
        fibonacciTomb[1] = 1;
        for (int i=2; i <= n; i++){
            fibonacciTomb[i] = fibonacciTomb[i-1] + fibonacciTomb[i-2];
        }
        return fibonacciTomb[n];
    }

    public static int fibonacci3(int n){
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i=2; i <= n; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    public static long greatestdevider(long a, long b) {
        if(a == 0 || b == 0) return a+b;
        return greatestdevider(b,a%b);
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //System.out.println(faktorialis(45));

        System.out.println("finobacci valtozoval: " + fibonacci3(45));

        long reszido1 = System.currentTimeMillis();
        System.out.println("futásidő: " + (reszido1-startTime)/1000);

        System.out.println("fibonacci tomb: " + fibonacciArray(45));

        long reszido2 = System.currentTimeMillis();
        System.out.println("futásidő: " + (reszido2-startTime)/1000);

        System.out.println("fibonacci rekurziv: " + fibonacci2(45));

        //System.out.println(greatestdevider(500, 250));

        long endTime = System.currentTimeMillis();
        System.out.println("futásidő: " + (endTime-startTime)/1000);

    }

}
