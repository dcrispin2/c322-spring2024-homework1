package part2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {

    @Test
    void problem1() {
        int[][] numlist = {{1, 2, 3, 4, 5}, {1, 10, -4}, {6, 5, 4, 3}};
        int[] targetlist = {3, 6, 8};
        int[][] expectedlist = {{1, 2}, {10, -4}, {5, 3}};

        assertArrayEquals(expectedlist[0], Problems.problem1(numlist[0], targetlist[0]));
        assertArrayEquals(expectedlist[1], Problems.problem1(numlist[1], targetlist[1]));
        assertArrayEquals(expectedlist[2], Problems.problem1(numlist[2], targetlist[2]));
    }

    @Test
    void problem2() {
        int[] numlist2 = {12321, 1111, 1451, 14551, -111};
        boolean[] expectedlist2 = {true, true, false, false, false};
        for (int i = 0; i < numlist2.length; i++){
            assertEquals(expectedlist2[i], Problems.problem2(numlist2[i]));
        }
    }

    @Test
    void problem3() {
        String[][] p3input = {{"string", "open", "door"}, {}, {"door", "", "open"}, {"corridor", "collide", "contaminate"}};
        String[] p3expect = {"", "", "", "co"};

        assert(p3expect[0].equals(Problems.problem3(p3input[0])));
        assert(p3expect[1].equals(Problems.problem3(p3input[1])));
        assert(p3expect[2].equals(Problems.problem3(p3input[2])));
        assert(p3expect[3].equals(Problems.problem3(p3input[3])));
    }

    @Test
    void problem4() {
        assertEquals(1994, Problems.problem4("MCMXCIV"));
        assertEquals(58, Problems.problem4("LVIII"));
        assertEquals(3, Problems.problem4("III"));
        assertEquals(0, Problems.problem4(""));
    }

    @Test
    void problem5() {
        assertEquals(Problems.problem5("({[]}{})"), true);
        assertEquals(Problems.problem5("()"), true);
        assertEquals(Problems.problem5("()[]{}"), true);
        assertEquals(Problems.problem5("({[)}{})"), false);
        assertEquals(Problems.problem5("[{[]}{})"), false);
        assertEquals(Problems.problem5("[[[[["), false);
        assertEquals(Problems.problem5("]]]]]"), false);
        assertEquals(Problems.problem5("["), false);
        assertEquals(Problems.problem5("]"), false);
    }

    @Test
    void problem6() {
        LinkedList<Integer> llist1 = new LinkedList<>();
        llist1.add(1);
        llist1.add(2);
        llist1.add(3);

        LinkedList<Integer> llist2 = new LinkedList<>();
        llist2.add(2);
        llist2.add(2);
        llist2.add(4);

        LinkedList<Integer> tlist = new LinkedList<>();
        tlist.add(1);
        tlist.add(2);
        tlist.add(2);
        tlist.add(2);
        tlist.add(3);
        tlist.add(4);

        assertEquals(tlist, Problems.problem6(llist1, llist2));
    }

    @Test
    void problem7() {
        int[] p7test1 = {1, 5, 6, 0};
        int[] p7expect1 = {1, 5, 6, 1};
        int[] p7test2 = {1, 5, 6, 9};
        int[] p7expect2 = {1, 5, 7, 0};
        int[] p7test3 = {1};
        int[] p7expect3 = {2};
        int[] p7test4 = {1, 9, 9, 9};
        int[] p7expect4 = {2, 0, 0, 0};

        assertArrayEquals(p7expect1, Problems.problem7(p7test1));
        assertArrayEquals(p7expect2, Problems.problem7(p7test2));
        assertArrayEquals(p7expect3, Problems.problem7(p7test3));
        assertArrayEquals(p7expect4, Problems.problem7(p7test4));
    }
}