package com.likelion.hospital.parser;

public interface Parser<T> {
    T parse(String str);
}
