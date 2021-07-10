package com.example.demo.alg;

import org.junit.jupiter.api.Test;

/**
 * https://blog.csdn.net/weixin_43128682/article/details/102770679?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.vipsorttest&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.vipsorttest
 */
public class FloatTest {
    /**
     * 从1-0.9不等于0.1说起——计算机中的浮点数
     *
     * KeeponGoing1 2019-10-27 21:11:25  1016  收藏 2
     * 文章标签： 浮点数 Java IEEE-754
     * 版权
     *   初学Java时，在关于浮点数的各种资料中都会看到类似的说明：“浮点数在计算时极易产生微小的误差”，“在要求绝对精确的业务场景下，禁止使用浮点数计算”等等。可以做一个最简单的验证：
     *
     * System.out.println("1-0.9f="+(1-0.9f));
     * 1
     *   控制台输出：
     *
     * 1-0.9f=0.100000024
     *
     *   本文主要说明两个问题：
     *
     * 为什么浮点数在计算中不精确？
     * 浮点数的优缺点及应用思路
     * 一、为什么浮点数在计算中不精确？
     *   《The Java® Language Specification（Java语言规范）》JavaSE8版中明确提到，浮点数float和double符合IEEE-754标准的单精度32位和双精度64位格式。
     *
     * 4.2.3. Floating-Point Types, Formats, and Values
     * The floating-point types are float and double, which are conceptually associated with the single-precision 32-bit and double-precision 64-bit format IEEE 754 values and operations as specified in IEEE Standard for Binary Floating-Point Arithmetic, ANSI/IEEE Standard 754-1985 (IEEE, New York).
     *
     * Oracle官方文档-《The Java® Language Specification》Java SE 8 Edition
     * IEEE-754标准文件
     *
     * 浮点数的二进制表示
     *   按照IEEE-754标准，以32位浮点数（float）为例，从高位到低位依次为：符号位（1位）+阶码位（8位）+尾数位（23位），实际浮点数值为：
     * ± 尾 数 ∗ 2 阶 码 \pm 尾数*2^{阶码}
     * ±尾数∗2
     * 阶码
     *
     *
     * 符号位：0表示正数，1表示复数；
     * 阶码位：阶码位存储的是指数对应的“移码”，即把实际值在数轴上正向平移后得到的，平移值为：
     * 2 阶 码 长 度 − 1 − 1 2^{阶码长度-1}-1
     * 2
     * 阶码长度−1
     *  −1
     *
     * 对于float型，移码=指数+127；
     * 尾数位：因为2进制浮点数有效数字小数点前一定为1，所以尾数位存储的是有效数字小数点后的原码；
     *
     * 解析1-0.9f=0.100000024计算过程
     *   然后回到我们最开始的问题，调用floatToIntBits方法就可以输出浮点数的实际存储值
     *
     * System.out.println("1f的16进制存储值为："+Integer.toHexString(Float.floatToIntBits(1f)));
     * System.out.println("-0.9f的16进制存储值为："+Integer.toHexString(Float.floatToIntBits(-0.9f)));
     * 1
     * 2
     *   控制台输出：
     *
     * 1f的16进制存储值为：3f800000
     * -0.9f的16进制存储值为：bf666666
     *
     *   转换为二进制为：
     *   1f：0011-1111-1000-0000-0000-0000-0000-0000
     *   -0.9f：1011-1111-0110-0110-0110-0110-0110-0110
     *
     *   1-0.9f计算，尾数的补码按阶码对齐后相加，计算结果的完整二进制为：
     *   0111-1011-0100-1100-1100-1100-1101-0000
     *   即0.100000024
     *
     * 二、这样设计的优点和缺点
     *   综上，可以这样理解，浮点数的计算误差的产生，是因为指数使用了2作为底数，许多10进制下常见的有限小数（例如0.1，0.9）转换后的二进制有效数字是无限循环小数，尾数位存储时做了截断。
     *   使用以10为底的指数表示就可以避免这种误差，Java中提供了BigDecimal类实现此功能，属性intVal存储不带小数点的有效数字，属性scale存储小数点的位置。
     *   相比于BigDecimal，浮点数这样设计的优点在于计算速度，以2作为底数，在浮点数计算时，尾数对齐就可以通过位移阶码的差值来实现，相比于BigDecimal中乘以10的n次方要快很多。通过下面的简单测试可以看到，耗时有数十倍的差别。
     *
     * float result;
     * long startTime = System.nanoTime();
     * for (int i = 0; i < 100; i++) {
     * 	result = 1-0.9f;
     * }
     * long endTime = System.nanoTime();
     * System.out.println("使用float计算“1-0.9”消耗时间："+(endTime-startTime)+"ns");
     *
     * BigDecimal bigDecimalResult;
     * BigDecimal bigDecimalAdd1 = new BigDecimal(new BigInteger("1"), 0);
     * BigDecimal bigDecimalAdd2 = new BigDecimal(new BigInteger("-9"), 1);
     * startTime = System.nanoTime();
     * for (int i = 0; i < 100; i++) {
     * 	bigDecimalResult = bigDecimalAdd1.add(bigDecimalAdd2);
     * }
     * endTime = System.nanoTime();
     * System.out.println("使用BigDecimal计算“1-0.9”消耗时间："+(endTime-startTime)+"ns");
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     * 10
     * 11
     * 12
     * 13
     * 14
     * 15
     * 16
     * 17
     *   控制台输出：
     *
     * 使用float计算“1-0.9”消耗时间：4100ns
     * 使用BigDecimal计算“1-0.9”消耗时间：172200ns
     *
     *   而缺点就在于“误差”，这种误差在业务数据处理中是不可接受的。好在实际业务场景中浮点数的有效数字通常不会太长，可以使用整型存储最小单位的值，例如人民币以“分”为单位存储，这样兼顾计算速度与精确性。
     * ————————————————
     * 版权声明：本文为CSDN博主「KeeponGoing1」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/weixin_43128682/article/details/102770679
     * @param args
     */
    public static void main(String[] args) {
        float f1 = 1.0f;
        float f2 = 0.1f;
        System.out.println("1-0.9f="+(1-0.9f));
        System.out.println("1f的16进制存储值为："+Integer.toHexString(Float.floatToIntBits(1f)));
        System.out.println("-0.9f的16进制存储值为："+Integer.toHexString(Float.floatToIntBits(-0.9f)));
    }


    @Test
    public void test02() {
        int n = 10;
        double[] a;
        a = new double[n];
        for (double v : a) {
            System.out.println(v);
        }
    }


    @Test
    public void test01() {
        double d = (int) 11.99 * 0.25;
        System.out.println(d);
    }

    @Test
    public void test00() {
        double a = 3.141;
        double b = 2.0;
        double c = a - b;
        System.out.println(c);
    }
}
