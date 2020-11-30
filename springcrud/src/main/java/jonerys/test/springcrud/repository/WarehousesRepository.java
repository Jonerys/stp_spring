package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Warehouses SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);

    @Query("SELECT id FROM Warehouses WHERE name = :name")
    Integer findIdByName(@Param("name") String name);

    @Query("FROM Warehouses WHERE name = :name")
    Warehouses findByName(@Param("name") String name);

}
