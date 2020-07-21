package offer;


import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static int nums[]={2, 3, 1, 0, 2, 5, 3};

    public static int findRepeatNumber(int nums[]){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] arge){
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
