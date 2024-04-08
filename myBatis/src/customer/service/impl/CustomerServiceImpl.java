package src.customer.service.impl;

import src.customer.dao.CustomerDao;
import src.customer.dao.impl.CustomerDaoImpl;
import src.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    // old
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save() {
        customerDao.save();
    }
}
