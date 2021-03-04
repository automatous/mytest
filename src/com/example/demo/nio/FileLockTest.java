package com.example.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileLockTest {

    static String source = "F:\\temp\\abc.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        RandomAccessFile raf = new RandomAccessFile(source, "rw");
        FileChannel fileChannel = raf.getChannel();
        /*
            将abc.txt中position=2，size=4的内容加锁（即只对文件的部分内容加了锁）。
            lock()第三个布尔参数的含义如下：
                true:共享锁。实际上是指“读共享”：某一线程将资源锁住之后，其他线程既只能读、
不能写该资源。
                false:独占锁。某一线程将资源锁住之后，其他线程既不能读、也不能写该资源。
         */
        //①
//        FileLock fileLock = fileChannel.lock(2, 4, true);
        FileLock fileLock = fileChannel.lock(2, 4, false);
//        FileLock fileLock = fileChannel.lock();
        System.out.println("main线程将abc.txt锁3秒...");
        System.out.println(Thread.currentThread().getName() + " lock is valid: " + fileLock.isValid());
        new Thread(
                () -> {
                    try {
                        byte[] bs = new byte[8];
                        //②新线程对abc.txt进行读操作
                        raf.read(bs, 0, 8);
                        System.out.println(Thread.currentThread().getName() + " read byte[" + (new String(bs)) + "]");
                        byte[] bytes = "cccccccccccccc".getBytes(StandardCharsets.UTF_8);
                        //③新线程对abc.txt进行写操作
                        raf.write("ccccccccc".getBytes(), 0, 8);
                        System.out.println(Thread.currentThread().getName() + " write byte[" + (new String(bytes)) + "]");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }).start();
        //模拟main线程将abc.txt锁3秒的操作
        Thread.sleep(3000);
        System.out.println("3秒结束，main释放锁");
        fileLock.release();
    }


//    public static void main(String[] args) throws Exception {
//        RandomAccessFile raf = new RandomAccessFile(source, "rw");
//        FileChannel fileChannel = raf.getChannel();
//        FileLock lock = fileChannel.lock(2, 4, true);
////        FileLock lock = fileChannel.lock(2, 4, false);
//        System.out.println(Thread.currentThread().getName() + " lock the file 3s....");
//        System.out.println(Thread.currentThread().getName() + " lock is valid: " + lock.isValid());
//        new Thread(() -> {
//            byte[] bs = new byte[8];
//            try {
//                raf.read(bs, 0, 8);
//                System.out.println(Thread.currentThread().getName() + " read byte[" + (new String(bs)) + "]");
//                byte[] bytes = "cccccccccccccc".getBytes(StandardCharsets.UTF_8);
//                raf.write(bytes, 0, 8);
//                System.out.println(Thread.currentThread().getName() + " write byte[" + (new String(bytes)) + "]");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        Thread.sleep(3000);
//        lock.release();
//        System.out.println(Thread.currentThread().getName() + " 3s end, unlock the file....");
//    }
}
