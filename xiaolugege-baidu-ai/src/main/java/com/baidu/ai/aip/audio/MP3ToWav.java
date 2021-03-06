
/**   
  * @文件名: MP3ToWav.java 
  * @包 com.baidu.ai.aip.audio 
  * @描述: TODO(用一句话描述该文件做什么) 
  * @作者：xushaunglu   
  * @创建时间 2019年8月12日 下午6:59:14 
  * @版本 V2.1  
  */
package com.baidu.ai.aip.audio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

public class MP3ToWav {
	
	   //设置APPID/AK/SK
	 public static final String APP_ID     = "16822946";
	 public static final String API_KEY    = "i5m9TFVadX8rxANOkcO1AgOE";
	 public static final String SECRET_KEY = "HY0dUjhBEAxTEhsDD0RnSNi4d9cVwKmh";
	 
    /**
     * mp3的字节数组生成wav文件
     * @param sourceBytes
     * @param targetPath
     */
    public static boolean byteToWav(byte[] sourceBytes, String targetPath) {
        if (sourceBytes == null || sourceBytes.length == 0) {
            System.out.println("Illegal Argument passed to this method");
            return false;
        }

        try (final ByteArrayInputStream bais = new ByteArrayInputStream(sourceBytes); final AudioInputStream sourceAIS = AudioSystem.getAudioInputStream(bais)) {
            AudioFormat sourceFormat = sourceAIS.getFormat();
            // 设置MP3的语音格式,并设置16bit
            AudioFormat mp3tFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sourceFormat.getSampleRate(), 16, sourceFormat.getChannels(), sourceFormat.getChannels() * 2, sourceFormat.getSampleRate(), false);
            // 设置百度语音识别的音频格式
            AudioFormat pcmFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 16000, 16, 1, 2, 16000, false);
            try (
                // 先通过MP3转一次，使音频流能的格式完整
                final AudioInputStream mp3AIS = AudioSystem.getAudioInputStream(mp3tFormat, sourceAIS);
                // 转成百度需要的流
                final AudioInputStream pcmAIS = AudioSystem.getAudioInputStream(pcmFormat, mp3AIS)) {
                // 根据路径生成wav文件
                AudioSystem.write(pcmAIS, AudioFileFormat.Type.WAVE, new File(targetPath));
            }
            return true;
        } catch (IOException e) {
            System.out.println("文件转换异常：" + e.getMessage());
            return false;
        } catch (UnsupportedAudioFileException e) {
            System.out.println("文件转换异常：" + e.getMessage());
            return false;
        }
    }

    /**
     * 将文件转成字节流
     * @param filePath
     * @return
     */
    private static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void main(String args[]) {
        String filePath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\java\\com\\baidu\\ai\\aip\\audio\\1565660784966.mp3";
        String targetPath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\java\\com\\baidu\\ai\\aip\\audio\\test.wav";
        byteToWav(getBytes(filePath), targetPath);
        AipSpeech client = new AipSpeech(APP_ID, API_KEY,SECRET_KEY);
        JSONObject asrRes = client.asr(targetPath, "wav", 16000, null);
        System.out.println(asrRes);
        System.out.println(asrRes.get("result"));
    }
    
}
