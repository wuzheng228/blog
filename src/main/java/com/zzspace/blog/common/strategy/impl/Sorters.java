package com.zzspace.blog.common.strategy.impl;

import com.zzspace.blog.common.strategy.Sorter;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 76973 on 2021/6/12 21:14
 */
public enum Sorters implements Sorter {
    TOPK_PRIORITI_QUEUE() {
        @Override
        public <E extends Comparable<E>> List<E> topK(List<E> list, int k, String mode) {
            PriorityQueue<E> minQueue = new PriorityQueue<>();
            for (E e : list) {
                if (minQueue.size() < k) {
                    minQueue.offer(e);
                } else if (minQueue.size() != 0 && e.compareTo(minQueue.peek()) > 0) {
                    minQueue.poll();
                    minQueue.offer(e);
                }
            }
            List<E> ans = new ArrayList<>();
            while (minQueue.size() > 0) { // 这里一定要循环取出来
                ans.add(minQueue.poll());
            }
            if (mode != null && mode.equals(Sorter.DESC))
                Collections.reverse(ans);
            return ans;
        }
    };

    public static void main(String[] args) {
        List<Integer> strings = TOPK_PRIORITI_QUEUE.topK(Arrays.asList(0,6,0,0,0,0,0,0,0), 5, null);
        System.out.println(strings);
    }
}
