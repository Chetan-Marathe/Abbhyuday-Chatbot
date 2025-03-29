package com.abhyuday.Abhyuday.Service;

import com.abhyuday.Abhyuday.Entities.VoiceRecording;
import com.abhyuday.Abhyuday.Repository.VoiceRecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoiceRecordingService {
    @Autowired
    private VoiceRecordingRepository voiceRecordingRepository;

    public VoiceRecording saveRecording(VoiceRecording recording) {
        return voiceRecordingRepository.save(recording);
    }

    public List<VoiceRecording> getUserRecordings(Long userId) {
        return voiceRecordingRepository.findByUserId(userId);
    }
}
