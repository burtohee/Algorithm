package algorithm_1_starter._04_class04;

// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // can not be void function, must transfer head to new head

    /*

        first group: a....b
        reverse: b....a

        next group: c....d
        reverse: d....c

        b....a  ->  d....c

        next group: e....f
        reverse: f....e

        b....a  ->  d....c -> f...e

     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        /*
                a   ->  b   ->  c   ->  d   ->  e   ->  f   ->  g   ->  h ->    null
               head
         */
        /*
                a   ->  b   ->  c   ->  d   ->  e   ->  f   ->  g   ->  h ->    null
              start/head
         */
        ListNode start = head;

        /*
            k = 3

                a   ->  b   ->  c   ->  d   ->  e   ->  f   ->  g   ->  h ->    null
            start/head         end
         */
        ListNode end = getKGroupEnd(start, k);


        // e.g
        /*
            k = 3

                a   ->  b   ->  null
            start/head          end

            // cant even make more than 1 group
         */
        // only 1 set
        if (end == null) {
            return head;
        }


        // 第一组凑齐了！
        /*
            k = 3

                a   ->  b   ->  c   ->  d   ->  e   ->  f   ->  g   ->  h ->    null
            start             head/end

            Because, c  ->  b-> a->....

            so we want to return the first group head
         */


        head = end;
        /*
            k = 3
             start            head/end
                a   <-  b   <-  c       d   ->  e   ->  f   ->  g   ->  h ->    null
                |                       ^
                |-----------------------|
            Because, c  ->  b-> a->....

            so we want to return the first group head
         */
        // do not modify head
        reverse(start, end);
        // 上一组的结尾节点

        /*
            k = 3
           lastend/start     head/end
                a   <-  b   <-  c       d   ->  e   ->  f   ->  g   ->  h ->    null
                |                       ^
                |-----------------------|

            Because, c  ->  b   ->  a   ->  ....
         */
        ListNode lastEnd = start;


        /*
           k = 3
               lastend/start     head/end
                    a   <-  b   <-  c       d   ->  e   ->  f   ->  g   ->  h ->    null
                    |                       ^
                    |-----------------------|
                Because, c  ->  b-> a->....

        */
        while (lastEnd.next != null) {

            /*
                 k = 3
               lastend          head/end  start
                    a   <-  b   <-  c       d   ->  e   ->  f   ->  g   ->  h ->    null
                    |                       ^
                    |-----------------------|
                Because, c  ->  b-> a->....

             */
            start = lastEnd.next;



            /*
                 k = 3
               lastend             head    start           end
                    a   <-  b   <-  c       d   ->  e   ->  f   ->  g   ->  h ->    null
                    |                       ^
                    |-----------------------|

             */
            end = getKGroupEnd(start, k);
            // only 1.5 set
            if (end == null) {
                return head;
            }
             /*
                 k = 3
               lastend             head     start            end
                    a   <-  b   <-  c         d   <-  e   <-  f       g   ->  h ->    null
                    |                       ^  |                      ^
                    |-----------------------|  |----------------------|
                Because, f  ->  e -> d->....

             */
            // at least 2 set
            reverse(start, end);



            /*
                 k = 3
               lastend            head       start           end
                    |-----------------------------------------|
                    |                                         v
                    a   <-  b   <-  c         d   <-  e   <-  f       g   ->  h ->    null
                                              |                       ^
                                              |-----------------------|
                Because, f  ->  e -> d->....

             */

            lastEnd.next = end;

            /*
                 k = 3
                                  head    lastend/start      end

                    |-----------------------------------------|
                    |                                         v
                    a   <-  b   <-  c         d   <-  e   <-  f       g   ->  h ->    null
                                              |                       ^
                                              |-----------------------|
             */

            lastEnd = start;
        }
        return head;
    }


    /*
        -condition 1 (find all until k==0):

              x   -> a -> b -> c -> d -> ...    ; k=5
           (--k)4    3    2    1    0
                                    -
            return => d
     */
    /*
        -condition 2 (null condition):

              e   -> f -> g -> null             ; k=5
           (--k)4    3    2     1
                                -
            return => d
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /*
                .... ->    s   ->  a   ->  b   ->  c   ->  e   -> k...

          steps:
                .... ->    s   ->  null   ;         <- a   <-  b   <-  c   <-  e   ;  k...
                                                                                      - (remember k, before redirect e)

                 .... ->    s   ->  (point to k)   ;         <- a   <-  b   <-  c   <-  e   ;  k...
     */

    /*  input:
                .... ->    s   ->  a   ->  b   ->  e   -> k...
    */
    public static void reverse(ListNode start, ListNode end) {
        /*
                .... ->    s   ->  a   ->  b   ->  e   -> k...
                         start                    end     -
                                                         end(new)
        */
        end = end.next;
        /*
            prev = null
            next = null
            cur = start

                .... ->    s   ->  a   ->  b   ->  e   -> k...
                         start                    end     -
                                                         end(new)
        */
        ListNode pre = null;
        ListNode next = null;
        /*
            prev = null
            next = null
            cur = start

                .... ->    s   ->  a   ->  b   ->  e   -> k...
                         start                    end     -
                          cur                           end(new)
        */
        ListNode cur = start;
        while (cur != end) {
            /*
                prev = null
                next = cur.next
                cur = start

                    .... ->    s   ->  a   ->  b   ->  e   -> k...
                             start                    end     -
                              cur     next                  end(new)
            */
            next = cur.next;
            /*
                prev = null
                next = cur.next
                cur = start
                cur.next = prev

                    .... ->    s    -> null(pre)     ;  a   ->  b   ->  e   -> k...
                             start                                            end
                              cur                      next
            */
            cur.next = pre;
            /*
                prev = cur
                next = cur.next
                cur = start
                cur.next = prev

                    .... ->    s    -> null (pre)    ;  a   ->  b   ->  e   -> k...
                             start                                            end
                          cur/(new pre)                next
            */
            pre = cur;
            /*
                prev = cur
                next = cur.next
                cur = next
                cur.next = prev

                    .... ->    s    -> null          ;  a   ->  b   ->  e   -> k...
                             start                                            end
                              pre                     cur/next
            */
            cur = next;
        }
        /*
                prev =  (point to k)    <-  s   <-  a   <-  b   <-  e       ;   k....
                cur = k
                // nothing is after e

                .... ->  s   <-  a   <-  b   <-  e       ;   k....
                         |                                   ^
                         |-----------------------------------| (point to k)
                                                prev
            */
        start.next = end;
    }



}
