package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.GoodsMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMainRepository extends JpaRepository<GoodsMain, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE GoodsMain SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);

    @Query("FROM GoodsMain WHERE name = :name")
    GoodsMain findByName(@Param("name") String name);
}
