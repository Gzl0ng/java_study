//package com.Gzl0ng.exer;

//public class MyWordCount {

//    @Test
//    public void test(){
//
//        FileReader fr = null;
//        FileWriter fw = null;
//        try {
//            fr = new FileReader(new File("dbcp.txt"));
//            fw = new FileWriter(new File("Count.txt"));
//            HashMap<String,Integer> map = new HashMap<>();
//
//           char[] c = new char[1024];
//           int len;
//           while ((len = fr.read(c)) != -1){
//               String s = new String(c, 0, len);
//               for (String s1 : s){
//                   if (map.get(s1) == null){
//                       map.put(s1,1);
//                   }else {
//                       map.put(s1,map.get(s1) + 1);
//                   }
//               }
//           }
//
//            Set<Map.Entry<String, Integer>> entries = map.entrySet();
//            for (Map.Entry<String,Integer> entry : entries){
//                switch (entry.getKey()){
//                    case ' ':
//                        fw.write("空格=" + entry.getValue());
//                        break;
//                    case '\t'://\t表示tab 键字符
//                        fw.write("tab键=" + entry.getValue());
//                        break;
//                    case '\r'://
//                        fw.write("回车=" + entry.getValue());
//                        break;
//                    case '\n'://
//                        fw.write("换行=" + entry.getValue());
//                        break;
//                    default:
//                        fw.write(entry.getKey() + "=" + entry.getValue());
//                        break;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fr != null){
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fw != null){
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//}
