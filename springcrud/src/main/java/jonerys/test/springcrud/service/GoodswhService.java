package jonerys.test.springcrud.service;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.model.GoodswhEntity;
import jonerys.test.springcrud.model.WarehousesEntity;
import jonerys.test.springcrud.repository.GoodswhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodswhService {
    private final GoodswhRepository goodswhRepository;
    @Autowired
    public GoodswhService(GoodswhRepository gwr){
        goodswhRepository = gwr;
    }

    public List<GoodswhEntity> findAllInThisWarehouse(Integer id){
        return goodswhRepository.findAllInThisWarehouse(id);
    }

    public GoodswhEntity findById(String id){
        return goodswhRepository.getOne(Integer.parseInt(id));
    }

    public List<GoodswhEntity> findAll(){
        return goodswhRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public GoodswhEntity save(GoodswhEntity gwe){
        return goodswhRepository.save(gwe);
    }

    public void update(Integer id, GoodsMainEntity gme, WarehousesEntity we){
        goodswhRepository.update(id, gme, we);
    }

    public void deleteById(Integer id){
        goodswhRepository.deleteById(id);
    }
}
