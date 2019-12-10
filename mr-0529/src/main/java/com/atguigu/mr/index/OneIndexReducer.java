package com.atguigu.mr.index;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-09 19:30
 */
public class OneIndexReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    IntWritable v = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum = 0;
        // 1累加求和
        for (IntWritable value : values) {
            sum += value.get();
        }

        v.set(sum);

        // 2写出
        context.write(key,v);
    }
}
