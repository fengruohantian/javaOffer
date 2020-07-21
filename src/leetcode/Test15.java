package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test15
 * @Description: 三数之和等于0(排序+双指针)
 *    1.暴力法：三数循环 n^3
 *    2.排序+双指针 n^2
 * @Author yunquan.hao
 * @Date 2020年07月17日 23:16
 * @Version V1.0
 **/
public class Test15 {

    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        //双指针防止越界进行-2处理
        for (int i = 0; i < nums.length -2; i++) {
            //如果排序后首位数大于0的话，则表明 后续三数之和不可能为0
            if(nums[0] > 0){
                break;
            }
            //如果前后两数相等，则也不会出现和为0的值，跳过
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //设置左右双指针,左指针为当前数索引+1，右指针为索引最大值-1；
            int left = i+1;
            int right = nums.length-1;
            //当左指针索引 小于右指针索引时，持续循环，否则循环完毕
            while (left < right){
                //如果当前数字+左指针映射的数字+右指针映射的数字为0，则满足条件添加到返回列表中
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    //满足条件
                    lists.add(Arrays.asList(new Integer[]{nums[i],nums[left],nums[right]}));
                    //在此过程中，需要满足左指针小于右指针，同时需验证当前左右指针数字值分别收缩相邻的数字值是否为重复，若为重复值则需要再次收缩移动一位
                    //满足左指针小于右指针，同时左指针当前数字值等于左指针索引加一位置的数字值，则将左指针索引向右收缩移动一位
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    //满足左指针小于右指针，同时右指针当前数字值等于右指针索引减一位置的数字值，则将右指针索引向左收缩移动一位
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    //需要将左右指针同时进行收缩一位
                    left++;
                    right--;
                }else if(sum < 0){
                    //如果三数之和小于0时，因数组从小到大排序后，则需要将左指针向右移动一位(增加三个数中中间数字值)
                    left++;
                }else{
                    //如果三数之和大于0，因数组从小到大排序后，则需要将右指针向左移动一位(减小三个数中右边的数字值)
                    right--;
                }
            }

        }
        return lists;
    }

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2,0,1,1,2};
        Test15 t = new Test15();
        List<List<Integer>> lists = t.threeSum(nums);
        lists.forEach(v->{
            System.out.println(v);
        });
    }
}
