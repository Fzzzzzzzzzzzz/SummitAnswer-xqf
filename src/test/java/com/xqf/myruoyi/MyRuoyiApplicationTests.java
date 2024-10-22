package com.xqf.myruoyi;

import com.xqf.domain.User;
import com.xqf.mapper.CommentMapper;
import com.xqf.mapper.UserMapper;
import com.xqf.myruoyi.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.w3c.dom.*;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@SpringBootTest
class MyRuoyiApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

//        List<String> list = Arrays.asList("a", "", "b", "c", "", "d");
//        String cardImageUrl="http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/1.png,http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/2.png";
//        int i = cardImageUrl.indexOf("customer-center-bucket-dev/");
//        String substring = "http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/1.png".substring("http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/1.png".indexOf("customer-center-bucket-dev") + "customer-center-bucket-dev".length()+1);
//        System.out.println(substring);
//        String[] split = cardImageUrl.split(",");
//        for (String str: split) {
//            System.out.println(str);
//        }


//        String bucketName="customer-center-bucket-dev";
//        String splitArray[]=new String[]{"http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/1.png","http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/2.png"};
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i=0;i<splitArray.length;i++) {
//            String objectName = splitArray[i].substring(splitArray[i].indexOf(bucketName) + bucketName.length() + 1);
//            String str ="1";
//            stringBuffer.append(str+i+",");
//            if(i==splitArray.length-1){
//                stringBuffer.append(str+i);
//            }
//        }
//        System.out.println(stringBuffer.toString());

//        String str="http://10.19.36.124:9000/customer-center-bucket-dev/2023/06/29/2.png";
//        String[] split = str.split(",");
//        System.out.println(split.length);

        Map<String, String> map = new HashMap<>();
        map.put("1","111");
        map.put("2","222");
        map.put("3","333");
        map.put("4","444");
        String s = map.get("5");
        System.out.println(s);
    }

    @Test
    void test1() {
        CompletableFuture.runAsync(new Thread(), Executors.newFixedThreadPool(3));
//        CompletableFuture.supplyAsync(new Thread(), Executors.newFixedThreadPool(3)).whenComplete()
        List<String> list = new ArrayList<String>();
        list.add("");
        list.add(" ");
        List<String> collect = list.stream().filter(str -> (str!=null&&!str.trim().equals(""))).collect(Collectors.toList());
        System.out.println(collect.size());
    }
    @Test
    void test2() {

        FutureTask futureTask = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
////        futureTask.get()
//        CompletableFuture.runAsync(futureTask).complete()
//        ConcurrentHashMap

    }

    @Test
    void test3() throws ParseException {

        AtomicReference<Object> objectAtomicReference = new AtomicReference<>();

        AtomicReference<User> atomicReference = new AtomicReference<>();
        User z3 = new User( "z3");
        User li4 = new User( "li4");
        //设置张三进去引用类
        atomicReference.set(z3);
        System.out.println(atomicReference. compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
//        AtomicStampedReference
    }

    public static void main(String[] args) {

        Test1 test1 = new Test1();

        new Thread(test1,"卖票机t1").start();
        new Thread(test1,"卖票机t2").start();
        new Thread(test1,"卖票机t3").start();
        new Thread(test1,"卖票机t4").start();
    }

    static class Test1 implements Runnable{
        private static int tickets = 100;

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "售出了第" + tickets + "张票");
                        tickets--;
                    } else {
                        System.out.println(Thread.currentThread().getName() + "售罄！！！");
                        break;
                    }
                }
            }
        }
    }

    @Test
    void test5()  {
        String str=null;
        List<Map<String, Object>> users = userMapper.getUsers(str);

        System.out.println(users);
    }

//    private JdbcTemplate jdbcTemplate;
    @Test
    void test6() throws ParseException {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM");
//        Date parse = simpleDateFormat.parse("2023-12-01 10:21:10");
//new NamedParameterJdbcTemplate()
        Date date = new Date();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Month2",date);
        Date month2 = (Date)map.get("Month2");
        System.out.println(simpleDateFormat.format(month2));
    }

    @Test
    void test7() throws ParseException {

        List<Map<String, Object>> users = userMapper.getUsers("1212");
        System.out.println(users.size());
    }

    //骏雷科技经理技术题目：
    @Test
    void test8() throws Exception{

        String appleFile = "H:\\1毕设前的学习\\Java机考1\\Apple.xml";
        String orangeFile = "H:\\1毕设前的学习\\Java机考1\\Orange.csv";


        //读取苹果xml文件
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder  = dbf.newDocumentBuilder();
            //拿到xml文件
        Document doc = dBuilder.parse(new File(appleFile));
        doc.getDocumentElement().normalize();

        Map<String, Map<String,Integer>> appleDataMap = new HashMap<String, Map<String,Integer>>();
        NodeList nList = doc.getElementsByTagName("Customer");

        for (int i = 0; i < nList.getLength(); i++) {
            Map<String,Integer> map = new HashMap<>();
            Element element = (Element) nList.item(i);
            String customerCode = element.getElementsByTagName("CustomerCode").item(0).getTextContent();
//            System.out.println("CustomerCode："+customerCode );
            NamedNodeMap appleQuantityMap = element.getElementsByTagName("CustomerName").item(0).getAttributes();
            int appleQuantity = Integer.parseInt(appleQuantityMap.getNamedItem("苹果数量").getNodeValue());

//            System.out.println("苹果数量:"+appleQuantity);
            String name = element.getElementsByTagName("CustomerName").item(0).getTextContent();
//            System.out.println("名字："+name);
            map.put(name,appleQuantity);
            appleDataMap.put(customerCode,map);
        }
        //读取橘子csv文件


        Map<String, Integer> orangeData = new HashMap<>();
        //原有的csv文件是ansi编码格式的，自己手动将其改为utf-8的格式
        BufferedReader br = Files.newBufferedReader(Paths.get(orangeFile));
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                //跳过表头字段
                if(lineNumber==1){
                    continue;
                }
                String[] values = line.split(",");
                String customerCode = values[0];
                int quantity = Integer.parseInt(values[1]);
                orangeData.put(customerCode, quantity);
            }


        //数据组装

        System.out.println(appleDataMap);
        System.out.println(orangeData);
        List<Customer> customerList = new ArrayList<>();

        //遍历苹果数据的客户code，同时判断橘子是否有相同的客户code
        for(String key : appleDataMap.keySet()){
            //拿到某个客户item（名称与所持有的苹果数量）Map
            Map<String, Integer> item = appleDataMap.get(key);
            //客户名字
            String customerName = item.keySet().iterator().next();
            //苹果数量
            Integer appleCounts = item.get(customerName);
            //橘子数量
            Integer orangeCounts = 0;

            //判断橘子数据中是否有和苹果数据的客户code相同
            if(orangeData.containsKey(key)){
                //拿到橘子数据
                orangeCounts = orangeData.get(key);
                //顺便删除这个客户的橘子数据
                orangeData.remove(key);
            }

            Customer customer = new Customer();
            //设置客户Code
            customer.setCustomerCode(key);
            customer.setCustomerName(customerName);
            customer.setAppleCountSum(appleCounts);
            customer.setOrangeCountSum(orangeCounts);
            //统计水果数量
            customer.setFruitSum(appleCounts+orangeCounts);
            customerList.add(customer);
        }
        //遍历橘子数据剩下的客户
        for (String key2: orangeData.keySet()) {
            Customer customer = new Customer();
            //设置客户Code
            customer.setCustomerCode(key2);
            customer.setOrangeCountSum(orangeData.get(key2));
            //统计水果数量
            customer.setFruitSum(orangeData.get(key2));
            customerList.add(customer);
        }

        //记录列表按单个客户所拥有的水果总数降序排列
        Collections.sort(customerList, Comparator.comparingInt(Customer::getFruitSum).reversed());

        //文件输出路径
        String filePath = "H:\\1毕设前的学习\\Java机考1\\test.txt";
        // 创建 File 对象
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        // 写入标题行
        writer.write("CustomerCode|CustomerName|苹果数量|桔子数量|水果总数\n");

        // 遍历Customer列表，并写入每行的数据
        for (Customer customer : customerList) {
            writer.write(customer.getCustomerCode() + "|" +
                    customer.getCustomerName() + "|" +
                    customer.getAppleCountSum() + "|" +
                    customer.getOrangeCountSum() + "|" +
                    customer.getFruitSum() + "\n");
//                writer.newLine();
        }
        writer.close();
    }
}
