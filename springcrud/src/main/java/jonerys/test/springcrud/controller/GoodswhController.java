package jonerys.test.springcrud.controller;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.model.GoodswhEntity;
import jonerys.test.springcrud.model.WarehousesEntity;
import jonerys.test.springcrud.repository.GoodsMainRepository;
import jonerys.test.springcrud.service.GoodsMainService;
import jonerys.test.springcrud.service.GoodswhService;
import jonerys.test.springcrud.service.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GoodswhController {

    private GoodswhService gws;
    private GoodsMainService gms;
    private WarehousesService ws;

    @Autowired
    public GoodswhController(GoodswhService gws){
        this.gws = gws;
    }

    @GetMapping("/goods-warehouses")
    public String findAll(Model model){
        List<GoodswhEntity> gwList = gws.findAll();
        model.addAttribute("gw", gwList);
        return "goods-warehouses-list";
    }

    // полная хрень которая не работает
    // суть в том, что хочу взять из двух полей в форме циферки (айдюки товара и склада),
    // найти по ним товар и склад и впихнуть их в сущность
    /*@GetMapping("/gw-create")
    public String createGoodForm(@ModelAttribute("gw") GoodswhEntity gwe){
        return "gw-create";
    }

    @PostMapping("/gw-create/{gId}/{wId}")
    public String createGood(@ModelAttribute("gw") GoodswhEntity gwe, @PathVariable("gId") Integer gId, @PathVariable("wId") Integer wId){
        gwe.setGoodsMainByIdGd(gms.findById(gId));
        gwe.setWarehousesByIdWh(ws.findById(wId));
        gws.save(gwe);
        return "redirect:/goods-warehouses";
    }*/

    @GetMapping("/gw-delete/{id}")
    public String deleteGoodswh(@PathVariable("id") Integer id){
        gws.deleteById(id);
        return "redirect:/goods-warehouses";
    }
}
