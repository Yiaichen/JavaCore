package javaDemo.io.NIO;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {

        NIOHelper nioHelper = new NIOHelper();

        nioHelper.write("22222");

        System.out.println(nioHelper.read());
    }

}
