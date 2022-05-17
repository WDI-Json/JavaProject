package routeplannerpoc.windesheimdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routeplannerpoc.windesheimdemo.model.Address;
import routeplannerpoc.windesheimdemo.repository.AdressRepository;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AdressRepository repository;

    @Override
    public List<Address> findAll() {

        var addresses = (List<Address>) repository.findAll();

        return addresses;
    }
}