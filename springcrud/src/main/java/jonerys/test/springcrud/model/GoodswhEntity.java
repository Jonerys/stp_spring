package jonerys.test.springcrud.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "goodswh", schema = "goods")
public class GoodswhEntity {
    private int id;
    private WarehousesEntity warehousesByIdWh;
    private GoodsMainEntity goodsMainByIdGd;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodswhEntity that = (GoodswhEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "id_wh", referencedColumnName = "id", nullable = false)
    public WarehousesEntity getWarehousesByIdWh() {
        return warehousesByIdWh;
    }

    public void setWarehousesByIdWh(WarehousesEntity warehousesByIdWh) {
        this.warehousesByIdWh = warehousesByIdWh;
    }

    @ManyToOne
    @JoinColumn(name = "id_gd", referencedColumnName = "id", nullable = false)
    public GoodsMainEntity getGoodsMainByIdGd() {
        return goodsMainByIdGd;
    }

    public void setGoodsMainByIdGd(GoodsMainEntity goodsMainByIdGd) {
        this.goodsMainByIdGd = goodsMainByIdGd;
    }
}
