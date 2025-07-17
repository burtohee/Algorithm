package LeetCodeHome.LeetCode75;

public class Code11_443_String_Compression {

    public int compress(char[] chars) {

        int write = 0, read = 0, n = chars.length;

        while (read < n) {
            char current = chars[read];
            int count = 0;

            // Count consecutive duplicates
            while (read < n && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character, move the write pointer to next write position
            chars[write++] = current;

            // If more than one, write count as characters
            if (count > 1) {
                String cntStr = String.valueOf(count);
                for(char c : cntStr.toCharArray())
                {
                    chars[write++] = c;
                }
            }


        }

        return write;

//          i
//               insert
//        ["a","a","b","b","c","c","c"]

//                group = 2
//        ["a","a","b","b","c","c","c"]

    }

}
