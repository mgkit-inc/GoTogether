package com.gotogether.unsafe;

@FunctionalInterface
public interface UnsafeCallable<T> {

    T call() throws Exception;

}
