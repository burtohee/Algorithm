package LeetCodeHome.LeetCode75;

public class Code14_11_Container_With_Most_Water {

    public static void main(String [] args)
    {
        Code14_11_Container_With_Most_Water code1411ContainerWithMostWater = new Code14_11_Container_With_Most_Water();
        int[][] testCases = {
                {1,8,6,2,5,4,8,3,7}, // 49
                {1,1}, // 1
                {1,0}, // 0
                {0,0,0,1,2,0,0,8,0,1}, // 49

//                {6, 7, 1, 2},      // true
//                {1, 2, 3, 4, 5},      // true
//                {5, 4, 3, 2, 1},      // false
//                {2, 1, 5, 0, 4, 6},   // true
//                {20, 100, 10, 12, 5, 13}, // true
//                {1, 1, 1, 1, 1},      // false
//                {1, 2, 1, 3},          // true
//                {5, 1, 6}          // false
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = code1411ContainerWithMostWater.maxArea(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }



    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int low=0, area = Integer.MIN_VALUE;

        while(left<right)
        {
            low = Math.min(height[left], height[right]);
            area = Math.max(area, low * (right - left));

            while(left<right && height[left] <= low) left++;
            while(left<right && height[right] <= low) right--;
        }
        return area;

    }


    class Solution1 {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int area = 0;
            int high = 0;

            while (left < right) {
                high = Math.min(height[left], height[right]);
                area = Math.max(area, high * (right - left));

                // Move past lines that are not taller than current min height
                while (left < right && height[left] <= high) left++;
                while (left < right && height[right] <= high) right--;
            }

            return area;
        }
    }


    class Solution2 {
        public int maxArea(int[] height) {

            int i = 0, j = height.length - 1;
            int max = Integer.MIN_VALUE;
            while(i < j)
            {
                int minIndex = height[i] < height[j] ? i : j;
                int area = height[minIndex] * (j - i);
                if(area > max)
                {
                    max = area;
                }
                if(minIndex == i)
                {
                    i = minIndex + 1;
                }
                else
                {
                    j = minIndex - 1;
                }
            }
            return max;
        }
    }


}
