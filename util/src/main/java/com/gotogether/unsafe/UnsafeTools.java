package com.gotogether.unsafe;

import java.util.Optional;
import java.util.function.Function;

public class UnsafeTools {

    public static void run(UnsafeRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            sneakyThrow(e);
        }
    }

    public static void quietRun(UnsafeRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception ignored) {

        }
    }

    public static <T> T call(UnsafeCallable<T> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            return sneakyThrow(e);
        }
    }

    public static <T> Optional<T> optionalCall(UnsafeCallable<T> callable) {
        try {
            return Optional.of(callable.call());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static <K, V> V apply(UnsafeFunction<K, V> function, K k) {
        try {
            return function.apply(k);
        } catch (Exception e) {
            return sneakyThrow(e);
        }
    }

    public static <K, V> Function<K, ? extends V> wrap(UnsafeFunction<K, V> function) {
        return k -> UnsafeTools.call(() -> function.apply(k));
    }

    public static <T> T sneakyThrow(Throwable e) {
        return UnsafeTools._sneakyThrow(e);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Throwable, T> T _sneakyThrow(Throwable t) throws E {
        throw (E) t;
    }

}
