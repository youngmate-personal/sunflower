package com.youngmat.threas;

/**
 * @author ZhaoYanqi
 * @date 2021/3/12 0012
 */
public class AlternatePrintCas {
    enum ReadyToRun {
        T1, T2
    };

    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {

        char[] num = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();
        new Thread(() -> {
            for (char c : num) {
                while (r != ReadyToRun.T1) {
                }
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : letters) {
                while (r != ReadyToRun.T2) {
                }
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();

    }
}
