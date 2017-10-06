/*
From, Cracking the Coding Interview, 6th Edition
Chapter 1. Arrays and Strings

1.2 Check Permutation:* Given two string, write a method to decide
    if one is a permutation of the other.
*/


public class CheckPermutation {

    private static boolean isAnagram(String one, String two) {

        if(one.length() != two.length()) {
            return false;
        }

        int[] aCharSet = new int[128];

        // For string one, increase the counter in character set by 1
        for (int i = 0; i < one.length() ; i++) {
            aCharSet[one.charAt(i)]++;
        }


        // For string two, decrease the counter in character set by 1
        for (int i = 0; i < two.length() ; i++) {
            if(--aCharSet[two.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }

    private static void test(String one, String two) {
        System.out.println("One: " + one);
        System.out.println("Two: " + two);
        System.out.println("Is anagram: " + isAnagram(one, two) + "\n");
    }

    public static void main(String[] args) {
        test("dog", "god");
        test("repaint", "painter");
        test("Cheater", "Teacher");
        test("racecar", "race car");
        test("a", "a");
        test("", "");
        test(" ", " ");
        test("doga", "god");
    }
}
