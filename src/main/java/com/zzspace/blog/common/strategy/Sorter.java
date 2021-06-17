package com.zzspace.blog.common.strategy;

import java.util.List;

/**
 * Created by 76973 on 2021/6/12 21:12
 */
public interface Sorter {
    String DESC = "DESC";
    String ASC = "ASC";
    <E extends Comparable<E>> List<E> topK(List<E> list, int k, String mode);
}
