package org.exam.www;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/5/2 23:01
 **/
public class FileReadWriteTest {
    public static void main(String[] args) {

    }

    @Test
    public void testFileReader(){
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");

            fileReader = new FileReader(file);
            int data ;
            while ((data =fileReader.read()) != -1) {
                System.out.println((char)data);
            }

        }catch (Exception e){
           e.printStackTrace();
        }finally {
           if(fileReader != null) {
               try {
                   fileReader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

    }
}
