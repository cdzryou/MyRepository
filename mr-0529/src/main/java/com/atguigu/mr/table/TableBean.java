package com.atguigu.mr.table;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-08 21:32
 */
public class TableBean implements Writable {

//    id pid amout
//    pid pname

    private String id; //订单id
    private String pid; //产品id
    private int amout; //产品数量
    private String pname; //产品名称
    private String flag; //定义一个标记，标记是产品表还是订单表

    public TableBean() {
        super();
    }

    public TableBean(String id, String pid, int amout, String pname, String flag) {
        this.id = id;
        this.pid = pid;
        this.amout = amout;
        this.pname = pname;
        this.flag = flag;
    }

    @Override
    public void write(DataOutput out) throws IOException {

        // 序列化方法
        out.writeUTF(id);
        out.writeUTF(pid);
        out.writeInt(amout);
        out.writeUTF(pname);
        out.writeUTF(flag);

    }

    @Override
    public void readFields(DataInput in) throws IOException {

        // 反序列化方法
        id = in.readUTF();
        pid = in.readUTF();
        amout = in.readInt();
        pname = in.readUTF();
        flag = in.readUTF();
    }

    @Override
    public String toString() {
        return id + "\t" + amout + "\t" + pname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
