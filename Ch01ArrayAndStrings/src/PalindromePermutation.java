/*
From, Cracking the Coding Interview, 6th Edition
Chapter 1. Arrays and Strings

1.4 Palindrome Permutation:* Given a string write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
        Example:
        Input: Tact Coa
        Output: True (permutations: "taco cat", "atco cta", etc.)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePermutation {

    private static boolean isPalindrome(String s) {
        // if length is zero of one, it is a palindrome;
        if(s.length() <= 1) {
            return true;
        }

        int odd = 0;
        int[] cCount= new int[128];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            cCount[s.charAt(i)]++;
        }

        // Check if there are more than one odd
        for (int i = 0; i < 128; i++) {
            if(cCount[i] > 0 && (cCount[i] % 2 == 1) ) {
                odd++;
            }
        }

        // If more than one odd, it is not a palindrome
        return odd <= 1;
    }

    private static void test(String s) {
        System.out.println(s + ", " + isPalindrome(s));
    }

    public static void main(String[] args) {
        test("a");
        test("");
        test("ab");
        test("aba");
        test("aabb");
        test("aabbccdeeffgghhiijkjk");
    }
}
