package org.exam.www;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @Description 字符流
 * @Author WJJ
 * @Date 2021/5/2 22:43
 **/
public class FileReadWriteTest {

    @Autowired
    ResourceLoader resourceLoader;

    /**
     * @Author WJJ
     * @Description  fileReader.read() 缺点是每次只能读取一个字符
     * @Date 1:06 2021/5/3
     * @Param
     * @return {@link null}
     */
    @Test
    public void testFileReader(){
        FileReader fileReader = null;
        try {

            Resource resource = new ClassPathResource("hello.txt");

            // 实例化File类对象，指明要操作的文件
            File file = resource.getFile();
            // 提供具体的流
            fileReader = new FileReader(file);

            // 数据的读入
            int data ;
            while((data = fileReader.read() ) != -1) {
                System.out.println((char)data);
            }
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @Author WJJ
     * @Description  fileReader.read(char[] cah) 一次读取多个字符
     * @Date 1:06 2021/5/3
     * @Param
     * @return {@link null}
     */
    @Test
    public void testFileReader1(){
        FileReader fileReader = null;
        try {

            Resource resource = new ClassPathResource("hello.txt");

            // 实例化File类对象，指明要操作的文件
            File file = resource.getFile();
            // 提供具体的流
            fileReader = new FileReader(file);
            char[] cha = new char[5];
            // 数据的读入
            int len ;
            while((len = fileReader.read(cha) ) != -1) {
               // 方式一: 循环
               /* for(int i = 0 ; i < len ; i++) {
                    System.out.print(cha[i]);
                }*/

               // 方式二 ： 将char转为String
               String str = new String(cha,0,len);
               System.out.print(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  从内存中写入数据到硬盘
     * */
    @Test
    public void testFileWrite(){
        FileWriter writer = null;
        try {
            //在开发测试模式时，得到地址为：{项目跟目录}/target/classes
           String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);

            File file = new File(path+"hello2.txt");

            writer = new FileWriter(file);

            writer.write("I have a dream\n");
            writer.write("you must be a dream111222");

        }catch (Exception e){
           e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件拷贝测试
     * */
    @Test
    public void copyTxt(){
        FileReader fileReader = null;
        FileWriter writer = null;
        try {

            Resource srcResource = new ClassPathResource("hello.txt");

            String path = ResourceUtils.getURL("classpath:").getPath();

            // 实例化File类对象，指明要操作的文件
            File srcFile = srcResource.getFile();
            File destFile = new File(path+"hello2.txt");
            // 提供具体的流
            fileReader = new FileReader(srcFile);
            writer = new FileWriter(destFile);
            char[] cha = new char[5];
            // 数据的读入
            int len ;
            while((len = fileReader.read(cha) ) != -1) {

                // 方式二 ： 将char转为String
                String str = new String(cha,0,len);
                writer.write(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
