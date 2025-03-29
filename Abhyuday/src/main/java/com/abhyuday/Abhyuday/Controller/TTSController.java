package com.abhyuday.Abhyuday.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhyuday.Abhyuday.Service.TTSService;

@RestController
@RequestMapping("/api/tts")
public class TTSController {

    @Autowired
    private TTSService ttsService;

    @PostMapping("/speak")
    public String synthesizeSpeech(@RequestParam String text) {
        return ttsService.generateSpeech(text);
    }
}
