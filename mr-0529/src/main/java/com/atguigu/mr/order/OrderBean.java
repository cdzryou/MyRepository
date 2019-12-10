package com.atguigu.mr.order;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-04 10:15
 */
public class OrderBean implements WritableComparable<OrderBean>{

    private int order_id;
    private double price;

    public OrderBean() {
        super();
    }

    public OrderBean(int order_id, double price) {
        super();
        this.order_id = order_id;
        this.price = price;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(order_id);
        out.writeDouble(price);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        order_id = in.readInt();
        price = in.readDouble();
    }

    @Override
    public int compareTo(OrderBean bean) {

        // 先按订单id排序，如果相同  按照价格降序排序
        int result;

        if(order_id > bean.getOrder_id()){
            result = 1;
        }else if (order_id < bean.getOrder_id()){
            result = -1;
        }else{

            if(price > bean.getPrice()){
                result = -1;
            }else if (price < bean.getPrice()){
                result = 1;
            }else{
                result = 0;
            }
        }

        return result;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return order_id + "\t" + price;
    }
}
