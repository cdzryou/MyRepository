package com.atguigu.mr.inputformat;

import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 20:26
 */
public class WholeFileInputformat extends FileInputFormat<Text,ByteWritable> {

    @Override
    public RecordReader createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {

        WholeRecorReader recordReader = new WholeRecorReader();
        recordReader.initialize(split,context);

        return recordReader;
    }
}
