package net.sourceforge.pinyin4j.test;

import junit.framework.TestCase;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.multipinyin.MultiPinyinConfig;

import java.io.*;


public class Q extends TestCase {
    static HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();

    static {
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    public void testMultiByPath() throws Exception {
        MultiPinyinConfig.multiPinyinPath = "/Users/lerry/my_multi_pinyin.txt";
        outPrint();
    }

    public void testMultiByInput() throws Exception {
        MultiPinyinConfig.multiPinyinInput = new FileInputStream(new File("/Users/lerry/my_multi_pinyin.txt"));
        outPrint();
    }

    private void outPrint() throws Exception {
        System.out.println(PinyinHelper.toHanYuPinyinString("呵呵...", outputFormat, ";", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("吸血鬼...", outputFormat, ";", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("吸血鬼日记...", outputFormat, ";", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("我还要去图书馆还书...", outputFormat, "", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("一五一十", outputFormat, "", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("女医明妃传", outputFormat, ";", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("一人做事一人当还", outputFormat, ".", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("梦之安魂曲", outputFormat, ",", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("长春..", outputFormat, ",", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("长春不老/", outputFormat, ",", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("阿永", outputFormat, ",", false));
        System.out.println(PinyinHelper.toHanYuPinyinString("一日千里", outputFormat, ",", true));
        System.out.println(PinyinHelper.toHanYuPinyinString("哇哈ho", outputFormat, ",", true));
    }

    public void testMore() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/lerry/pinyin.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/lerry/pinyin_pinyin4j.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(PinyinHelper.toHanYuPinyinString(line, outputFormat, "", true) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
