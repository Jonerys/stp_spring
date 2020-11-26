package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.WarehousesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<WarehousesEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE WarehousesEntity SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);
}
