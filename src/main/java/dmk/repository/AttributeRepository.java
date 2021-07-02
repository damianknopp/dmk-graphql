package dmk.repository;

import dmk.model.Attribute;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttributeRepository extends PagingAndSortingRepository<Attribute, UUID> {
}
