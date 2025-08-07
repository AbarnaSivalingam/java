package com.study;
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Model Class (Optional but realistic)
class Customer {
    private int id;
    private String name;
    
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Step 3: Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulate data lookup (in reality this might query a database)
        System.out.println("Looking up customer with ID: " + id);
        return new Customer(id, "John Doe");
    }
}

// Step 4: Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

// Step 6: Test Class
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        // Inject it into the service
        CustomerService service = new CustomerService(repository);
        
        // Use service to find a customer
        service.displayCustomer(101);
    }
}

