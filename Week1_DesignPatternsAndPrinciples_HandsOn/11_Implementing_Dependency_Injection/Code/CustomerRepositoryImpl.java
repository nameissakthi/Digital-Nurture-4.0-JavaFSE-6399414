public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        return new Customer(id, "Sakthi");
    }
}
