class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes (the minus sign breaks symmetry)
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            reversed = reversed * 10 + digit;
        }

        return original == reversed;
    }
}
