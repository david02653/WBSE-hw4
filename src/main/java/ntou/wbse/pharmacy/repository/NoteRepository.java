package ntou.wbse.pharmacy.repository;

import ntou.wbse.pharmacy.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    Note findNoteByPharmacyId(String pharmacyId);
    void deleteByPharmacyId(String pharmacyId);
}
