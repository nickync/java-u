package src.customer.web;

import src.customer.service.CustomerService;
import src.customer.service.impl.CustomerServiceImpl;

public class ActionDemo {
    public static void main(String[] args) {
        // 调用业务，直接new对象. 弊端：耦合性太高， 需要修改源代码
        CustomerService customerService = new CustomerServiceImpl();
        customerService.save();
    }
}
