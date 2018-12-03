package JavaCore.io.BIO;

import JavaCore.io.Content;
import JavaCore.io.Helper;

import java.io.*;

public class BIOHelper extends Content implements Helper {

    public String read() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(DIR);
            BufferedReader reader = new BufferedReader(fileReader);
            String str = null;
            // 使用 -1 判断会减少首字符
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public void write(String str) {
        FileWriter fileWriter = null;
        try {
            // append str by FileWriter is true
            fileWriter = new FileWriter(DIR, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(str);
            //  新增加一行
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
