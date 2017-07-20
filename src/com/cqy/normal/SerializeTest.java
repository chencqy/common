package com.cqy.normal;

import java.io.*;

/**
 * Created by Richard Chen on 2017/7/20.
 * 关于java序列化
 */
public class SerializeTest implements Serializable{
    private static final long serializeVerisonUID = -6849794470754660011L;
    public int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("d:/serialize.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            SerializeTest serialize = new SerializeTest();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
