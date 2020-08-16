import java.util.ArrayList;
import java.util.List;

public class LC119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        result.add(1);


        for(int i = 0; i < rowIndex; i ++){
            for(int j = i; j > 0; j --){
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);

        }

        return result;
    }

}
