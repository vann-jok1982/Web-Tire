package com.example.Web_Koleso.controllers;

import com.example.Web_Koleso.parser.KolesoParser;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {
    private final KolesoParser kolesoParser;

    public ExcelController(KolesoParser kolesoParser) {
        this.kolesoParser = kolesoParser;
    }

    @SneakyThrows
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        int available = file.getInputStream().available();

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Файл не должен быть пустым");
        }
//        // Парсинг файла (если необходимо, можно добавить логику для обработки разных типов файлов)
          kolesoParser.parseExcelFile(file.getInputStream());
        System.out.println(available);

        return ResponseEntity.ok("Проверка прошла успешно");
    }
}
