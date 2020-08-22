public class LC905 {

    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;

        while(start < end){
            if(A[start] % 2 == 1 && A[end] % 2 == 0){
                swap(A, start, end);
                start ++;
                end --;
                continue;
            }

            if(A[start] % 2 == 0){
                start ++;
            }

            if(A[end] % 2 == 1){
                end --;
            }


        }


        return A;
    }


    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
