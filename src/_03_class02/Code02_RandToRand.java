package _03_class02;

public class Code02_RandToRand {

    public static void proveRandomEqualChance(int times , float lessThan)
    {
        // Math.random() -> double -> [ 0, 1 )
        // Because there is limited bits on computer, therefore, each number will have same chances to be selected


        int testTimes = 10000000;
        int count = 0;
        for(int i = 0; i < testTimes; i++)
        {

            if(Math.random() * times < lessThan)
            {
                count++;
            }
        }
        System.out.println((double) count / (double)  testTimes) ;
    }

    public static void proveRandomEqualZeroToKMinizeOneChance(int k)
    {

        // [ 0 , k) => [ 0 , k - 1 ]
        int[] counts = new int[k];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for(int i =0; i< k; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i]);
        }
    }

    public static void proveRandomEqualXToXPower2(float lessThan)
    {


        int count = 0;
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            if(xToXPower2() < lessThan)
            {
                count++;
            }
        }
        System.out.println((double) count / (double)  testTimes) ;
        System.out.println(Math.pow(lessThan , 2)) ;
//        System.out.println(1 - Math.pow( 1 - lessThan , 2)) ;
    }

    public static void provef2()
    {


        int testTimes = 10000000;
        int count = 0;
        for(int i = 0; i < testTimes; i++)
        {

            if(f2() == 0)
            {
                count++;
            }
        }
        System.out.println((double) count / (double)  testTimes) ;
    }
    public static void proveZeroToSeven()
    {

        // [ 0 , k) => [ 0 , k - 1 ]
        int k = 8;
        int[] counts = new int[k];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) f3_zeroToSeven();
            counts[ans]++;
        }
        for(int i =0; i< k; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i]);
        }
    }

    public static void proveZeroToSix()
    {

        // [ 0 , k) => [ 0 , k - 1 ]
        int k = 8;
        int[] counts = new int[k];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) f4_zeroToSix();
            counts[ans]++;
        }
        for(int i =0; i< k; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i]);
        }
    }

    public static void proveG()
    {

        // [ 0 , k) => [ 0 , k - 1 ]
        int k = 8;
        int[] counts = new int[k];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) g();
            counts[ans]++;
        }
        for(int i =0; i< k; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i]);
        }
    }

    // ====================

    // return [0, 1)'s decimal number
    // any x, x belong to [0,1); [0,x) range; random number chance from x to x^2
    public static double xToXPower2()
    {
        /*

            max(a,b):
                if, a: ![0, x): OUTSIDE x, then the condition does not match
                only when a: [0, x) && b: [0, x)

            - if use max,
                a: Math.random(), [0, x), =>  x
                b: Math.random(), [0, x), => x
                Math.max(a , b) => x^2
        */
        return Math.max(Math.random(), Math.random());
//        return Math.min(Math.random(), Math.random());
        /*
            - if use min,
                a: Math.random(), [0, x), => (1-x)
                b: Math.random(), [0, x), => (1-x)
                Math.min(a , b) => 1 - (1-x)^2
        */

        /*
            min{ a ,b } is to
                condition: a : 0-x; b: x => return 0-x (But this does not meet x^2), to let both random return 0-x to fit our requirement
                , then we think other way, if a: ![0,x) with chance: 1-x ; b: ![0,x) with chance: 1-x, then chance of ![0,x) at (1-x)^2
                , therefore, chance of [0,x) is to 1 - (1-x)^2 ...
         */
    }
    // return [0, 1)'s decimal number
    // any x, x belong to [0,1); [0,x) range; random number chance from x to x^3
    public static double xToXPower3()
    {
//        return Math.max(Math.random(), xToXPower2());
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }



    // fixed library in question, cant be modified
    public static int fCondition(){
        return (int) (Math.random() * 5) + 1;
    }

    public static int f2()
    {
        int ans = 0;
        do {
            ans = fCondition();
        }while(ans == 3);
        // 1,2 => 0,  3 => KEEP ROLLING, 4,5 => 1
        return ans < 3? 0: 1;
    }



    // to get 000~111, random chance is equal; therefore we can return 0 ~ 7 with equal chance
    public static int f3_zeroToSeven(){
        // - to have 0-7, we can think it on binary, to have 3 bits
        int ans = (f2() << 2) + (f2() << 1) + (f2() << 0) ;
//              location of 2; location of 1; location of 0
        return ans;
    }



    public static int f4_zeroToSix()
    {
        int ans = 0;
        do {
            ans = f3_zeroToSeven();
        }while(ans == 7);
        return ans;
    }
    public static int g()
    {

        return f4_zeroToSix() +1 ;
    }

    /*
        - question:
            - given f() on 3 ~ 19， find g() for 17 ~ 56
        - solution:
            f2(), if even number, then we do not need to middle set, so no looping
            f2() -- 3 ~ 19: have 19-3+1=17 numbers, we could separate 3 sets with 3~10:0 ;  11: KeepDoing; 12~17: 1     => same random rate of 0,1

            17 ~ 56: convert it to 0~(56-17=39), and find how many bits for 36, after all this we add the final function with 17
                        , then we need _ _ _ _ _ _, 0~1;0~3;0~7;0~15;0~31;0~63; so we need 6 bits for 39

            if rolling, > 39, reroll it.
     */

    // fixed library in question, cant be modified
    public static int fConditionT(int start, int end){
        return (int) (Math.random() * (end-start+1)) + start;
    }

    public static void provefConditionT(int start, int end)
    {

        // [ 0 , k) => [ 0 , k - 1 ]

        int N = end-start + 1;
        int[] counts = new int[N];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) fConditionT(start,end);
            counts[ans - start]++;
        }
        for(int i =0; i< N; i++)
        {
            System.out.println(i+start + ", this number, has occurrence: "+ counts[i]);
        }
    }

    public static int f2T(int start, int end)
    {
        // start ~ end
        int N = (end-start) + 1;
        int ans = 0;
        int mid = (start + end) / 2;
        if(N % 2 != 0)
        {
            do {
                ans = fConditionT(start,end);
            }while(ans == mid);
            // start ~ mid - 1 => 0;  mid => KEEP ROLLING; mid + 1 ~ end => 1
            return ans < mid? 0: 1;
        }
        else
        {
            // start ~ mid => 0; mid + 1 ~ end => 1
            return ans < mid? 0: 1;
        }
    }

    public static void provef2T(int start, int end)
    {


        int testTimes = 10000000;
        int count = 0;
        for(int i = 0; i < testTimes; i++)
        {

            if(f2T(start,end) == 0)
            {
                count++;
            }
        }
        System.out.println((double) count / (double)  testTimes) ;
    }


    public static int getBitsNeeds(int N)
    {
        int bitsNeeded = 0;

//        while ((1 << bitsNeeded) <= N) {
//            bitsNeeded++;
//        };

//        bitsNeeded = (int)(Math.floor(Math.log(N) / Math.log(2))) + 1;
        bitsNeeded = Integer.toBinaryString(N).length();
        return bitsNeeded;
    }

    public static int f3T(int start, int end){

        // to find how many bits to hold, 0 ~ (end - start)

        /*
             1 ~ 7 => 0 ~ 6

              _    _    _
             0~7  0~3  0~1  (so, we need 3 bits to cover 0 ~ 6)

             log2(7) = 2... ==  Math.floor(Math.log(N) / Math.log(2) == 2, but we need to add 1 to the final to cover 0 ~ 7, WE NEED 3 bits to cover 0 ~ 7

         */
        int N = end - start ;
        int bitsNeeded = getBitsNeeds(N);
        int ans = 0;

        do {
            ans = 0;
            for(int i =bitsNeeded; i >=0; i--)
            {
                ans += (f2() << i);
            }
        }while(ans > N); // when the generated randomized number larger than range 0 ~ 7 (0 ~ N), we dont take this number and reroll
//        do {
//            ans = (f2T(start,end) << 2) + (f2T(start,end) << 1) + (f2T(start,end) << 0) ;
//        }while(ans > N);

        return ans;
    }





    public static void provef3T(int start, int end)
    {
        int N = end-start + 1;
        int[] counts = new int[N];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) f3T(start,end);
            counts[ans]++;
        }
        for(int i =0; i< N; i++)
        {
            System.out.println(i+start + ", this number, has occurrence: "+ counts[i]);
        }
    }


    public static int gT(int start, int end)
    {

        return f3T(start,end) + start ;
    }

    public static void provegT(int start, int end)
    {
        int N = end-start + 1;
        int[] counts = new int[N];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) gT(start,end);
            counts[ans-start]++;
        }
        for(int i =start; i<= end; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i-start]);
        }
    }


    // In library, randomChanceNotEqual() will return 0;1 with fix,not equal random chance, And you can not see how this function works
    public static int randomChanceNotEqual()
    {
        return  Math.random() < 0.89? 0:1;
    }

    // to make it return 0,1 with equal random rate.
    // - by, using the randomChanceNotEqual() twice, 00,11=> Dont use ; 01 10=> Use it, with 01:P*(P-1); 10:P*(P-1), therefore 01;10 with equal chance
    public static int makeItToRandomEqualChanceFromRandomChanceNotEqual()
    {
        int ans =0;
        do {
            ans = randomChanceNotEqual();
        }while(ans == randomChanceNotEqual());

        return ans;
    }

    public static void provemakeItToRandomEqualChanceFromRandomChanceNotEqual()
    {
        int[] counts = new int[2];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) makeItToRandomEqualChanceFromRandomChanceNotEqual();
            counts[ans]++;
        }
        for(int i =0; i<2; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i]);
        }
    }

    public static int f3TNew(int start, int end){

        // to find how many bits to hold, 0 ~ (end - start)

        /*
             1 ~ 7 => 0 ~ 6

              _    _    _
             0~7  0~3  0~1  (so, we need 3 bits to cover 0 ~ 6)

             log2(7) = 2... ==  Math.floor(Math.log(N) / Math.log(2) == 2, but we need to add 1 to the final to cover 0 ~ 7, WE NEED 3 bits to cover 0 ~ 7

         */
        int N = end - start ;
        int bitsNeeded = getBitsNeeds(N);
        int ans = 0;

        do {
            ans = 0;
            for(int i =bitsNeeded; i >=0; i--)
            {
                ans += (makeItToRandomEqualChanceFromRandomChanceNotEqual() << i);
            }
        }while(ans > N); // when the generated randomized number larger than range 0 ~ 7 (0 ~ N), we dont take this number and reroll
//        do {
//            ans = (f2T(start,end) << 2) + (f2T(start,end) << 1) + (f2T(start,end) << 0) ;
//        }while(ans > N);

        return ans;
    }

    public static void provef3TNew(int start, int end)
    {
        int N = end-start + 1;
        int[] counts = new int[N];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) f3TNew(start,end);
            counts[ans]++;
        }
        for(int i =0; i< N; i++)
        {
            System.out.println(i+start + ", this number, has occurrence: "+ counts[i]);
        }
    }
    public static int gTNew(int start, int end)
    {

        return f3TNew(start,end) + start ;
    }

    public static void provegTNew(int start, int end)
    {
        int N = end-start + 1;
        int[] counts = new int[N];
        int testTimes = 10000000;
        for (int i =0; i < testTimes; i++)
        {
            int ans = (int) gTNew(start,end);
            counts[ans-start]++;
        }
        for(int i =start; i<= end; i++)
        {
            System.out.println(i + ", this number, has occurrence: "+ counts[i-start]);
        }
    }






    public static void main(String [] args)
    {
        System.out.println("Test Begin");
        // Math.random() -> double -> [ 0, 1 )
        // Because there is limited bits on computer, therefore, each number will have same chances to be selected

        proveRandomEqualChance(1, 0.7F);

        System.out.println("==========");

        // Math.random() -> double -> [ 0, 1 )
        double ans = Math.random();

        // Math.random() -> double -> [ 0, 1 ) * 8 -> [ 0, 8 )
        ans = Math.random() * 8;
        proveRandomEqualChance(8, 5F);
        System.out.println((double) 5 / (double)  8) ;


//        int k = ?;
//        // [ 0 , k)
//        double random = (Math.random() * k);
//        // [ 0 , k) => [ 0 , k - 1 ]
//        int randomToInt = (int)  (Math.random() * k);

        int k = 10;
        // [ 0 , k)
        double random = (Math.random() * k);
        // [ 0 , k) => [ 0 , k - 1 ]
        int randomToInt = (int)  (Math.random() * k);
        double randomToWithFloor = Math.floor( (Math.random() * k));
        System.out.println(randomToWithFloor);
        int randomToWithFloorToInt = (int) Math.floor( (Math.random() * k));
        System.out.println(randomToWithFloorToInt);
        System.out.println("==========");
        proveRandomEqualZeroToKMinizeOneChance(9); // equal random chances
        System.out.println("==========");
        proveRandomEqualXToXPower2(0.2F);

        proveRandomEqualXToXPower2(0.2F);

        System.out.println("==========");
        provef2();
        System.out.println("==========");
        proveZeroToSeven();
        System.out.println("==========");
        proveZeroToSix();
        System.out.println("==========");
        proveG();
        System.out.println("==========");
//        int fT = fConditionT(3,19);
        provefConditionT(1,7);
        provef2T(3,19);
        System.out.println("==========");
        provef3T(17,56);
        System.out.println("==========");
        provegT(17,56);
        System.out.println("==========");

        provemakeItToRandomEqualChanceFromRandomChanceNotEqual();

        System.out.println("==========");

        provef3TNew(17,56);

        System.out.println("==========");

        provegTNew(17,56);

        System.out.println("==========");



    }
}
