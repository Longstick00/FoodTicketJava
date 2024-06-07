package util;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T handle(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handle(supplier);
        }
    }

    public static void handle(final Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handle(runnable);
        }
    }


    public static <T, R> R handle(final Function<T, R> function, final T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handle(function, input);
        }
    }
}
