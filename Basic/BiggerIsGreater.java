
// https://www.hackerrank.com/challenges/bigger-is-greater/problem

import java.util.Arrays;

/*
    Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
    -- It must be greater than the original word
    -- It must be the smallest word that meets the first condition

    input : "abcd"
    output: "abdc" --> next largest permutation of abcd lexicographically is abdc

    if there is no next bigger permutation then return "no answer"

 */

public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        final int len = w.length();
        if (len < 2) return "no answer";
        boolean flag = false;

        int i = len-2;
        for (; i >= 0; i--) {
            if (w.charAt(i) < w.charAt(i+1)) {
                flag = true;
                break;
            }
        }
        if (!flag) return "no answer";

        char[] input = w.toCharArray();

        for (int k = len - 1; k >= 0; k--) {
            if (input[k] > input[i]) {
                char temp = input[k];
                input[k] = input[i];
                input[i] = temp;
                break;
            }
        }

        // reversing right part
        int l = i+1, h = len-1;
        while (l <= h) {
            char temp = input[l];
            input[l] = input[h];
            input[h] = temp;
            h--;
            l++;
        }

        return String.valueOf(input);
    }
}
