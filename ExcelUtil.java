package com.java8.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author beifengjun
 * @title: excel 解析工具
 * @description: 解析excel解析工具支持有规律的动态列数
 * @date 2024-02-03 10:08 a.m.
 */
public class ExcelUtil {

    public static class DynamicColumnExcelRuler {

        public DynamicColumnExcelRuler(String startColumnName, int cycleNum) {
            this.startColumnName = startColumnName;
            this.cycleNum = cycleNum;
        }

        /**
         * @description: 开始有规律的列名
         */
        private String startColumnName;

        /**
         * @description: 重复规律如：每3列重复那cycleNum=3
         */
        private int cycleNum;



    }


    public static <T> List<T> DynamicColumnExcelReader(String filePath, Class cls,DynamicColumnExcelRuler ruler) {
        List<T> list = new ArrayList<>();
        DynamicDataListener dynamicDataListener = new DynamicDataListener();
        EasyExcel.read(filePath, dynamicDataListener).doReadAll();
        // 获取表头Map<columnIndex, columnName>
        Map<Integer, String> headMap = dynamicDataListener.getHeadMap();
        // 获取所有的数据行
        List<Object> allData = dynamicDataListener.getAllData();






        return list;
    }


    private static <T> T  AnalysisMapToClass(Class cls, Map<Integer, String> headMap, Object rowdata,DynamicColumnExcelRuler ruler) {

        try {
            Object instance = cls.newInstance();
            Field[] fields = cls.getFields();
            int temp = 0;
            int cellTemp = 0;
            Map<Integer, String> cardPrice = (Map<Integer, String>) rowdata;
            for (Map.Entry<Integer, String> cell :cardPrice.entrySet()) {
                Integer cellHeadIndex = cell.getKey();
                String cellHeadName = headMap.get(cellHeadIndex);
                if(!cellHeadName.equals(ruler.startColumnName)) {
                    try {
                        for (Field field : fields) {
                            ExcelIndex annotation = field.getAnnotation(ExcelIndex.class);
                            if (annotation != null) {
                                int index = annotation.index();
                                if (cellHeadIndex.equals(index)) {
                                    field.setAccessible(true);
                                    Method method = cls.getMethod("set" + field.getName(), field.getType());
                                    method.invoke(instance, cell.getValue());
                                }
                            }
                        }

                    } catch (Exception e) {

                    }
                    temp++; continue;
                }
                if (cellTemp % ruler.cycleNum == 0) {
                    ReaderWriterExcelTest.StructCard structCard = new ReaderWriterExcelTest.StructCard();
                    structCard.setCardName(cell.getValue());
                    price.add(structCard);

                } else if(cellTemp % ruler.cycleNum == 1) {
                    ReaderWriterExcelTest.StructCard structCard = price.get(price.size() - 1);
                    structCard.setCardNo(cell.getValue());
                } else {
                    ReaderWriterExcelTest.StructCard structCard = price.get(price.size() - 1);
                    structCard.setCardBalance(Double.parseDouble(cell.getValue()));
                }
                cellTemp++;
            }
        }catch (Exception e) {

        }




    }






    private static class DynamicDataListener extends AnalysisEventListener<Object> {
        public List<Object> allData = new ArrayList<>();
        public Map<Integer, String> headMap  = new HashMap<>();

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            this.headMap = headMap;
        }

        // 这个方法会在读取每一行数据之前调用
        @Override
        public void invoke(Object data, AnalysisContext context) {
            // 数据存储到list，key为列索引，value为单元格内容
            allData.add(data);
        }

        // 所有数据解析完成之后会调用该方法
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            // 处理所有数据完成后的工作，例如保存到数据库、返回结果等
            System.out.println("所有数据解析完成：" + allData);
        }

        public List<Object> getAllData() {
            return allData;
        }

        public Map<Integer, String> getHeadMap() {
            return headMap;
        }
    }





}
