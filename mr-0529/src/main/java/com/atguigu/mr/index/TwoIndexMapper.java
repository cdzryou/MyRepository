package com.atguigu.mr.index;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-09 19:34
 */
public class TwoIndexMapper extends Mapper<LongWritable,Text,Text,Text> {

    Text k = new Text();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // atguigu a.txt 3
        // atguigu b.txt 2
        // atguigu c.txt 2

        // 1获取一行
        String line = value.toString();

        // 2切割
        String[] fields = line.split("--");

        // 3封装
        k.set(fields[0]);
        v.set(fields[1]);

        // 4写出
        context.write(k,v);

    }
}
