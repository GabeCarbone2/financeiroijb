package unifacef.edu.api_financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.mappers.AddressMapper;
import unifacef.edu.api_financeiro.models.dto.AddressDTO;
import unifacef.edu.api_financeiro.models.entity.Address;
import unifacef.edu.api_financeiro.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    public Address createAddress(AddressDTO addressDTO) {
        Address address = AddressMapper.convertAddressDTOToEntity(addressDTO);
        return addressRepository.save(address);
    }

    public Address updateAddress(Integer id, AddressDTO addressDTO) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();
            address = AddressMapper.convertAddressDTOToEntity(addressDTO);
            address.setId(id);
            return addressRepository.save(address);
        }
        return null;
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
