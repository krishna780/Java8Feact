package Application.Chapter1;

public class Test {

        int test_a, test_b;
        Test(int a, int b)
        {
            test_a = a;
            test_b = b;
        }

    public Test() {

    }


    public static void main (String args[])
        {
            Test test = new Test();
            System.out.println(test.test_a+" "+test.test_b);
        }
    }
