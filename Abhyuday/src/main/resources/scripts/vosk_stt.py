import sys
import wave
import json
from vosk import Model, KaldiRecognizer

# Load VOSK model (Update path)
model_path = "vosk-model-small-en-in-0.4"
model = Model(model_path)

def transcribe_audio(audio_path):
    wf = wave.open(audio_path, "rb")
    rec = KaldiRecognizer(model, wf.getframerate())

    while True:
        data = wf.readframes(4000)
        if len(data) == 0:
            break
        rec.AcceptWaveform(data)

    result = json.loads(rec.Result())
    return result["text"]

if __name__ == "__main__":
    audio_file = sys.argv[1]  # Get file path from command line
    print(transcribe_audio(audio_file))
