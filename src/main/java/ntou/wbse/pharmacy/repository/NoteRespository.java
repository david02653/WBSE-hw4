package ntou.wbse.pharmacy.repository;

import ntou.wbse.pharmacy.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRespository extends MongoRepository<Note, String> {
}
