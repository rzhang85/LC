public class LC904 {
    public int totalFruit(int[] tree) {
        int lastFruit = -1; // second fruit
        int secondLastFruit = -1; // first fruit
        int currCount = 0;  // current length
        int lastFruitCount = 0; // length of continous last fruit
        int result = 0;

        for(int i = 0; i < tree.length; i ++){
            int fruit = tree[i];

            if(fruit == lastFruit || fruit == secondLastFruit){
                currCount ++; // if current fruit is same as last/second last, add 1 to length
            }
            else{
                currCount = lastFruitCount + 1; // if new fruit appears, slide window to last fruit length + current fruit
            }

            // update global length
            result = Math.max(result, currCount);

            // update last fruit length
            if(fruit == lastFruit){
                lastFruitCount ++;
            }
            else{
                lastFruitCount = 1;

                // fix sliding window: new fruit appears, assign last fruit to second last, and assign current fruit to last fruit.
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

        }

        return result;
    }
}
