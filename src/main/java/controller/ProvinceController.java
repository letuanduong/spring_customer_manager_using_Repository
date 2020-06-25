package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProvinceService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView listProvince(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/provinces/{id}")
    public String listProvincesByIds(@PathVariable Long id, Model model){
        Long ids[] = {Long.valueOf(id), Long.valueOf(101), Long.valueOf(102)};
        Iterable<Long> iterable = Arrays.asList(ids);
        Iterable<Province> provinces = provinceService.findAllById(iterable);
        model.addAttribute("provinces", provinces);
        return "/province/list";
    }

    @GetMapping("/province/{id}")
    public String listProvincesById(@PathVariable Long id, Model model){
        Province provinces = provinceService.findById(id);
        model.addAttribute("provinces", provinces);
        return "/province/list";
    }

    @GetMapping("/province-notnull/{name}")
    public ModelAndView listProvinceNotNull(@PathVariable String name){
        ModelAndView mv = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.testMethodOfSpring(name);
        mv.addObject("provinces", provinces);
        return mv;
    }





//    @GetMapping("/provinces")
//    public ModelAndView listProvinces(){
//        Iterable<Province> provinces = provinceService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/province/list");
//        modelAndView.addObject("provinces", provinces);
//        return modelAndView;
//    }
//
//    @GetMapping("/create-province")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("/province/create");
//        modelAndView.addObject("province", new Province());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-province")
//    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
//        provinceService.save(province);
//
//        ModelAndView modelAndView = new ModelAndView("/province/create");
//        modelAndView.addObject("province", new Province());
//        modelAndView.addObject("message", "New province created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-province/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Province province = provinceService.findById(id);
//        if(province != null) {
//            ModelAndView modelAndView = new ModelAndView("/province/edit");
//            modelAndView.addObject("province", province);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-province")
//    public ModelAndView updateProvince(@ModelAttribute("province") Province province){
//        provinceService.save(province);
//        ModelAndView modelAndView = new ModelAndView("/province/edit");
//        modelAndView.addObject("province", province);
//        modelAndView.addObject("message", "Province updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-province/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Province province = provinceService.findById(id);
//        if(province != null) {
//            ModelAndView modelAndView = new ModelAndView("/province/delete");
//            modelAndView.addObject("province", province);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-province")
//    public String deleteProvince(@ModelAttribute("province") Province province){
//        provinceService.remove(province.getId());
//        return "redirect:provinces";
//    }


}
