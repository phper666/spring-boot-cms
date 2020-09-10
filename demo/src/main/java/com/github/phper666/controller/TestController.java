package com.github.phper666.controller;

import com.github.phper666.avro.GpsDataAvro;
import com.github.phper666.protobuf.GpsDataProto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.InvalidProtocolBufferException;


import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;


import java.io.*;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/9 4:26 下午
 * @software IntelliJ IDEA
 */
@RestController
public class TestController {
    @GetMapping(path = "proto")
    public static String proto() {
//        System.out.println("===== 构建一个GPS模型开始 =====");
        GpsDataProto.GpsData.Builder gps_builder = GpsDataProto.GpsData.newBuilder();
        gps_builder.setTerminalId("副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐");
        gps_builder.setAltitude(1);
        gps_builder.setDataTime("2017-12-17 16:21:44");
        gps_builder.setGpsStatus(1);
        gps_builder.setLat(39.123);
        gps_builder.setLon(120.112);
        gps_builder.setDirection(30.2F);
        gps_builder.setId(100L);

        GpsDataProto.GpsData GpsData = gps_builder.build();
//        System.out.println(GpsData.toString());
//        System.out.println("===== 构建GPS模型结束 =====");

//        System.out.println("===== gps Byte 开始=====");
//        byte [] result = GpsData.toByteArray();
//        for(byte b : result){
//            System.out.print(b);
//        }
//        System.out.println("\n" + "bytes长度" + result.length);
//        System.out.println("===== gps Byte 结束 =====");

        System.out.println("===== 序列化 开始=====");
        // 获取开始时间
        long startTime = System.currentTimeMillis();

        byte [] result = GpsData.toByteArray();

        // 获取结束时间
        long endTime = System.currentTimeMillis();

        System.out.println("序列化程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("===== 序列化 结束 =====");
        System.out.println("序列化后的bytes长度" + result.length);


        System.out.println("===== 反序列化生成对象开始 =====");
        // 获取开始时间
        startTime = System.currentTimeMillis();

        GpsDataProto.GpsData gd = null;
        try {
            gd = GpsDataProto.GpsData.parseFrom(GpsData.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println("原数据长度: " + gd.toString().length());

        endTime = System.currentTimeMillis();

        System.out.println("反序列化程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("===== 反序列化生成对象结束 =====");
        return "hi";
    }

    @GetMapping(path = "arvo/serializing")
    public static String serializingAvro() throws IOException {
        GpsDataAvro gpsdata = new GpsDataAvro();
        gpsdata.setTerminalId("副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐副书记劳动纪律2进来开了房看时间雷锋精神拉开距离3几率连接但是两份几点睡刘会计福克斯风口浪尖拉开距离软件3(o´ω`o)ﾉ联防联控的斯洛伐克你死定了你付款两三年两份那算了你发了3卢克妮苦了你了看你两份纳税了可能否了十年老粉两三年的分类考试呢分开拿立刻发哪里是拿到分类你死定了开放男两三年分了多少能否来看待赛诺菲来看你了可能来3那你发的十年老粉lsdjflkdsjlk32jlk4jljlfjlJlkfjsdlj了多少分解落实到会计法来看多少积分了可视角度来了3没离开没靓女发了多少廊坊市来看麻烦啦时代楷模发了开幕式雷电法牛了美食的俘虏没收到两份马老师吗分类考试的麻烦没收到两份吗老师们地方里面收到了麻烦死了卖疯了吗 啦4了2毛了买了吗弗兰克目的是离开父母收到了麻烦是领导们圣诞快乐麻烦路上慢点率，查询，没地方是麻烦了喀麦隆没收到两份吗带来什么发了多少卖疯了吗收到了麻烦牢骚满腹路上慢点率美了美了麻辣豆腐");
        gpsdata.setAltitude(1);
        gpsdata.setDataTime("2017-12-17 16:21:44");
        gpsdata.setGpsStatus(1);
        gpsdata.setLat(39.123);
        gpsdata.setLon(120.112);
        gpsdata.setDirection(30.2F);
        gpsdata.setId(100L);

        // avro文件存放目录
        System.out.println("===== arvo序列化开始 =====");

        long startTime = System.currentTimeMillis();
        String path = "./lib/avro/file/test.avro";
        FileOutputStream file = new FileOutputStream(path);
        DatumWriter<GpsDataAvro> userDatumWriter = new SpecificDatumWriter<GpsDataAvro>(GpsDataAvro.class);
        DataFileWriter<GpsDataAvro> dataFileWriter = new DataFileWriter<GpsDataAvro>(userDatumWriter);
        try {
            dataFileWriter.create(gpsdata.getSchema(), file);
            dataFileWriter.append(gpsdata);
            dataFileWriter.close();
        } catch (IOException e) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("===== arvo序列化结束 =====");
        System.out.println("序列化程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("序列化后的bytes长度" + gpsdata.toString().length());

        return "success";
    }

    @GetMapping(path = "arvo/unserializing")
    public static String unSerializingAvro() throws FileNotFoundException {
        // 从文件中反序列化对象
        System.out.println("===== arvo反序列化开始 =====");
        String path = "./lib/avro/file/test.avro";
        File file = new File(path);

        long startTime = System.currentTimeMillis();
        DatumReader<GpsDataAvro> userDatumReader = new SpecificDatumReader<GpsDataAvro>(GpsDataAvro.class);
        DataFileReader<GpsDataAvro> dataFileReader = null;
        try {
            dataFileReader = new DataFileReader<GpsDataAvro>(file, userDatumReader);
        } catch (IOException e) {
            System.out.println("出现异常：" + e.getMessage());
        }
        GpsDataAvro gpsdata1 = null;
        while (dataFileReader.hasNext()) {
            gpsdata1 = dataFileReader.next();
            System.out.println(gpsdata1);
            System.out.println("反序列化原长度：" + gpsdata1.toString().length());
        }
        long endTime = System.currentTimeMillis();

        System.out.println("===== arvo反序列化结束 =====");
        System.out.println("反序列化程序运行时间：" + (endTime - startTime) + "ms");

        return "success";
    }
}
