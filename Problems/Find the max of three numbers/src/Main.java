import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        int position = 1;

            if(a >= b){
                if(a >= c){
                    return 1;
                }if(a < c){
                    position = 3;
                }
            }else if(b >= c){
                position = 2;
            }else {
                position = 3;
            }

        return position;
    }

    public static void method(float f) {
        System.out.println("float");
    }

    public static void method(int i) {
        System.out.println("int");
    }

    public static void method(double d) {
        System.out.println("double");
    }

    public static void main(String[] args) {

        method(10.2f);
    }
}