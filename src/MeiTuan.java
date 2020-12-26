import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan {
    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int T = scan.nextInt();
//        scan.nextLine();
        //System.out.print(q1(new int[]{-1,2,3,10, 100}));
        System.out.print(q2(4, 1, 3, new int[]{3,3,3,3}));
    }


    public static int q1(int[] array){

        Arrays.sort(array);
        int result = 0;
        for(int i = 0; i < array.length; i ++){
            result += Math.abs(array[i] - (i + 1)) ;
        }

        return result;
    }

    public static int q2(int n, int x, int y, int[] array){
        Arrays.sort(array);
        for(int i = 0; i < array.length; i ++){
            if(i >= x && i <= y && n-i >= x && n-i <= y){ // satisfy both number
                if(i > 0 && array[i] == array[i - 1]){
                }
                else{
                    return array[i] - 1;
                }
            }
        }
        if(y == array.length)
            return array[array.length - 1];
        return -1;
    }

    public static void q3(char[] table, char[] people){
        for(char c: people){
            boolean flag = false;
            if(c == 'M'){
                for(int i = 0 ; i < table.length; i ++){
                    if(table[i] == '1'){
                        table[i] = '2';
                        flag = true;
                        System.out.println(i + 1);
                        break;
                    }
                }
                if(!flag){
                    for(int i = 0 ; i < table.length; i ++){
                        if(table[i] == '0'){
                            table[i] = '1';
                            System.out.println(i + 1);
                            break;
                        }
                    }
                }

            }
            else if(c == 'F'){
                for(int i = 0 ; i < table.length; i ++){
                    if(table[i] == '0'){
                        table[i] = '1';
                        flag = true;
                        System.out.println(i + 1);
                        break;
                    }
                }
                if(!flag){
                    for(int i = 0 ; i < table.length; i ++){
                        if(table[i] == '1'){
                            table[i] = '2';
                            System.out.println(i + 1);
                            break;
                        }
                    }
                }
            }
        }
    }
}