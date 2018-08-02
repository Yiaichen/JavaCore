package javaDemo.io.NIO;

import javaDemo.io.Content;
import javaDemo.io.Helper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOHelper extends Content implements Helper {

    public String read() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        RandomAccessFile accessFile = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            accessFile = new RandomAccessFile(DIR, "rw");
            FileChannel inChannel = accessFile.getChannel();
            int bytesRead = 0;
            bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("bytesRead: " + bytesRead);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    stringBuilder.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public void write(String str) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileOutputStream accessFile = null;
        try {
            accessFile = new FileOutputStream(DIR, true);
            FileChannel inChannel = accessFile.getChannel();
            str += "\n";
            buffer.put(str.getBytes());
            buffer.flip();
            inChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
