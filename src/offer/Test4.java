package offer;


public class Test4 {

    public static int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}};

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if(target == anInt){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        boolean flag = false;
        int rows = matrix.length-1,cols = matrix[0].length-1;
        int curRow = 0,curCol = 0;
        while (curRow <= rows){
            int curNum = matrix[curRow][curCol];
            if(curNum == target){
                flag = true;
                break;
            }else{
                if(curCol < cols){
                    curCol++;
                }else{
                    curRow++;
                    curCol = 0;
                }
            }
        }
        return flag;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        boolean flag = false;
        int rows = matrix.length-1,cols = matrix[0].length-1;
        int curRow = 0,curCol = 0;
        while (curRow <= rows){
            int curNum = matrix[curRow][curCol];
            if(curNum == target){
                flag = true;
                break;
            }else if(curNum > target || curCol == cols){
                curRow++;
                curCol = 0;
            }else if(curCol < cols){
                curCol++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{-1,3}};
        boolean numberIn2DArray = findNumberIn2DArray3(matrix, 30);
        System.out.println(numberIn2DArray);
    }
}
