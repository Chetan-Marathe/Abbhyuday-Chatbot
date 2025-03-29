package com.abhyuday.Abhyuday.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stt")
public class STTController {

    @PostMapping("/transcribe")
    public String transcribeAudio(@RequestParam("file") File audioFile) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "vosk_stt.py", audioFile.getAbsolutePath());
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (Exception e) {
            return "Error processing audio";
        }
    }
}
