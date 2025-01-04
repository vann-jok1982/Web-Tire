package com.example.Web_Koleso.controllers;

import com.example.Web_Koleso.parser.KolesoParser;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;

@RestController
public class ExcelController {
    private final KolesoParser kolesoParser;

    public ExcelController(KolesoParser kolesoParser) {
        this.kolesoParser = kolesoParser;
    }

//    @SneakyThrows
//    @PostMapping("/upload")
//    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
//        int available = file.getInputStream().available();
//
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Файл не должен быть пустым");
//        }
////        // Парсинг файла (если необходимо, можно добавить логику для обработки разных типов файлов)
//        kolesoParser.parseExcelFile(file.getInputStream());
//        System.out.println(available);
//
//        return ResponseEntity.ok("Проверка прошла успешно");
//    }

@PostMapping("/upload")
public ModelAndView upload(@RequestParam("file") MultipartFile file) throws IOException {
    ModelAndView modelAndView = new ModelAndView();


    if (file.isEmpty()) {
        modelAndView.setViewName("errorPage"); // Укажите название вашей страницы ошибки
        modelAndView.addObject("message", "Файл не должен быть пустым");
        return modelAndView;
    }

    // Парсинг файла
    kolesoParser.parseExcelFile(file.getInputStream());

    // Успешный переход
    modelAndView.setViewName("success"); // Укажите название страницы успеха
    modelAndView.addObject("message", "Проверка прошла успешно");
    return modelAndView;
}
//@PostMapping("/upload")
//public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
//    if (file.isEmpty()) {
//        return ResponseEntity.badRequest().body("Файл не должен быть пустым");
//    }
//
//    // Парсинг файла
//    kolesoParser.parseExcelFile(file.getInputStream());
//
//    // Перенаправление на другую страницу
//    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/success")).build();
//}
//    @GetMapping("/success")
//    public String ShowSuccessPage() {
//        return "success";
//    }

}
