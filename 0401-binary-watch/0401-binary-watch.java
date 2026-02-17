import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    if (m < 10) {
                        result.add(h + ":0" + m);
                    } else {
                        result.add(h + ":" + m);
                    }
                }
            }
        }
        return result;
    }
}
