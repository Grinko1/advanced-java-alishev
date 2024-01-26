package org.example.lambda;

interface Executable {
    int execute(int x, int y);

}

class Runner {
    public void run(Executable e) {
        System.out.println(e.execute(5, 5));
    }
}

class ExecutableImplementation implements Executable {
    @Override
    public int execute(int x, int y) {
        return x + y;
    }
}

public class Test {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new ExecutableImplementation());

        int a = 1;
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                int a =2;
                return y + x;
            }
        });


        runner.run((x, y) -> y + x );
    }
}
