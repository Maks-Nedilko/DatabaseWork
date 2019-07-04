package ua.itea.business;

import java.util.List;
import ua.itea.entity.Address;
import ua.itea.service.AddressService;

public class MainApp {

    public static void main(String[] args) {

        AddressService as = new AddressService();

        Address address1 = new Address();
        address1.setId(10l);
        as.delete(address1);

        Address address2 = new Address();
        address2.setId(11l);
        as.delete(address2);

        Address address3 = new Address();
        address3.setId(1L);
        address3.setCountry("Ukraine");
        address3.setCity("Kyiv");
        address3.setStreet("Sadova");
        as.update(address3);

        Address address4 = new Address();
        address4.setId(2L);
        address4.setCountry("Germany");
        address4.setCity("Drezden");
        address4.setStreet("Sadova");
        as.add(address4);

        Address address5 = new Address();
        address5.setId(3L);
        address5.setCountry("USA");
        address5.setCity("Boston");
        address5.setStreet("Sadova");
        as.add(address5);

        List<Address> list = as.getAll();
        if (list != null) {
            for (Address ad : list) {
                System.out.println(ad);
            }
        }

        Address address6 = as.getById(1);
        System.out.println(address6);
        Address address7 = as.getById(700);
        System.out.println(address7);

    }
}
