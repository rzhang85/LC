import java.util.*;

public class TencentOA {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> a = new ArrayList<>();
//        int aCount = in.nextInt();
//        for(int i = 0; i < aCount; i++){
//            a.add(in.nextInt());
//        }
//        ArrayList<Integer> b = new ArrayList<>();
//        int bCount = in.nextInt();
//        for(int i = 0; i < bCount; i++){
//            b.add(in.nextInt());
//        }
//
//        checkSame(a, b);
//
//    }
//    // 1
//    public static void checkSame(ArrayList<Integer> a, ArrayList<Integer> b){
//        int i = 0, j = 0;
//        while(i < a.size() && j < b.size()){
//            if(a.get(i) < b.get(j)){
//                j ++;
//            }
//            else if(a.get(i) > b.get(j)){
//                i ++;
//            }
//            else{
//                System.out.println(a.get(i));
//                i++;
//                j++;
//            }
//        }
//    }

// 2
    static ArrayList<Set<Integer>> groupBack = new ArrayList<>();
    static ArrayList<HashSet<Integer>> groups = new ArrayList<>();
    static HashSet<Integer> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeCount = in.nextInt();
        int groupCount = in.nextInt();

        for(int i = 0; i < nodeCount; i ++){
            groupBack.add(new HashSet<>());
        }

        for(int group = 0; group < groupCount; group ++){
            int count = in.nextInt();
            HashSet<Integer> groupSet = new HashSet<>();
            for(int j = 0; j < count; j ++){
                int tmp = in.nextInt();
                groupSet.add(tmp);
                groupBack.get(tmp).add(group);
            }
            groups.add(groupSet);
        }

        if(groupBack.get(0).size() == 0)
            System.out.println(0);
        else{
            DFS(0);
            System.out.println(res.size());
        }
    }

    public static void DFS(int node){
        if(res.contains(node))
            return;
        else
            res.add(node);

        for(int group : groupBack.get(node)){
            for (int nextNode : groups.get(group)){
                DFS(nextNode);
            }
        }
    }

    // 03
//    public static void main(String[] args) {
//        HashMap<String, Integer> hashmap = new HashMap<>();
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int K = in.nextInt();
//        in.nextLine();
//        for(int i = 0; i < N; i ++){
//            String tmp = in.nextLine();
//            Integer count = hashmap.get(tmp);
//            if(count == null)
//                hashmap.put(tmp, 1);
//            else{
//                hashmap.put(tmp, count + 1);
//            }
//        }
//        sortByKeyValue(hashmap, K);
//        sortDesByKeyValue(hashmap, K);
//    }
//
//    private static void sortByKeyValue(HashMap map, int K) {
//        List list = new LinkedList(map.entrySet());
//        list.sort((o1, o2) -> ((Map.Entry) (o1)).getValue() == ((Map.Entry) (o2)).getValue() ?
//                ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey()) : (int) ((Map.Entry) (o2)).getValue() - (int) ((Map.Entry) (o1)).getValue());
//
//        for(int i = 0; i < K; i ++){
//            System.out.println(((Map.Entry)list.get(i)).getKey() + " " + ((Map.Entry)list.get(i)).getValue());
//        }
//    }
//
//    private static void sortDesByKeyValue(HashMap map, int K) {
//        List list = new LinkedList(map.entrySet());
//        list.sort((o1, o2) -> ((Map.Entry) (o1)).getValue() == ((Map.Entry) (o2)).getValue() ?
//                ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey()) : (int) ((Map.Entry) (o1)).getValue() - (int) ((Map.Entry) (o2)).getValue());
//
//        for(int i = 0; i < K; i ++){
//            System.out.println(((Map.Entry)list.get(i)).getKey() + " " + ((Map.Entry)list.get(i)).getValue());
//        }
//    }

    // 04
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] array = new int[n];
//        for(int i = 0 ; i < n; i ++){
//            array[i] = in.nextInt();
//        }
//        int[] tmp = array.clone();
//        Arrays.sort(array);
//        int first = array[array.length / 2 - 1];
//        int second = array[array.length / 2 ];
//
//        for(int i = 0 ; i < tmp.length; i ++){
//            if(tmp[i] < second){
//                System.out.println(second);
//            }
//            else
//                System.out.println(first);
//        }
//
//    }

}
