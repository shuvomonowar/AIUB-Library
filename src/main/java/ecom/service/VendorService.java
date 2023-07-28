package ecom.service;

import ecom.domain.Vendor;
import ecom.repository.VendorRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class VendorService {

    private Logger logger = Logger.getLogger(VendorService.class.getName());

    private VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> list() {
        return vendorRepository.list();
    }

    public Vendor get(Long id) {
        return vendorRepository.get(id);
    }

    public boolean create(Vendor vendor) {
        return vendorRepository.create(vendor);
    }

    public boolean update(Vendor vendor) {
        return vendorRepository.update(vendor);
    }

    public boolean delete(Long id) {
        return vendorRepository.delete(get(id));
    }
}
