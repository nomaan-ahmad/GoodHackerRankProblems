
// https://www.hackerrank.com/challenges/halloween-sale/problem

public class HalloweenSale {
    public static void main(String[] args) {
        int p = 20;
        int d = 3;
        int m = 6;
        int s = 85;

        System.out.println(howManyGames(p, d, m ,s));
    }
    public static int howManyGames(int p, int d, int m, int s) {
        // p : initial price of the game
        // d : decrement of price after every purchase
        // m : minimum cost of the game
        // s : starting budget

        int count = 0;
        int spent = 0;
        if (s < p) return count;

        while (p >= m && spent + p <= s) {
            count++;
            spent += p;
            p -= d;
        }

        if (p < m) {
            while (spent + m <= s) {
                count++;
                spent += m;
            }
        }

        System.out.println("Spent amount: " + spent);

        return count;
    }
}
