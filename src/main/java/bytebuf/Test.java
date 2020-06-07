package bytebuf;

public class Test {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int a = max + 1;
        System.out.println(max + " " + (a == min)+" "+min);
        System.out.println(1 > (max + 1));
    }
}
