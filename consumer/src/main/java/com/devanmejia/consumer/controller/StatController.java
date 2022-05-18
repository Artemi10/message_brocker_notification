package com.devanmejia.consumer.controller;

import com.devanmejia.consumer.service.stat.StatService;
import com.devanmejia.consumer.transfer.response.StatDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/stats")
public class StatController {
    private final StatService statService;

    @GetMapping
    public List<StatDTO> getAllStats(){
        return statService.getAllStats().stream()
                .map(StatDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/email/{email}")
    public StatDTO getStatByEmail(@PathVariable String email){
        var stat = statService.getStatByEmail(email);
        return new StatDTO(stat);
    }
}
