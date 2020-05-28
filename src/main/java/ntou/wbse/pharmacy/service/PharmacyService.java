package ntou.wbse.pharmacy.service;

import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.exception.NotFoundException;
import ntou.wbse.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PharmacyService {
    // TODO : add Pharmacy object handle functions

    @Autowired
    private PharmacyRepository repository;

    public Pharmacy getPharmacy(String id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Pharmacy not found !"));
    }

    // TODO : service for GET multiple pharmacies
    public ArrayList<Pharmacy> getPharmacies(){
        return null;
    }
}
