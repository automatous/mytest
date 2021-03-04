package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOSendFile {

    static String source = "E:\\temp\\source.exe";  // 发射器
    static String sink = "F:\\temp\\target.exe";    // 汇集

    public static void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outFileChannel = FileChannel.open(Paths.get(sink), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        SocketChannel sChannel = serverSocketChannel.accept();
        System.out.println("connect success....");
        long start = System.currentTimeMillis();
        int size = 1 << 23;
        ByteBuffer buf = ByteBuffer.allocate(size);
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outFileChannel.write(buf);
            buf.clear();
        }
        System.out.println("accept success....");
        sChannel.close();
        outFileChannel.close();
        serverSocketChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("server accept file time spend: " + (end - start));
    }

    public static void client() throws IOException {
        FileChannel inFileChannel = FileChannel.open(Paths.get(source), StandardOpenOption.READ);
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        int size = 1 << 23;
        ByteBuffer buffer = ByteBuffer.allocate(size);
        long start = System.currentTimeMillis();
        while (inFileChannel.read(buffer) != -1) {
            buffer.rewind();
            socketChannel.write(buffer);
            buffer.clear();
        }
        inFileChannel.close();
        socketChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("client send file time spend: " + (end - start));
    }

    public static void client2() throws IOException {
        FileChannel inFileChannel = FileChannel.open(Paths.get(source));
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        long start = System.currentTimeMillis();
        inFileChannel.transferTo(0, inFileChannel.size(), socketChannel);
        inFileChannel.close();
        socketChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("client2 send file time spend: " + (end - start));
    }

    public static void main(String[] args) throws IOException {
        client();
//        client2();
    }

}
