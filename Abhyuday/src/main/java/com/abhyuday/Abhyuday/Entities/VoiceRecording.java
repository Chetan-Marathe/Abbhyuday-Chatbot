package com.abhyuday.Abhyuday.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "voice_recordings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoiceRecording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String filePath;
    private Boolean processed = false;
    private LocalDateTime uploadedAt = LocalDateTime.now();
}

