public class LC1344 {
    public double angleClock(int hour, int minutes) {
        // hour
        double a = ((double)hour % 12) * 30 + (double)minutes / 2;

        // minutes
        double b = minutes * 6;
        double diff = Math.abs(a-b);
        if(diff > 180){
            return 360 - diff;
        }
        else{
            return diff;
        }

    }
}
