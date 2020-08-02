import java.util.HashMap;

public class LC359 {

    private HashMap<String, Integer> dict;
    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
    public LC359() {
        dict = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!dict.containsKey(message)){
            dict.put(message, timestamp);
            return true;
        }
        else{
            Integer oldTime = dict.get(message);
            if(timestamp - oldTime >= 10){
                dict.put(message, timestamp);
                return true;
            }
            else{
                return false;
            }

        }
    }

}

