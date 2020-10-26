package design.decorate;

/**
 * 描述
 *
 * @author vayi
 * @version 1.0
 * @date 2020/10/26
 */
public class Run {

    /**
     * 写入流程: 获取到data -> CompressionDecorator进行压缩 -> EncryptionDecorator进行加密 -> FileDataSource写入文本
     * 读取流程: FileDataSource读取文本内容 -> EncryptionDecorator进行解密 -> CompressionDecorator进行解压
     */
    public static void main(String[] args) {
        String salaryRecords = "加解密逆向解码\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码" +
                "\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码\n加解密逆向解码";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }

}
