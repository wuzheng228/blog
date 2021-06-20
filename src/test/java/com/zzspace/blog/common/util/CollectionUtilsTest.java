package com.zzspace.blog.common.util;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by 76973 on 2021/6/19 21:43
 */
public class CollectionUtilsTest {
    @Test
    public void CollectionUtilsTest() {
        List<Integer> origin = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> toRemove = Arrays.asList(2, 3, 4, 8);
        Collection<Integer> integers = CollectionUtils.removeAll(origin, toRemove);
        System.out.println(integers);
        System.out.println(origin);
        Collection<Integer> integers1 = CollectionUtils.removeAll(toRemove, origin);
        System.out.println(integers1);
    }
}
