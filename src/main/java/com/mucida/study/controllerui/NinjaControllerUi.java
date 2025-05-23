package com.mucida.study.controllerui;

import com.mucida.study.model.dto.NinjaDTO;
import com.mucida.study.service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/getninjas")
    public String getNinjas(Model model) {
        model.addAttribute("ninjas", ninjaService.getAllNinjas());
        return "getNinjas";
    }

    @GetMapping("/deleteninja/{id}")
    public String deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/getninjas";
    }

    @GetMapping("/getninjas/{id}")
    public String getNinjaById(@PathVariable Long id, Model model) {
        model.addAttribute("ninja", ninjaService.getNinjaById(id));
        return "detalhesNinja";
    }

    @GetMapping("/addninja")
    public String addNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "addNinja";
    }

    @PostMapping("/saveninja")
    public String saveNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.addNinja(ninja);
        return "redirect:/ninjas/ui/getninjas";
    }
}
