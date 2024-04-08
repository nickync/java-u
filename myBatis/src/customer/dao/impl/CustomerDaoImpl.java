package src.customer.dao.impl;

import src.customer.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save() {
        System.out.println("save customer data");
    }
}
