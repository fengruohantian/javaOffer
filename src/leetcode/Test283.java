package leetcode;

import java.util.Arrays;

/**
 * @ClassName Test283
 * @Description: 移动零
 * @Author yunquan.hao
 * @Date 2020年07月19日 11:37
 * @Version V1.0
 **/
public class Test283 {
    public void moveZeroes(int[] nums) {
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right++] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Test283 t = new Test283();
        t.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
