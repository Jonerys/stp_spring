package jonerys.test.springcrud.service;

import jonerys.test.springcrud.model.GoodsMain;
import jonerys.test.springcrud.model.Goodswh;
import jonerys.test.springcrud.model.Warehouses;
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

    public List<Goodswh> findAllInThisWarehouse(Integer id){
        return goodswhRepository.findAllInThisWarehouse(id);
    }

    public Goodswh findById(String id){
        return goodswhRepository.getOne(Integer.parseInt(id));
    }

    public List<Goodswh> findAll(){
        return goodswhRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Goodswh save(Goodswh gwe){
        return goodswhRepository.save(gwe);
    }

    public void update(Integer id, GoodsMain gme, Warehouses we){
        goodswhRepository.update(id, gme, we);
    }

    public void deleteById(Integer id){
        goodswhRepository.deleteById(id);
    }
}
