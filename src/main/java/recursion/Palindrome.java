package recursion;

class Palindrome {

    Boolean isPalindrome(String s) {
        return (s.length() < 2) || s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-2));
    }

}
