package com.example.Web_Koleso.controllers;

import com.example.Web_Koleso.dto.TireWarehouseDTO;
import com.example.Web_Koleso.models.Tire;
import com.example.Web_Koleso.servises.TireService;
import com.example.Web_Koleso.servises.WarehouseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import java.util.List;
@Validated
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

//    @PostMapping("/submit-article")
//    public String handleArticleRequest(@RequestParam("article") @NotEmpty(message = "Артикул не может быть пустым") String article, Model model) {
//        // Добавьте логику для обработки артикула
//        //model.addAttribute("error", message);
//        model.addAttribute("article", article);
//
//        // Получите список шин и добавьте его в модель
//        List<TireWarehouseDTO> tireWarehouseDTOList = tireService.findAllTiresWithQuantities(Long.valueOf(article));
//        model.addAttribute("tireWarehouseDTOList", tireWarehouseDTOList);
//
//        return "article-submit"; // Убедитесь, что это название шаблона верно
//    }

    @PostMapping("/submit-article")
    public String handleArticleRequest(@RequestParam("article") String article,
                                       Model model) {
        if (article.isEmpty()){
            model.addAttribute("error", article ="Поле не может быть пустым");
            return "/home";
        } if (article.length()>10){
            model.addAttribute("error", article="Неверный формат артикула");
            return "/home";
        }
        model.addAttribute("article", article);

        // Получите список шин и добавьте его в модель
        List<TireWarehouseDTO> tireWarehouseDTOList = tireService.findAllTiresWithQuantities(Long.valueOf(article));
        model.addAttribute("tireWarehouseDTOList", tireWarehouseDTOList);

        return "article-submit"; // Убедитесь, что это название шаблона верно
    }




    @PostMapping("/submit-name")
    public String handleNameRequest(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);

        // Добавьте логику для обработки наименования
        List<TireWarehouseDTO> tireWarehouseDTOList = tireService.findAllTiresWithName(name);
        model.addAttribute("tireWarehouseDTOList", tireWarehouseDTOList);

        return "article-submit";
    }


}