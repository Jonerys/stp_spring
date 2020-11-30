package jonerys.test.springcrud.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "goodswh", schema = "goods")
public class Goodswh {
    private int id;
    private Warehouses warehousesByIdWh;
    private GoodsMain goodsMainByIdGd;

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

        Goodswh that = (Goodswh) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "id_wh", referencedColumnName = "id", nullable = false)
    public Warehouses getWarehousesByIdWh() {
        return warehousesByIdWh;
    }

    public void setWarehousesByIdWh(Warehouses warehousesByIdWh) {
        this.warehousesByIdWh = warehousesByIdWh;
    }

    @ManyToOne
    @JoinColumn(name = "id_gd", referencedColumnName = "id", nullable = false)
    public GoodsMain getGoodsMainByIdGd() {
        return goodsMainByIdGd;
    }

    public void setGoodsMainByIdGd(GoodsMain goodsMainByIdGd) {
        this.goodsMainByIdGd = goodsMainByIdGd;
    }
}
