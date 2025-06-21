package DependencyInjectionExample;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerData;

    public CustomerRepositoryImpl() {
        customerData = new HashMap<>();
        customerData.put("C101", new Customer("C101", "Ravi Kumar"));
        customerData.put("C102", new Customer("C102", "Neha Sharma"));
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerData.get(customerId);
    }
}

