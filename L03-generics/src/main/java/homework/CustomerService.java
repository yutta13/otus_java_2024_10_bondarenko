package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    // todo: 3. надо реализовать методы этого класса

    private final NavigableMap<Customer, String> customersMap =
            new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return entryCopy(customersMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return entryCopy(customersMap.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customersMap.put(customer, data);
    }

    public Map.Entry<Customer, String> entryCopy(Map.Entry<Customer, String> customersEntry) {
        if (customersEntry == null) return null;
        Customer customerCopy = customersEntry.getKey();
        return Map.entry(
                new Customer(customerCopy.getId(), customerCopy.getName(), customerCopy.getScores()),
                customersEntry.getValue());
    }
}
