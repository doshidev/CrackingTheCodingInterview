public class OneEditAway {
    public static void main(String[] args) {
        test("pale", "ple");
        test("pales", "pale");
        test("pale", "bale");
        test("pale", "bake");
        test("", "");
        test("", "a");
    }

    private static void test(String s1, String s2) {
        System.out.println("[" + s1 + ", " + s2 + "] -> " + isOneAway(s1, s2));
    }

    private static boolean isOneAway(String s1, String s2) {
        boolean different = false;
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        String first = (s1.length() < s2.length()) ? s1 : s2;
        String second = (s1.length() < s2.length()) ? s2 : s1;

        int one = 0, two = 0;

        while (one < first.length() && two < second.length()) {
            if (first.charAt(one) != second.charAt(two)) {
                if (different) {
                    return false;
                }
                different = true;

                if (first.length() == second.length()) {
                    one++;
                }
            } else {
                one++;
            }
            two++;
        }
        return true;
    }
}