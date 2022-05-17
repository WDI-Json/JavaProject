package routeplannerpoc.windesheimdemo.service;

import java.util.List;

import routeplannerpoc.windesheimdemo.model.Address;

public interface IAddressService {

    List<Address> findAll();
}