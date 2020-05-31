package ntou.wbse.pharmacy.service;

import ntou.wbse.pharmacy.MaskHandler;
import ntou.wbse.pharmacy.entity.Note;
import ntou.wbse.pharmacy.entity.NoteRequest;
import ntou.wbse.pharmacy.entity.Pharmacy;
import ntou.wbse.pharmacy.repository.NoteRepository;
import ntou.wbse.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class PharmacyService {

    @Autowired
    private static NoteRepository noteRepository;

    private static MaskHandler maskHandler;

    public PharmacyService(NoteRepository noteRepository) throws IOException, URISyntaxException {
        this.noteRepository = noteRepository;
        this.maskHandler = new MaskHandler();
        this.maskHandler.initialize();
    }

    public static Pharmacy getPharmacy(String id){
        //return repository.findById(id).orElseThrow(() -> new NotFoundException("Pharmacy not found !"));
        //return repository.findPharmacyById(id);
        Pharmacy target = maskHandler.getPharmacy(id);

        injectNoteInfo(target);
        return target;
    }

    public static List<Pharmacy> getPharmacies(String name, String address){
        //return repository.findPharmaciesByNameContainsAndAddressContains(name, address);
        List<Pharmacy> list = maskHandler.findPharmacies(name, address);
        list.forEach(PharmacyService::injectNoteInfo);
        return list;
    }

    public static Note createNote(String pharmacyId, String msg){
        Note note = new Note();
        note.setPharmacyId(pharmacyId);
        note.setNote(msg);

        return noteRepository.insert(note);
    }

    public static Note replaceNote(String pharmacyId, String msg){
        // locate current Note via pharmacyId
        // generate new Note
        Note current = noteRepository.findNoteByPharmacyId(pharmacyId);
        current.setNote(msg);

        return noteRepository.save(current);
    }

    public static void removeNote(String pharmacyId){
        noteRepository.deleteByPharmacyId(pharmacyId);
    }

    public static void injectNoteInfo(Pharmacy target){
        // inject current note information in to pharmacy data sets
        String pharmacyId = target.getId();
        Note note = noteRepository.findNoteByPharmacyId(pharmacyId);
        if(note != null){
            target.setNote(note.getNote());
        }else{
            target.setNote(null);
        }
    }

}
