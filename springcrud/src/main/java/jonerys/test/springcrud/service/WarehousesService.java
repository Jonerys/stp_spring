package jonerys.test.springcrud.service;

import jonerys.test.springcrud.model.Warehouses;
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

    public Warehouses findByName(String name) { return warehousesRepository.findByName(name); }

    public Warehouses findById(Integer id){
        return warehousesRepository.getOne(id);
    }

    public List<Warehouses> findAll(){
        return warehousesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Warehouses save(Warehouses we){
        return warehousesRepository.save(we);
    }

    public void updateById(Integer id, String name) {
        warehousesRepository.update(id, name);
    }

    public void deleteById(Integer id) {
        warehousesRepository.deleteById(id);
    }
}
