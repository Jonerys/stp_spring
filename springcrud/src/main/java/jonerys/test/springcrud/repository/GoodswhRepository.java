package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.GoodsMain;
import jonerys.test.springcrud.model.Goodswh;
import jonerys.test.springcrud.model.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodswhRepository extends JpaRepository<Goodswh, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Goodswh SET goodsMainByIdGd = :ng, warehousesByIdWh = :nw WHERE id = :id")
    void update(@Param("id") Integer id, @Param("ng") GoodsMain gme, @Param("nw") Warehouses we);

    @Query("FROM Goodswh WHERE warehousesByIdWh.id = :id_wh ORDER BY id ASC")
    List<Goodswh> findAllInThisWarehouse(@Param("id_wh") Integer id);
}
