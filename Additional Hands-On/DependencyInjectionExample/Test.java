package DependencyInjectionExample;

public class Test {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.getCustomerDetails("C101");

        System.out.println();

        service.getCustomerDetails("C999");  // Invalid ID test
    }
}
