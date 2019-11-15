package com.cloud.zhpt.Utils;

import com.cloud.zhpt.exception.CustomRunTimeException;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;
import java.io.*;
import java.net.URL;

/**
 * @ClassName VoiceUtils
 * @Description 语音播报Utils
 * @Author SW
 * @Date 2019/11/14 17:39
 **/
public class VoiceUtils {


    public static ActiveXComponent getSap() {
        // 拿到音响
        ActiveXComponent sap = new ActiveXComponent("sapi.SpVoice");
        return sap;
    }

    public static void read(String filePath) {
        ActiveXComponent sap = getSap();
        File file = new File(filePath);
//        if (file.length() == 0) {
//            throw new CustomRunTimeException(HttpStatus.INTERNAL_SERVER_ERROR.value()+"","文件为空，系统无法阅读");
//        }
        // 获取文本文档的内容
        try {
            FileReader flieReader = new FileReader(file);
            // 从缓存区拿到数据
            BufferedReader bf = new BufferedReader(flieReader);
            // 拿到缓冲区的数据
            String content = bf.readLine();

            System.err.println(content);

            // 调节语速 音量大小
            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));

            Dispatch xj = sap.getObject();
            // 执行朗读 没有读完就继续读
            while (content != null) {
                Dispatch.call(xj, "Speak", new Variant(content));
            }
            xj.safeRelease();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sap.safeRelease();
        }

    }


    public void readByFileName(String fileName) {
        ActiveXComponent sap = getSap();
        URL url = VoiceUtils.class.getClassLoader().getResource("test.txt");

        // 获取文本文档的内容
        try {
            File file = new File(url.getFile());

            FileReader flieReader = new FileReader(file);
            // 从缓存区拿到数据
            BufferedReader bf = new BufferedReader(flieReader);
            // 拿到缓冲区的数据
            String content;
            // 调节语速 音量大小
            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));

            Dispatch xj = sap.getObject();
            // 执行朗读 没有读完就继续读
            while ((content = bf.readLine()) != null) {
                Dispatch.call(xj, "Speak", new Variant(content));
                System.err.println(content);
            }
            xj.safeRelease();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sap.safeRelease();
        }

    }

    public static void main(String[] args) {
        VoiceUtils v = new VoiceUtils();
        v.readByFileName("test.txt");

    }
}
