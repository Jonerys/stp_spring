package jonerys.test.springcrud.controller;

import jonerys.test.springcrud.model.GoodsMainEntity;
import jonerys.test.springcrud.service.GoodsMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GoodsMainController {

    private GoodsMainService gms;

    @Autowired
    public GoodsMainController(GoodsMainService gms){
        this.gms = gms;
    }

    @GetMapping("/goods")
    public String findAll(Model model){
        List<GoodsMainEntity> goodsList = gms.findAll();
        model.addAttribute("goods", goodsList);
        return "goods-list";
    }

    @GetMapping("/goods-create")
    public String createGoodForm(@ModelAttribute("good") GoodsMainEntity gme){
        return "goods-create";
    }

    @PostMapping("/goods-create")
    public String createGood(@ModelAttribute("good") GoodsMainEntity gme){
        gms.save(gme);
        return "redirect:/goods";
    }

    @GetMapping("/goods-update/{id}")
    public String updateGoodForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("good", gms.findById(id));
        return "goods-update";
    }

    @PostMapping("/goods-update")
    public String updateGood(@ModelAttribute("good") GoodsMainEntity gme){
        gms.save(gme);
        return "redirect:/goods";
    }

    @GetMapping("/goods-delete/{id}")
    public String deleteGood(@PathVariable("id") Integer id){
        gms.deleteById(id);
        return "redirect:/goods";
    }
}
