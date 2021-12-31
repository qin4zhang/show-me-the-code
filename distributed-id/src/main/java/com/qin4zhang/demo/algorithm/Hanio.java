package com.qin4zhang.demo.algorithm;

/**
 * 汉诺塔
 * <p>
 * 3根柱子，分别为x,y,x
 *
 * @author zhangzhen
 * @date 2021/11/11 下午1:36
 **/
public class Hanio {

    /**
     * 其中 x 柱子上面有从小叠到大的 n 个圆盘
     * <p>
     * 将n个盘子，从x移动到z
     * <p>
     * 要求是，每次只能移动一个盘子，且大盘子不能被放在小盘子上面
     * <p>
     * n越大，表示盘子越大
     *
     * @param n
     * @param x
     * @param y
     * @param z
     */
    private void hanio(int n, String x, String y, String z) {
        if (n < 1) {
            System.out.println("汉诺塔层数不能小于1");
        } else if (n == 1) {
            System.out.println("盘子 [" + n + "] 从 [" + x + "] 移动到 [" + z + "]");
            return;
        } else {
            hanio(n - 1, x, z, y);
            System.out.println("盘子 [" + n + "] 从 [" + x + "] 移动到 [" + z + "]");
            hanio(n - 1, y, x, z);
        }
    }

    public static void main(String[] args) {
        Hanio hanio = new Hanio();
        hanio.hanio(64, "x", "y", "z");
    }
}
