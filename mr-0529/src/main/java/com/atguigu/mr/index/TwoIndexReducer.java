package com.atguigu.mr.index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-09 19:37
 */
public class TwoIndexReducer extends Reducer<Text,Text,Text,Text> {

    Text v = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // atguigu a.txt 3
        //         b.txt 2
        //         c.txt 2

        // atguigu c.txt-->2 b.txt-->2 a.txt-->3

        // 1拼接字符串
        StringBuilder sb = new StringBuilder();

        for (Text value : values) {
            sb.append(value.toString().replace("\t","-->") + "\t");
        }

        v.set(sb.toString());

        // 写出
        context.write(key,v);

    }
}
