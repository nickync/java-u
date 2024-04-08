package src.customer.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    /*
    * 初始化beans.properties文件
    */
    private static Properties props = new Properties();
    static {
        InputStream in = BeanFactory.class.getResourceAsStream("/beans.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载beans.properties文件失败");
        }
    }

    //从工厂获取一个对象
    public static Object getBean(String name){
        //根据name创建不同对象
        //1. 通过name再properties文件找到类名称
        String className = props.getProperty(name);
        //2. 通过反射构造类的对象
        try {
            Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
