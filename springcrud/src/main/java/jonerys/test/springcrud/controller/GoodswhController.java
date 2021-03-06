package jonerys.test.springcrud.controller;

import jonerys.test.springcrud.model.GoodsMain;
import jonerys.test.springcrud.model.Goodswh;
import jonerys.test.springcrud.model.Warehouses;
import jonerys.test.springcrud.service.GoodsMainService;
import jonerys.test.springcrud.service.GoodswhService;
import jonerys.test.springcrud.service.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodswhController {

    private GoodswhService gws;
    private GoodsMainService gms;
    private WarehousesService ws;

    @Autowired
    public GoodswhController(GoodswhService gws, GoodsMainService gms, WarehousesService ws){
        this.gws = gws;
        this.gms = gms;
        this.ws = ws;
    }

    @GetMapping("/goods-warehouses")
    public String findAll(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        Integer id = ws.findIdByName(username);
        List<Goodswh> gwList = gws.findAllInThisWarehouse(id);
        model.addAttribute("gw", gwList);
        return "goods-warehouses-list";
    }

    @GetMapping("/gw-create")
    public String createGoodForm(@ModelAttribute("gw") Goodswh gwe, Model model){
        model.addAttribute("goods", gms.findAll());
        return "gw-create";
    }

    @PostMapping("/gw-create")
    public String createGoodswh(@RequestParam("good") String goodName){
        GoodsMain gme = gms.findByName(goodName);
        Warehouses we = ws.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        Goodswh gwe = new Goodswh();
        gwe.setGoodsMainByIdGd(gme);
        gwe.setWarehousesByIdWh(we);
        gws.save(gwe);
        return "redirect:/goods-warehouses";
    }

    @GetMapping("/gw-update/{id}")
    public String updateGoodswhForm(@PathVariable("id") String id, Model model){
        model.addAttribute("goods", gms.findAll());
        model.addAttribute("gw", gws.findById(id));
        model.addAttribute("id", id);
        return "gw-update";
    }

    @PostMapping("/gw-update")
    public String updateGoodswh(@RequestParam("id") String id, @RequestParam("good") String goodName){
        GoodsMain gme = gms.findByName(goodName);
        Warehouses we = ws.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        Goodswh gwe = gws.findById(id);
        gwe.setGoodsMainByIdGd(gme);
        gwe.setWarehousesByIdWh(we);
        gws.save(gwe);
        return "redirect:/goods-warehouses";
    }



    @GetMapping("/gw-delete/{id}")
    public String deleteGoodswh(@PathVariable("id") String id){
        gws.deleteById(Integer.parseInt(id));
        return "redirect:/goods-warehouses";
    }
}
