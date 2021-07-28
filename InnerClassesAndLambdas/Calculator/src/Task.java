import java.util.ArrayList;
import java.util.List;

public class Task {
    public static class Triplet<N, E, S> {
        public N n;
        public E e;
        public S s;
        public Triplet(N n, E e, S s) {
            this.n = n;
            this.e = e;
            this.s = s;
        }

    }
    public static String result = "";
    public static void main(String[] args){
        Calculator c = new Calculator();
        List<Triplet<Double,Double,String>> t = new ArrayList<>();
        t.add(new Triplet<>(3.4,5.2,"+"));
        t.add(new Triplet<>(2.3,1.23,"-"));
        t.add(new Triplet<>(4.5,5.4,"*"));
        t.add(new Triplet<>(1.0,0.0,"/"));
        t.add(new Triplet<>(56.0,28.0,"/"));

        t.forEach(x -> result += (c.compute(x.n, x.e, x.s).toString()) + "\n");
        System.out.println(result);
    }
}