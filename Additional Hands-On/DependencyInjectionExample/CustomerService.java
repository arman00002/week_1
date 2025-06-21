package DependencyInjectionExample;

public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(String customerId) {
        Customer customer = repository.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID   : " + customer.getId());
            System.out.println("Name : " + customer.getName());
        } else {
            System.out.println("No customer found with ID: " + customerId);
        }
    }
}

