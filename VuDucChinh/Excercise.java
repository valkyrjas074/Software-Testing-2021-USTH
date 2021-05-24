import java.util.*;
import java.lang.*;


public class Excercise {
    public static Vector union (Vector a, Vector b) {
        Vector result = new Vector (a); // get all of a’s elements
        for (Object obj : b) {
            if (!a.contains(obj)) {
                result.add(obj);
            }
        }
        return result;
    }
    public static int finLast(int[] x, int y)
    {
        for (int i = x.length - 1;i>=0;i--)
            if (x[i] == y)
            {
                return i;
            }
        return -1;
    }

    public  static int lastZero (int[]x)
    {
        for (int i = x.length - 1;i>=0;i--)
        {
            if (x[i]==0)
            {
                return i;
            }
        }
        return -1;
    }


    public static int countPositive(int[]x)
    {
        int count = 0;
        for (int i = 0;i < x.length;i++)
        {
            if (x[i] > 0)
            {
                count++;
            }
        }
        return count;
    }

    public static int oddOrPos(int[]x)
    {
        int count = 0;
        for(int i = 0;i < x.length;i++)
        {
            if (Math.abs(x[i]%2)==1 || x[i] > 0)
            {
                count++;
            }
        }
        return count;
    }
    public static void main (String[] args){
        int[] x = {2,3,5};
        int y = 2;
        System.out.println("finLast method result :"+finLast(x , y));

        int[] zero = {0,2,0};
        System.out.println("lastZero method result :"+lastZero(zero));

        int[] pos = {-4,2,0,2};
        System.out.println("countPositive method result :"+countPositive(pos));

        int[] oddOrPos = {-3,-2,0,1,4};
        System.out.println("oddOrPos method result :"+oddOrPos(oddOrPos));
    }
}