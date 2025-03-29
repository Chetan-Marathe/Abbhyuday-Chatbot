package com.abhyuday.Abhyuday.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class TTSService {
    public String generateSpeech(String text) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "tts_generate.py", text);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return "Generated speech saved as output.wav";
        } catch (Exception e) {
            return "Error generating speech.";
        }
    }
}