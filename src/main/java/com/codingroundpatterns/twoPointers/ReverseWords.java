package com.codingroundpatterns.twoPointers;

public class ReverseWords {

    public static String reverseWords(String sentence) {
        char[] charArray = sentence.toCharArray();
        int length = sentence.length();
        reverse(charArray, 0, length -1);
        reverseWords(charArray, length);
        return cleanSpaces(charArray, length);
    }

    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    private static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;
            while (j < i || j < n && a[j] != ' ') j++;
            reverse(a, i, j - 1);
        }
    }

    private static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }
        return new String(a).substring(0, i);
    }
}
