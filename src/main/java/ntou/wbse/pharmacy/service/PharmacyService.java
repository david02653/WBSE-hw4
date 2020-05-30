package ntou.wbse.pharmacy.service;

import ntou.wbse.pharmacy.MaskHandler;
import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.exception.NotFoundException;
import ntou.wbse.pharmacy.repository.NoteRespository;
import ntou.wbse.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {

    @Autowired
    private static PharmacyRepository repository;
    @Autowired
    private static NoteRespository noteRespository;

    private static MaskHandler maskHandler;

    public PharmacyService(PharmacyRepository pharmacyRepository, NoteRespository noteRespository) throws IOException, URISyntaxException {
        this.repository = pharmacyRepository;
        this.noteRespository = noteRespository;

        this.maskHandler = new MaskHandler();
        this.maskHandler.initialize();
    }

    public static Pharmacy getPharmacy(String id){
        //return repository.findById(id).orElseThrow(() -> new NotFoundException("Pharmacy not found !"));
        //return repository.findPharmacyById(id);
        return maskHandler.getPharmacy(id);
    }

    public static List<Pharmacy> getPharmacies(String name, String address){
        //return repository.findPharmaciesByNameContainsAndAddressContains(name, address);
        return maskHandler.findPharmacies(name, address);
    }

    public static Note createNote(){
        return null;
    }

    public static Note replaceNote(){
        return null;
    }

    public static void removeNote(){
    }

}
