// https://www.hackerrank.com/challenges/strange-code/problem

public class StrangeCounter {

    // This was my brute force solution i.e O(N)
    // For this solution I am getting TLE, try to find better solution
    public static long bruteForce(long t) {
        long initial = 3;
        long val = 3;
        for (long i = 1; i < t; i++) {
            val--;
            if (val == 0) {
                val = initial*2;
                initial = val;
            }
        }
        return val;
    }


    // Got 3 star after solving this problem
    // more optimized solution
    public static long pattern(long t) {
        /*
            We can observe pattern in this problem which is something like this for every different cycle:
            initial Time: 1 4 10 22 46 94 ...
            starting val: 3 6 12 24 48 96 ...
            final Time  : 3 9 21 45 93 192...


            Hence, by observing the values, we can come to generate formula for each cycle

            initial time = 1
            starting val = 3
            final time = 3

            initial Time = initial time + starting val
            starting val = starting val * 2
            final time = final time + starting val

            and when we see our time is less than end time
            we can generate solution by (final time - t + 1)
         */
        long startVal = 3;
        long endTime = 3;

        while (endTime < t) {
            startVal *= 2;
            endTime += startVal;
        }

        return endTime - t + 1;
    }
}
