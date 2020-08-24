import java.util.Random;
import java.util.TreeMap;

public class LC497 {
    Random random;
    TreeMap<Integer, int[]> map;
    int totalArea = 0;

    public LC497(int[][] rects){
        random = new Random();
        map = new TreeMap<>();

        for(int i = 0; i < rects.length; i ++){
            int[] rect = rects[i];
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            totalArea += width * height;

            map.put(totalArea, rect);
        }
    }

    public int[] pick(){
        int[] point = new int[2];
        int key = map.ceilingKey( random.nextInt(totalArea + 1));
        int[] rect = map.get(key);

        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;

        point[0] = rect[0] + random.nextInt(width);
        point[1] = rect[1] + random.nextInt(height);

        return point;
    }

}
