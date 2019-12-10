package com.atguigu.mr.kv;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 19:40
 */
public class KVTextReducer extends Reducer<Text,IntWritable,Text,LongWritable> {

    LongWritable v = new LongWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        long sum = 0l;

        // 1汇总统计
        for (IntWritable value : values) {
            sum += value.get();
        }

        v.set(sum);

        // 2输出
        context.write(key,v);

    }
}
