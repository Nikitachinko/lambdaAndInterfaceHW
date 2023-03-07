package Lambda;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        System.out.println("Задача 1");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer >= 0) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(predicate.test(-5));
        System.out.println(predicate.test(5));

        Predicate<Integer> predicate1 = x -> x >= 0;
        System.out.println(predicate1.test(5));
        System.out.println(predicate1.test(-5));
    }

    public static void task2() {
        Consumer<Name> consumer = new Consumer<Name>() {
            @Override
            public void accept(Name name) {
                System.out.println("Hi! " + name.getName());
            }
        };
        consumer.accept(new Name("Nikita"));

        Consumer<Name> consumer1 = name -> System.out.println("Hi! " + name.getName());
        consumer1.accept(new Name("Dasha"));

    }

    public static void task3() {
        System.out.println("Задача 3");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double a) {
                return Math.round(a);
            }
        };

        System.out.println(function.apply(7.5));

        Function<Double, Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(9.37));
    }

    public static void task4() {
        System.out.println("Задача 4");
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Integer integer = (int) (Math.random() * 100);
                return integer;
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println(supplier1.get());
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (T x) -> {
            if (condition.test(x)) {
                return ifTrue.apply(x);
            } else
                return ifFalse.apply(x);
        };
    }

}



