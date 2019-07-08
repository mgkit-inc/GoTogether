package com.gotogether.unsafe;

@FunctionalInterface
public interface UnsafeFunction<K, V> {

    V apply(K k) throws Exception;

}
