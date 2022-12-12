package com.codingroundpatterns.fastandslowpointers;

public class HappyNumber {

    public static void main(String[] args) {
        isHappyNumber(2147483646);
    }

    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = getNext(slow);
        while(fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        int lastDigit;
        while(num > 0) {
            lastDigit = (num % 10);
            sum += (lastDigit * lastDigit);
            num/=10;
        }
        return sum;
    }
}
