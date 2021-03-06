package com.github.tomakehurst.wiremock.common;

import org.junit.Test;

import static com.github.tomakehurst.wiremock.common.ArrayFunctions.concat;
import static org.junit.Assert.*;

public class ArrayFunctionsTest {

    private final Integer[] empty = new Integer[0];

    @Test
    public void concatEmptyAndEmpty() {
        assertArrayEquals(empty, concat(empty, empty));
    }

    @Test
    public void concatNonEmptyAndEmpty() {
        Integer[] first = {1, 2};

        Integer[] result = concat(first, empty);
        assertArrayEquals(new Integer[] { 1, 2 }, result);

        first[0] = 10;
        assertArrayEquals(new Integer[] { 1, 2 }, result);
    }

    @Test
    public void concatEmptyAndNonEmpty() {
        Integer[] second = {1, 2};

        Integer[] result = concat(empty, second);
        assertArrayEquals(new Integer[] { 1, 2 }, result);

        second[0] = 10;
        assertArrayEquals(new Integer[] { 1, 2 }, result);
    }

    @Test
    public void concatNonEmptyAndNonEmpty() {
        Integer[] first = {1, 2};
        Integer[] second = {3, 4};

        Integer[] result = concat(first, second);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);

        first[0] = 10;
        second[0] = 30;
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);
    }
}
