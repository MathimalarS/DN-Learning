public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer Details: " + customer);
    }
}
