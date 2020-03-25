package com.tree.www.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.tree.www.easyexcel.model.DemoData;

import java.io.File;

/**
 * Created by pysh on 2020-02-26.
 */
public class Test {
    public static void main(String[] args) {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "/Users/pysh/Downloads" + File.separator + "功夫贷4月.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        //// 写法2：
        //fileName = "demo" + File.separator + "demo.xlsx";
        //ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, null).build();
        //ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //excelReader.read(readSheet);
        //// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //excelReader.finish();
    }
}
