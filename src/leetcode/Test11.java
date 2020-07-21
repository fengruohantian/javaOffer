package leetcode;

/**
 * @ClassName Test11
 * @Description: 容器最多盛水量
 *  容器最大盛水量 = 容器左右壁面高度 * 容器上下边距长度(双指针要注意左右指针收缩时，长度也要同时减少)
 *  1.双指针 n
 * @Author yunquan.hao
 * @Date 2020年07月19日 10:58
 * @Version V1.0
 **/
public class Test11 {
    //双指针
    //容器最大盛水量 = 容器左右壁面高度 * 容器上下边距长度
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        //存储最大容量值
        int maxVal = 0;
        //左右指针不重复则继续循环，求出可能出现的最大值
        while (left < right){
            //数组中左右壁面中最小的高度 * 容器上下边距长度(双指针要注意左右指针收缩时，长度也要同时减少)
            //每次循环左/右指针出现收缩时，容器上下边距长度也要同时收缩
            int min = Math.min(height[left],height[right]) * (right - left);
            //单独使用一个值，每次比较出最大值
            maxVal = Math.max(maxVal, min);
            //每次循环，都需要将左右壁面中高度低的一侧，进行收缩
            //如果左壁面高度小于右壁面高度
            if(height[left] <= height[right]){
                left++;
            } else {
                //如果右壁面高度小于等于左壁面高度
                right--;
            }
        }
        return maxVal;
    }
    public static void main(String[] args) {
        int[] ints = {1,8,6,2,5,4,8,3,7};
        Test11 t= new Test11();
        System.out.println(t.maxArea(ints));
    }
}
