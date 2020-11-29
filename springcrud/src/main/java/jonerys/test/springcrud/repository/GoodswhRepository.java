package jonerys.test.springcrud.repository;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.model.GoodswhEntity;
import jonerys.test.springcrud.model.WarehousesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodswhRepository extends JpaRepository<GoodswhEntity, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE GoodswhEntity SET goodsMainByIdGd = :ng, warehousesByIdWh = :nw WHERE id = :id")
    void update(@Param("id") Integer id, @Param("ng") GoodsMainEntity gme, @Param("nw")WarehousesEntity we);

    @Query("FROM GoodswhEntity WHERE warehousesByIdWh.id = :id_wh ORDER BY id ASC")
    List<GoodswhEntity> findAllInThisWarehouse(@Param("id_wh") Integer id);
}
