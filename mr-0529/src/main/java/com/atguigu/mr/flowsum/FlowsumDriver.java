package com.atguigu.mr.flowsum;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 15:34
 */
public class FlowsumDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        args = new String[]{"e:/inputflow","e:/output1"};

        Configuration conf = new Configuration();
        // 1获取job对象
        Job job = Job.getInstance(conf);

        // 2设置jar的路径
        job.setJarByClass(FlowsumDriver.class);

        // 3关联mapper和reducer
        job.setMapperClass(FlowCountMapper.class);
        job.setReducerClass(FlowCountReducer.class);

        // 4设置mapper输出的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        // 5设置最终输出的key和value
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        job.setPartitionerClass(ProvincePartitioner.class);

        //job.setNumReduceTasks(5);
        job.setNumReduceTasks(1);

        // 6设置输入输出路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // 7提交job
        boolean result = job.waitForCompletion(true);

        System.exit(result?0:1);

    }
}
