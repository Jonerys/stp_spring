package jonerys.test.springcrud.service;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.model.WarehousesEntity;
import jonerys.test.springcrud.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousesService {
    private final WarehousesRepository warehousesRepository;

    @Autowired
    public WarehousesService(WarehousesRepository wr){
        warehousesRepository = wr;
    }

    public Integer findIdByName(String name) { return warehousesRepository.findIdByName(name); }

    public WarehousesEntity findByName(String name) { return warehousesRepository.findByName(name); }

    public WarehousesEntity findById(Integer id){
        return warehousesRepository.getOne(id);
    }

    public List<WarehousesEntity> findAll(){
        return warehousesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public WarehousesEntity save(WarehousesEntity we){
        return warehousesRepository.save(we);
    }

    public void updateById(Integer id, String name) {
        warehousesRepository.update(id, name);
    }

    public void deleteById(Integer id) {
        warehousesRepository.deleteById(id);
    }
}
