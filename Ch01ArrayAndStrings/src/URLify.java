/*
From, Cracking the Coding Interview, 6th Edition
Chapter 1. Arrays and Strings

1.3 Ch01_Q03/URLify: Write a method to replace all spaces in a string with '%20'.
    You may assume that the string has sufficient space at the end to hold additional characters,
    and that you are given the "true" length of the string.

    (Note: if implementing in Java, please use a character array so that you can perform this
    operation in place.)

    Example
    Input: "Mr John Smith    ", 13
    Output: "Mr%20John%20Smith"
*/

public class URLify {
    private static String urlifyString(char[] c, int len) {

        // Two pointers: one at the end of the array and another at end of the string
        int start = len - 1;
        int pointer = c.length - 1;

        while(start >= 0) {
            if(c[start] == ' ') {
                c[pointer--] = '0';
                c[pointer--] = '2';
                c[pointer--] = '%';
            } else {
                c[pointer--] = c[start];
            }
            start--;
        }

        return new String(c);
    }


    private static void test(String s) {
        int len = s.length();
        int spaces = 0;

        // count spaces
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                spaces++;
            }
        }

        // Spaces * 2 to accomodate extra characters
        int arrayLen =  len + (spaces * 2);
        char[] c = new char[arrayLen];

        // copy string into char array
        for (int i = 0; i < len; i++) {
            c[i] = s.charAt(i);
        }

        System.out.println(s);
        System.out.println(urlifyString(c, len) + "\n");
    }


    public static void main(String[] args) {
        test("Mr John Smith");
        test("Google Drive");
        test("This is my folder");
        test("I will display as follows in URL");
        test(" ");
        test("");
    }
}
