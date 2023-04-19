package com.bobo.nowcoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: bo
 * @DATE: 2023/4/6 11:46
 **/
public class Regex {
    public static void main(String[] args) throws IOException {
        System.out.println("开始解析文件...");

        //定义规则模板
        Pattern p = Pattern.compile("(.*?)<info>(.*?)</info>(.*?)");
        //读取文件
        String fileName = "D:\\javaReadFile\\s.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(fileName));

        //计算文件行数，后面每1000行匹配一次
        int total = 0;
        while (br1.readLine() != null) {
            total++;
        }

        //重新创建一个reader对象，
        BufferedReader br2 = new BufferedReader(new FileReader(fileName));
        //创建StringBuilder对象，利用append方法把每行的内容追加到br2中
        StringBuilder buf = new StringBuilder();

        //每行读取到的数据暂存line
        String line;
        //当前行数
        int cru = 1;
        //写入次数
        int realLine = 1;

        BufferedWriter bufferedWriter;
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
//        System.out.println(1/1000);
//        System.out.println(199%1000);
        //开始循环读取文件

        String path = "D:\\javaReadFile\\res\\" + df.format(new Date()) + ".txt";
        bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        while ((line = br2.readLine()) != null) {
            //把当前行追加到buf中
            buf.append(line);
            //每1000行进行一次正则匹配
            if (cru % 1000 == 0 || cru == total) {
                Matcher m = p.matcher(buf);
                int start = 0;
                while (m.find(start)) {
                    if (realLine != 1) {
                        bufferedWriter.newLine();  //每次开始写入前先换行
                    }
                    realLine++;

                    bufferedWriter.write(m.group(2));

                    System.out.println(m.group(2));
                    start = m.end();

                }
                //匹配完成后清空buf
                buf = new StringBuilder();
            }
            cru++;
        }
        bufferedWriter.flush();    //使写入生效
        System.out.println("解析完成，共计" + (realLine - 1) + "行，已生成文件" + path);
        bufferedWriter.close();
        br1.close();
        br2.close();
    }
}

