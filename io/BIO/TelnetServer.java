package io.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Telnet 服务
 */
public class TelnetServer {

    /**
     * 执行对应链接的线程池
     */
    protected static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);

        while (true) {
            System.out.println("等待客户端链接...");
            final Socket socket = server.accept();
            System.out.println("客户端接入成功");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    /**
     * 处理接入的请求
     * @param socket
     */
    private static void handler(Socket socket) {
        InputStream inputStream = null;
        byte[] bytes = new byte[1024];
        try {
            inputStream = socket.getInputStream();
            System.out.println("数据接收...");
            while (inputStream.read(bytes) != -1) {
                System.out.println("接收数据： " + new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
