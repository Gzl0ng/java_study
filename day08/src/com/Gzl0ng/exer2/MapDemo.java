package com.Gzl0ng.exer2;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
1.	如何遍历Map的key集，value集,key-value集，使用上泛型

2. 写出使用Iterator 和 增强for 循环遍历List<String>的代码,使用上泛型

3. 提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用。

4. 创建一个与a.txt文件同目录下的另外一个文件b.txt

5. Map接口中的常用方法有哪些

 */
public class MapDemo {
    private Iterator<String> iterator;

    public static void main(String[] args) throws IOException {
        Map<String ,String > map = new HashMap<>();
        map.put("Tom","22");
        map.put("Jerry","18");
        map.put("Mike","25");

        //如何遍历Map的key集，value集,key-value集，使用上泛型
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
       while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("1*****************");

        Collection<String> values = map.values();
        for (String s : values){
            System.out.println(s);
        }

        System.out.println("2**************");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("************");

        for (Map.Entry entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("******");
        Set<String> strings1 = map.keySet();
        Iterator<String> iterator1 = strings1.iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

//        2. 写出使用Iterator 和 增强for 循环遍历List<String>的代码,使用上泛型
        System.out.println("写出使用Iterator 和 增强for 循环遍历List<String>的代码,使用上泛型");
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Mike");
        Iterator<String> iterator3 = list.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

        for (String s : list){
            System.out.println(s);
        }

//        3. 提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用。
        System.out.println("提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用。");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Tom","22");
        hashMap.put("Jerry","15");
        hashMap.put("Mike","18");
        List method = method(hashMap);
        for (int i = 0; i < method.size(); i++) {
            System.out.println(method.get(i));
        }
        for (Object s : method){
            System.out.println(s);
        }

        //4. 创建一个与a.txt文件同目录下的另外一个文件b.txt
        System.out.println("4. 创建一个与a.txt文件同目录下的另外一个文件b.txt");
        File file = new File("a.txt");
        System.out.println(file.createNewFile());
        System.out.println();
        File file1 = new File(file,"b.txt");
        System.out.println(file1.createNewFile());

//        5. Map接口中的常用方法有哪些
        System.out.println("5. Map接口中的常用方法有哪些");
        Map map1 = new HashMap();
        map1.put("Tom",1);
        map1.remove("Tom");
        map1.put("Tom",22);
        map1.get("Tom");
        int size = map1.size();
        map1.keySet();
        map1.values();
        map1.entrySet();
    }

    public static List method(HashMap map){
        ArrayList list = new ArrayList();
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
