class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour == 12) hour = 0;
        // angle per min 6 = (360 / 12)
        // angle per hour 30 = (360 / 12)
        // angle per less than a hour 0.5 = (30 / 60) = (360 / (12 * 60))
        double angle = (double)((minutes * 6) - ((hour * 30) + (minutes * 0.5)));
        return Math.min(Math.abs(angle), 360 - Math.abs(angle));
    }
}