package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description: 两数之和
 *  1.暴力法：使用嵌套for循环直接判断即可 n^2
 *  2.哈希法：获取减数值对应哈希中的值与坐标映射即可 理论上为n，
 *          如果对结果要求严格一些的话，假如数组中出现三个重复值，目标值为前两个下标的此方法不实用
 *          [2,2,2,6],target=4,哈希法返回结果为[0,2]，若结果要求为[0,1]的话，此方法不满足
 *  3.排序+双指针 可解决哈希法中某些场景返回结果与预期结果不一直问题 n
 * @Author yunquan.hao
 * @Date 2020年07月18日 10:23
 * @Version V1.0
 **/
public class Test1 {
    //双指针
    //需要记录原始映射关系，否则无法准确返回
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length <= 1){
            return res;
        }
        int[] ints = Arrays.copyOf(nums, nums.length);
        //排序
        Arrays.sort(ints);
        int left = 0;
        int right = ints.length-1;
        for (int i = 0; i < ints.length-2; i++) {
            int sum = ints[left]+ints[right];
            if(sum == target){
                if(target < 0){
                    int temp=0;
                    temp = left;
                    left = right;
                    right = temp;
                }
                break;
            }else if(sum < target){
                //如果和小于目标值，则左指针向右移动一位
                left++;
            }else {
                //如果和大于目标值，则右指针向左移动一位
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == ints[left]){
                res[0] = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == ints[right] && i != res[0]){
                res[1] = i;
                break;
            }
        }
        return res;
    }
    //哈希法
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length <= 1){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i <nums.length; i++) {
            int num = target - nums[i];
            //当前下标值与哈希中存储的下标值不能重复
            if(map.containsKey(num) && i != map.get(num) ){
                res[0] = i;
                res[1] = map.get(num);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int[] nums1 = {3,3};
        int[] nums2 = {2,7,11,15};
        int[] nums3 = {3,2,3,3};
        int target = -8;
        int target1 = 6;
        int target2 = 9;
        int target3 = 6;
        Test1 t = new Test1();
        int[] ints = t.twoSum(nums3, target3);
        System.out.println(Arrays.toString(ints));
    }

}
