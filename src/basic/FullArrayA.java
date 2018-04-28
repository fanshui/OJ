package basic;


import java.util.Arrays;

public class FullArrayA {

    //递归方法实现 确定第一个数 后面再全排列

    /**
     * 如果有一个序列T = {a1, a2, a3, …, ai, … , aj, … , an}。其中，a[i] = a[j]。
     * 那么是不是就可以说，在a[i]上，只要进行一次交换就可以了，a[j]可以直接忽略不计了。
     * 好了，基于这样一个思路，我们对程序进行一些改进。我们每一次交换递归之前对元素进行检查，
     * 如果这个元素在后面还存在数值相同的元素，那么我们就可以跳过进行下一次循环递归
     * 即从开头到a[i]有与a[i]相等的，就不交换 第一个位置与多个相同的元素只交换一次
     * @param array
     * @param index
     * @param end
     */
    public static void fullsort(int[] array,int index,int end){

        if (index == end) {
            System.out.println(Arrays.toString(array));
        }else {
            for(int i = index; i <= end ; i++) {
                if (!swapAccepted(array, index, i)) { //看前面有没有与a[i]交换过
                    continue;
                }
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                fullsort(array,index + 1,end);
                temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {1,2,1};
        fullsort(array,0,2);
    }

    private static boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }


}
