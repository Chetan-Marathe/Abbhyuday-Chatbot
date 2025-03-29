package com.abhyuday.Abhyuday.Repository;

import com.abhyuday.Abhyuday.Entities.VoiceRecording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoiceRecordingRepository extends JpaRepository<VoiceRecording,Long> {
    List<VoiceRecording> findByUserId(Long userId);
}
