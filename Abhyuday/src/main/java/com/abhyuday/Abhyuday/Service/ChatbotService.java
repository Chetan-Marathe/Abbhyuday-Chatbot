package com.abhyuday.Abhyuday.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    
    public String getChatResponse(String userInput) {
        try {
            // Run Ollama model with user input
            ProcessBuilder pb = new ProcessBuilder("ollama", "run", "tinyllama", userInput);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        } catch (Exception e) {
            return "Error processing chatbot request.";
        }
    }
}
