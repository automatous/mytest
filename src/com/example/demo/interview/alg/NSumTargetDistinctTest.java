package com.example.demo.interview.alg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSumTargetDistinctTest {


    @Test
    public void testNSum() {
//        int[] nums = {-1, 0, 1, 2, -1, 4};
        int[] nums = {1, 1, 1, 2, 2, 3, 3};
        for (int i = 2; i <= 4; i++) {
//            List<List<Integer>> lists = nSumDistinctTarget(nums, i, 0);
            List<List<Integer>> lists = nSumDistinctTarget(nums, i, 4);
            System.out.println(lists);
            System.out.println();
        }
    }


    /**
     * 预处理: 有效性校验 & 排序
     */
    public static List<List<Integer>> nSumDistinctTarget(int[] a, int n, int target) {
        if (a == null || a.length < n || n < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(a);
        return nSumDistinctTarget(a, n, 0, target);
    }


    /**
     * 数组a必须是排好序的数组a, 需要有预处理阶段
     */
    public static List<List<Integer>> nSumDistinctTarget(int[] a, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = a.length;
        if (length < n || n < 2) {
            return res;
        }

        // 剪枝
        if (a[start] > target) {
            return res;
        }

        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int sum = a[lo] + a[hi];
                int left = a[lo], right = a[hi];
                if (sum < target) {
                    while (lo < hi && a[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && a[hi] == right) {
                        hi--;
                    }
                } else {
                    res.add(Arrays.asList(a[lo], a[hi]));
                    while (lo < hi && a[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && a[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = start; i < length - n + 1; i++) {
                List<List<Integer>> sub = nSumDistinctTarget(a, n - 1, i + 1, target - a[i]);
                int t = a[i];
                sub.forEach(arr -> {
                    List<Integer> ss = new ArrayList<>(arr);
                    ss.add(t);
                    res.add(ss);
                });
                while (i < length - n + 1 && a[i] == t) {
                    i++;
                }
            }
        }

        return res;
    }

//    public static List<List<Integer>> threeSumDistinctTarget(int[] a, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(a);
//        int length = a.length;
//        for (int i = 0; i < length - 2; i++) {
//            List<List<Integer>> tuples = twoSumDistinctTarget(a, i + 1, target - a[i]);
//            int t = a[i];
//            tuples.forEach(tuple -> {
//                List<Integer> subList = new ArrayList<>(tuple);
//                subList.add(t);
//                res.add(subList);
//            });
//            while (i < length && a[i] == t) {
//                i++;
//            }
//        }
//        return res;
//    }


    /**
     * 数组a必须是排好序的数组a
     */
//    public static List<List<Integer>> twoSumDistinctTarget(int[] a, int start, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        int lo = start, hi = a.length - 1;
//        while (lo < hi) {
//            if (a[lo] > target) {
//                break;
//            }
//            int sum = a[lo] + a[hi];
//            int left = a[lo], right = a[hi];
//            if (sum < target) {
//                while (lo < hi && a[lo] == left) {
//                    lo++;
//                }
//            } else if (sum > target) {
//                while (lo < hi && a[hi] == right) {
//                    hi--;
//                }
//            } else {
//                res.add(Arrays.asList(a[lo], a[hi]));
//                while (lo < hi && a[lo] == left) {
//                    lo++;
//                }
//                while (lo < hi && a[hi] == right) {
//                    hi--;
//                }
//            }
//        }
//        return res;
//    }

//    public static List<List<Integer>> twoSumDistinctTarget(int[] a, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(a);
//        int lo = 0, hi = a.length - 1;
//        while (lo < hi) {
//            if (lo > target) {
//                break;
//            }
//            int sum = a[lo] + a[hi];
//            int left = a[lo], right = a[hi];
//            if (sum < target) {
//                while (lo < hi && a[lo] == left) {
//                    lo++;
//                }
//            } else if (sum > target) {
//                while (lo < hi && a[hi] == right) {
//                    hi--;
//                }
//            } else {
//                res.add(Arrays.asList(lo, hi));
//                while (lo < hi && a[lo] == left) {
//                    lo++;
//                }
//                while (lo < hi && a[hi] == right) {
//                    hi--;
//                }
//            }
//        }
//        return res;
//    }


    public static List<Integer> twoSum(int[] a, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            // 剪枝
            if (a[lo] > target) {
                break;
            }
            int sum = a[lo] + a[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                res.add(lo);
                res.add(hi);
                return res;
            }
        }
        return res;
    }

}
