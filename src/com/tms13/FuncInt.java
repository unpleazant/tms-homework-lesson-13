package com.tms13;

@FunctionalInterface
public interface FuncInt<T> {

    T getValue(T var);

}