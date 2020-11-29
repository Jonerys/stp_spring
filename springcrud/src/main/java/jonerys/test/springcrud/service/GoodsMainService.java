package jonerys.test.springcrud.service;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.repository.GoodsMainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsMainService {
    private final GoodsMainRepository goodsMainRepository;

    @Autowired
    public GoodsMainService(GoodsMainRepository gmr){
        goodsMainRepository = gmr;
    }

    public GoodsMainEntity findById(Integer id){
        return goodsMainRepository.getOne(id);
    }

    public GoodsMainEntity findByName(String name){
        return goodsMainRepository.findByName(name);
    }

    public List<GoodsMainEntity> findAll(){
        return goodsMainRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public GoodsMainEntity save(GoodsMainEntity gme){
        return goodsMainRepository.save(gme);
    }

    public void updateById(Integer id, String name) {
        goodsMainRepository.update(id, name);
    }

    public void deleteById(Integer id) {
        goodsMainRepository.deleteById(id);
    }
}
