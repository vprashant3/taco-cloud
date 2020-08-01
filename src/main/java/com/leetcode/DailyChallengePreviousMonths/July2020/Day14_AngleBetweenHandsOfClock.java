package com.leetcode.DailyChallengePreviousMonths.July2020;

class Day14_AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        new Day14_AngleBetweenHandsOfAClock().angleClock(1,  57);
    }


   // improve solution
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes*(360/60);
        double hourAngle = hour == 12 ? minuteAngle/12 : hour*(360/12) + minuteAngle/12;

        double angle = Math.abs(minuteAngle - hourAngle);

        return Math.min(360-angle, angle);

    }

    // min2 is needed when hour and minute are diff halves
    public double angleClockFirstAttempt(int hour, int minutes) {
        double minuteAngle = minutes*(360/60);
        double hourAngle = hour == 12 ? minuteAngle/12 : hour*(360/12) + minuteAngle/12;

        double min1 =  Math.min(Math.abs(hourAngle-minuteAngle), Math.abs(minuteAngle-hourAngle));
        double min2 =  Math.min(Math.abs((360-hourAngle)+minuteAngle) , Math.abs((360-minuteAngle)+hourAngle));

        return Math.min(min1, min2);

    }


}
