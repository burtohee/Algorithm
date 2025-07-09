package LeetCodeHome.LeetCode75;

public class Code04_605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        return processCanPlaceFlowers(flowerbed, n);
    }

    public static boolean processCanPlaceFlowers(int[] flowerbed, int target)
    {
        int count = 0;
        int len  = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == len - 1 || flowerbed[i + 1] == 0);

                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    count++;

                    // optimization: if we have planted enough, return true directly
                    if (count >= target) {
                        return true;
                    }
                }

            }
        }
        return count >= target;
    }

    public static int[] updateFlowerbedHelper(int [] flowerbed)
    {
        int[] updatedFlowerBed = new int[flowerbed.length + 2];
        for(int i = 0; i < flowerbed.length; i++)
        {
            updatedFlowerBed[i+1] = flowerbed[i];
        }
        return updatedFlowerBed;
    }

    public static boolean processCanPlaceFlowers2(int[] flowerbed, int target)
    {

        flowerbed = updateFlowerbedHelper(flowerbed);
        int count = 0;
        for(int i = 1; i < flowerbed.length - 1; i++)
        {
            if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0)
            {
                flowerbed[i] = 1;
                count++;

                // optimization: if we have planted enough, return true directly
                if (count >= target) {
                    return true;
                }
            }
        }
        return count >= target;

    }

    // Main method for testing
    public static void main(String[] args) {

        // Test case 1
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Test case 1 result: " + processCanPlaceFlowers(flowerbed1, n1));  // Expected: true

        // Test case 2
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Test case 2 result: " + processCanPlaceFlowers(flowerbed2, n2));  // Expected: false

        // Test case 3
        int[] flowerbed3 = {0, 0, 1, 0, 0};
        int n3 = 2;
        System.out.println("Test case 3 result: " + processCanPlaceFlowers(flowerbed3, n3));  // Expected: true

        // Test case 4
        int[] flowerbed4 = {1,0,0,1,0,0};
        int n4 = 1;
        System.out.println("Test case 4 result: " + processCanPlaceFlowers2(flowerbed4, n4));  // Expected: true

    }


    class Solution1 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            int i = 0;
            while(i < len && n > 0) {
                if(flowerbed[i] == 1) i += 2;
                else if(i == len - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    i += 2;
                }
                else i += 3;
            }
            return n <= 0;
        }
    }



}

