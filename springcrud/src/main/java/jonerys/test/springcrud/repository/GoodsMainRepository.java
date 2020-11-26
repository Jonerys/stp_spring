package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.GoodsMainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMainRepository extends JpaRepository<GoodsMainEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE GoodsMainEntity SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);
}
