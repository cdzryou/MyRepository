package com.atguigu.mr.kv;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueLineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 19:42
 */
public class KVTextDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"e:/input","e:/output"};
        Configuration conf = new Configuration();
        // 设置切割符
        conf.set(KeyValueLineRecordReader.KEY_VALUE_SEPERATOR," ");

        // 1获取job对象
        Job job = Job.getInstance(conf);

        // 2设置jar包位置，关联mapper和reducer
        job.setJarByClass(KVTextDriver.class);
        job.setMapperClass(KVTextMapper.class);
        job.setReducerClass(KVTextReducer.class);

        // 3设置map输出kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 4设置最终输出kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 5设置输入输出数据路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));

        // 设置输入格式
        job.setInputFormatClass(KeyValueTextInputFormat.class);

        // 6设置输出数据路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 7提交job
        boolean result = job.waitForCompletion(true);

        System.exit(result?0:1);
    }
}
