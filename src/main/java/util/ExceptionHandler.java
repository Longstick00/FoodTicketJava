package util;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handle(supplier);
        }
    }

    public static <T, R> R handle(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handle(function, input);
        }
    }
}
