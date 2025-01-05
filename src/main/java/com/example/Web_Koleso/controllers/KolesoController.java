package com.example.Web_Koleso.controllers;

import com.example.Web_Koleso.dto.TireWarehouseDTO;
import com.example.Web_Koleso.servises.TireService;
import com.example.Web_Koleso.servises.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping()
public class KolesoController {

    @Autowired
    private TireService tireService;
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/tire")
    public String SpisokAll(Model model) {
        model.addAttribute("tire", tireService.findAllTires());
        return "tire-spisok";
    }
    @GetMapping("/ware_house")
    public String Spisok(Model model) {
        model.addAttribute("wareHouse", warehouseService.findAllWarehouses() );
        return "warehouse-spisok";
    }

    @GetMapping("/home")
    public String Home() {
        return "home";
    }

    @PostMapping("/submit-article")
    public String handleArticleRequest(@RequestParam("article") String article, Model model) {
        //Логика обработки введеных значений в поле.
        if(article.isEmpty()){
            model.addAttribute("errorArticle", article = "Поле не может быть пустым");
            return "home";
        } if(article.length()>10){
            model.addAttribute("errorArticle", article="Поле не может быть более 10ти символов");
            return "home";
        }
        // Добавьте логику для обработки артикула
        model.addAttribute("article", article);

        // Получите список шин и добавьте его в модель
        List<TireWarehouseDTO> tireWarehouseDTOList = tireService.findAllTiresWithQuantities(Long.valueOf(article));
        model.addAttribute("tireWarehouseDTOList", tireWarehouseDTOList);

        return "article-submit"; // Убедитесь, что это название шаблона верно
    }


    @PostMapping("/submit-name")
    public String handleNameRequest(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        //Логика обработки введеных значений в поле.
        if(name.isEmpty()){
            model.addAttribute("errorName", name = "Поле не может быть пустым");
            return "home";
        } if(name.length()>12){
            model.addAttribute("errorName", name="Поле не может быть более 12ти символов");
            return "home";
        }
        // Добавьте логику для обработки наименования
        List<TireWarehouseDTO> tireWarehouseDTOList = tireService.findAllTiresWithName(name);
        model.addAttribute("tireWarehouseDTOList", tireWarehouseDTOList);

        return "article-submit";
    }
}