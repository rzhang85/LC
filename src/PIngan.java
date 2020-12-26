import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class PIngan {
    public void test(){
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        int n = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n ++;

            int a = in.nextInt();

            Integer count = hashtable.get(a);
            if(count == null)
                hashtable.put(a, 1);
            else{
                hashtable.put(a, count+1);
            }

        }
        Set<Integer> keys = hashtable.keySet();
        for(Integer key: keys){
            if(hashtable.get(key) >= (n +1)/ 2) {
                System.out.println(key);
                return;
            }
        }
        System.out.println(0);
    }
}
