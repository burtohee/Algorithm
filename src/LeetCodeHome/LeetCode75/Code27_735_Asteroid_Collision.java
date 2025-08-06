package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.Stack;

public class Code27_735_Asteroid_Collision {

    public static void main(String [] args)
    {
        Code27_735_Asteroid_Collision code27735AsteroidCollision = new Code27_735_Asteroid_Collision();
        int[][] testCases = {
                {1,-1,-2,-2},
                {5,10,-5},
                {8,-8}, // 49
                {10,2,-5},
                {-2,-1,1,2}, // 49

                {-2,-2,1,-2}, // 49
                {2,2,-5},
                {-2,1,1,-1},


//                {1,1}, // 1
//                {1,0}, // 0
//                {0,0,0,1,2,0,0,8,0,1}, // 49

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
            int [] result = code27735AsteroidCollision.asteroidCollision(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + Arrays.toString(result));
        }
    }

//    public boolean isSameSign(int sign, int target)
//    {
//        return sign > 0 && target > 0;
//    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> result = new Stack<>();
        for(int i = 0; i < asteroids.length; i++)
        {
            if(result.isEmpty())
            {
                result.add(asteroids[i]);
                continue;
            }
            if(!(result.peek() > 0 && asteroids[i] < 0))
            {
                result.add(asteroids[i]);
            }
            else
            {
                int pop = result.pop();

                while(!result.isEmpty() && (result.peek() > 0 && asteroids[i] < 0) && Math.abs(asteroids[i]) > Math.abs(pop))
                {
                    pop = result.pop();
                }

                if(result.isEmpty() && Math.abs(pop) < Math.abs(asteroids[i]))
                {
                    result.add(asteroids[i]);
                }
                else{
                    if(Math.abs(pop) < Math.abs(asteroids[i]))
                    {
                        result.add(asteroids[i]);
                    }
                    if(Math.abs(pop) > Math.abs(asteroids[i]))
                    {
                        result.add(pop);
                    }
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    class Solution1 {
        public int[] asteroidCollision(int[] asteroids) {
            int n = asteroids.length;
            int j = 0;

            for (int i = 0; i < n; i++) {
                int asteroid = asteroids[i];
                while (j>0 && asteroids[j-1]>0 && asteroid<0 && asteroids[j-1] < Math.abs(asteroid))
                {j--;}

                if (j==0 || asteroid>0 || asteroids[j-1]<0)
                    asteroids[j++] = asteroid;
                else if(asteroids[j-1] == Math.abs(asteroid))
                    j--;
            }

            int[] result = new int[j];
            System.arraycopy(asteroids, 0, result, 0, j);

            return result;
        }
    }

    class Solution2 {
        public int[] asteroidCollision(int[] asteroids) {
            int[] st = new int[asteroids.length];
            int top = -1;

            for (int i = 0; i < asteroids.length; i++) {
                boolean destroyed = false;

                // Handle collisions only if current asteroid is moving left
                // and top of stack is moving right
                while (top >= 0 && st[top] > 0 && asteroids[i] < 0) {
                    if (Math.abs(st[top]) < Math.abs(asteroids[i])) {
                        // Top asteroid explodes
                        top--;
                    } else if (Math.abs(st[top]) == Math.abs(asteroids[i])) {
                        // Both explode
                        top--;
                        destroyed = true;
                        break;
                    } else {
                        // Current asteroid explodes
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    st[++top] = asteroids[i];
                }
            }

            // Return surviving asteroids
            int[] result = new int[top + 1];
            for (int i = 0; i <= top; i++) {
                result[i] = st[i];
            }
            return result;
        }
    }

    class Solution3 {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int a : asteroids) {
                while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                    int top = stack.peek();
                    int sum = a + top;

                    if (sum < 0) {
                        stack.pop(); // top asteroid destroyed
                    } else if (sum > 0) {
                        a = 0; // current asteroid destroyed
                        break;
                    } else {
                        stack.pop(); // both destroyed
                        a = 0;
                        break;
                    }
                }

                if (a != 0) {
                    stack.push(a);
                }
            }

            // Convert stack to array
            int[] result = new int[stack.size()];
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }
    }


    class Solution5 {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> result = new Stack<>();
            for(int i = 0; i < asteroids.length; i++)
            {
                if(result.isEmpty())
                {
                    result.add(asteroids[i]);
                    continue;
                }
                if(!(result.peek() > 0 && asteroids[i] < 0))
                {
                    result.add(asteroids[i]);
                }
                else
                {
                    int pop = result.pop();

                    while(!result.isEmpty() && (result.peek() > 0 && asteroids[i] < 0) && Math.abs(asteroids[i]) > Math.abs(pop))
                    {
                        pop = result.pop();
                    }

                    if(result.isEmpty() && Math.abs(pop) < Math.abs(asteroids[i]))
                    {
                        result.add(asteroids[i]);
                    }
                    else{
                        if(Math.abs(pop) < Math.abs(asteroids[i]))
                        {
                            result.add(asteroids[i]);
                        }
                        if(Math.abs(pop) > Math.abs(asteroids[i]))
                        {
                            result.add(pop);
                        }
                    }
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
