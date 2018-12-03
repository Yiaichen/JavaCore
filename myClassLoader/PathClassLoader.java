package myClassLoader;

import java.io.*;

/**
 * 未完成
 */
public class PathClassLoader extends ClassLoader {

    private String classPath;

    public PathClassLoader(String classPath) {
        this.classPath = classPath;
    }

    protected Class<?> findClass(String className) throws ClassNotFoundException {
        if ("myClassLoader".startsWith(className)) {
            byte[] classData = getData(className);
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(className, classData, 0, classData.length);
            }
        } else {
            return super.loadClass(className);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            try {
                while ((num = is.read(buffer)) != -1) {
                    stream.write(buffer, 0, num);
                }
                return stream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
