package com.abhyuday.Abhyuday.Controller;

import com.abhyuday.Abhyuday.Entities.VoiceRecording;
import com.abhyuday.Abhyuday.Service.VoiceRecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recordings")
public class VoiceRecordingController {
    @Autowired
    private VoiceRecordingService voiceRecordingService;

    @PostMapping("/upload")
    public VoiceRecording uploadRecording(@RequestBody VoiceRecording recording) {
        return voiceRecordingService.saveRecording(recording);
    }

    @GetMapping("/user/{userId}")
    public List<VoiceRecording> getUserRecordings(@PathVariable Long userId) {
        return voiceRecordingService.getUserRecordings(userId);
    }
}
