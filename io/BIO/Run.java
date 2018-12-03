package io.BIO;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {

        BIOHelper ioHelper = new BIOHelper();

        //写入
        ioHelper.write("school: hz");

        //读取
        System.out.println(ioHelper.read());

    }

}
