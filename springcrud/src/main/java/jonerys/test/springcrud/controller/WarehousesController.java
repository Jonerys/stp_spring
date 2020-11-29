package jonerys.test.springcrud.controller;


import jonerys.test.springcrud.model.Role;
import jonerys.test.springcrud.model.User;
import jonerys.test.springcrud.model.WarehousesEntity;
import jonerys.test.springcrud.service.UserService;
import jonerys.test.springcrud.service.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WarehousesController {

    private WarehousesService ws;
    private UserService us;

    @Autowired
    public WarehousesController(WarehousesService ws, UserService us){

        this.ws = ws;
        this.us = us;
    }

    @GetMapping("/warehouses")
    public String findAll(Model model){
        List<WarehousesEntity> warehousesList = ws.findAll();
        model.addAttribute("warehouses", warehousesList);
        return "warehouses-list";
    }

    @GetMapping("/warehouses-create")
    public String createWarehouseForm(@ModelAttribute("warehouse") WarehousesEntity we){
        return "warehouses-create";
    }

    @PostMapping("/warehouses-create")
    public String createWarehouse(@ModelAttribute("warehouse") WarehousesEntity we){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        User user = new User();
        user.setLogin(we.getName());
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole(Role.USER);
        us.save(user);
        ws.save(we);
        return "redirect:/warehouses";
    }

    @GetMapping("/warehouses-update/{id}")
    public String updateWarehouseForm(@PathVariable("id") String id, Model model){
        model.addAttribute("warehouse", ws.findById(Integer.parseInt(id)));
        return "warehouses-update";
    }

    @PostMapping("/warehouses-update")
    public String updateWarehouse(@ModelAttribute("warehouse") WarehousesEntity we){
        User user = us.findByLogin(ws.findById(we.getId()).getName());
        user.setLogin(we.getName());
        us.save(user);
        ws.save(we);
        return "redirect:/warehouses";
    }

    @GetMapping("/warehouses-delete/{id}")
    public String deleteWarehouse(@PathVariable("id") String id){
        us.deleteByLogin(ws.findById(Integer.parseInt(id)).getName());
        ws.deleteById(Integer.parseInt(id));
        return "redirect:/warehouses";
    }
}
