package com.atguigu.mr.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.xml.transform.Result;
import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-11-28 19:50
 */
public class WordcountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        // 1 获取job对象
        Job job = Job.getInstance(conf);

        // 2 设置jar存储位置
        job.setJarByClass(WordcountDriver.class);

        // 3 关联Map和Reduce
        job.setMapperClass(WordcountMapper.class);
        job.setReducerClass(WordcountReducer.class);

        // 4 设置Mapper阶段输出数据的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 设置最终数据输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setCombinerClass(WordcountCombiner.class);

        // 6 设置输入路径和输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // 7 提交任务
//        job.submit();
        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }
}
