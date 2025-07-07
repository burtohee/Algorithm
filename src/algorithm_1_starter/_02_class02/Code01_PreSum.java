package algorithm_1_starter._02_class02;

public class Code01_PreSum {


    public static class RangeSumWithLeftToRight
    {
        public static int sum;

        public static  int getSumFromLeftToRight(int[] arr, int L, int R)
        {
            sum = 0;
            for(int i = L; i <= R; i++)
            {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static class RangeSumWithMatrix
    {
        public static  int [][] matrix;

        public static int[][] generateMatrixForGetSumFromLeftToRight(int[] arr)
        {
            matrix = new int[arr.length][arr.length];

            for(int i =0; i < arr.length ; i++)
            {
                for(int j =0; j < arr.length ; j++)
                {
                    if(i > j)
                    {
                        matrix[i][j] = Integer.MIN_VALUE; // bottom-left triangle
                        continue;
                    }
                    if(i == j)
                    {
                        matrix[i][j] = arr[i];
                    }
                    else
                    {
                        matrix[i][j] = matrix[i][j-1] + arr[j];
                    }
                }
            }
            return matrix;
        }

        public static void printMatrixForGetSumFromLeftToRight(int[][] matrix)
        {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if (anInt == Integer.MIN_VALUE) {
                        System.out.printf("%8s", "MIN");
                    } else {
                        System.out.printf("%8d", anInt);
                    }
                }
                System.out.println();
            }
        }

        public static void printMatrixForGetSumFromLeftToRight()
        {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if (anInt == Integer.MIN_VALUE) {
                        System.out.printf("%8s", "MIN");
                    } else {
                        System.out.printf("%8d", anInt);
                    }
                }
                System.out.println();
            }
        }
    }


    public static class RangeSumWithHelperArray
    {
        public static int[] helperArray;

        public static int[] generateHelperArrayForGetSumFromLeftToRight(int[] arr)
        {
            helperArray = new int[arr.length];
            helperArray[0] = arr[0];
            for(int i =1; i < arr.length; i++)
            {
                helperArray[i] = arr[i] + helperArray[i-1];
            }
            return helperArray;
        }

        public static void printHelperArrayForGetSumFromLeftToRight(int[] helperArray)
        {
            for (int i = 0; i < helperArray.length; i++) {
                System.out.printf("%8d", helperArray[i]);
            }
            System.out.println();
        }

        public static void printHelperArrayForGetSumFromLeftToRight()
        {
            for (int anInt : helperArray) {
                System.out.printf("%8d", anInt);
            }
            System.out.println();
        }

        public static  int getSumFromLeftToRightByGenerateHelperArrayForGetSumFromLeftToRight(int[] helperArray, int L, int R)
        {
            return L== 0 ? helperArray[R]: helperArray[R] - helperArray[L-1];
        }
        public static  int getSumFromLeftToRightByGenerateHelperArrayForGetSumFromLeftToRight(int L, int R)
        {
            return L== 0 ? helperArray[R]: helperArray[R] - helperArray[L-1];
        }
    }




//    public static void printGenerate2DArrayForgetSumFromLeftToRight(int[][] matrix)
//    {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == Integer.MIN_VALUE) {
//                    System.out.printf("%8s", "MIN");
//                } else {
//                    System.out.printf("%8d", matrix[i][j]);
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public static int[] generateHelperArrayForgetSumFromLeftToRight(int[] arr)
//    {
//        int [] helperArray = new int[arr.length];
//        helperArray[0] = arr[0];
//        for(int i =1; i < arr.length; i++)
//        {
//            helperArray[i] = arr[i] + helperArray[i-1];
//        }
//        return helperArray;
//    }
//
//    public static void printgenerateHelperArrayForgetSumFromLeftToRight(int[] helperAraray)
//    {
//        for (int i = 0; i < helperAraray.length; i++) {
//            System.out.printf("%8d", helperAraray[i]);
//        }
//        System.out.println();
//    }

    public static  int getSumFromLeftToRightBygenerateHelperArrayForgetSumFromLeftToRight(int[] helperArray, int L, int R)
    {
        return L== 0 ? helperArray[R]: helperArray[R] - helperArray[L-1];
    }


    public static void main(String[] args)
    {
        int[] original = {3,2,-1,6,7,2,-2};

//        RangeSumWithLeftToRight rangeSumWithLeftToRight = new RangeSumWithLeftToRight();

        int resultFromRangeSumWithLeftToRight = RangeSumWithLeftToRight.getSumFromLeftToRight(original, 0 , 3);

        RangeSumWithMatrix rangeSumWithMatrix = new RangeSumWithMatrix();

        int[][] generateMatrixForgetSumFromLeftToRight = rangeSumWithMatrix.generateMatrixForGetSumFromLeftToRight(original);
        RangeSumWithMatrix.printMatrixForGetSumFromLeftToRight();
        System.out.println("===================");
        System.out.println(resultFromRangeSumWithLeftToRight);
        System.out.println(generateMatrixForgetSumFromLeftToRight[0][3]);

        System.out.println("===================");
        int[] resultFromGenerateHelperArrayForgetSumFromLeftToRight = RangeSumWithHelperArray.generateHelperArrayForGetSumFromLeftToRight(original);
        RangeSumWithHelperArray.printHelperArrayForGetSumFromLeftToRight(resultFromGenerateHelperArrayForgetSumFromLeftToRight);
        System.out.println("===================");

        int resultFromGetSumFromLeftToRightByGenerateHelperArrayForgetSumFromLeftToRight = RangeSumWithHelperArray.getSumFromLeftToRightByGenerateHelperArrayForGetSumFromLeftToRight(resultFromGenerateHelperArrayForgetSumFromLeftToRight, 0 , 3);
        System.out.println(resultFromRangeSumWithLeftToRight);
        System.out.println(resultFromGetSumFromLeftToRightByGenerateHelperArrayForgetSumFromLeftToRight);

    }
}
