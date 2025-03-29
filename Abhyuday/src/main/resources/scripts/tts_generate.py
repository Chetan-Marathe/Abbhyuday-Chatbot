import sys
from TTS.api import TTS

tts = TTS("tts_models/en/ljspeech/tacotron2-DDC", progress_bar=False)
text = sys.argv[1]
tts.tts_to_file(text=text, file_path="output.wav")
print("Generated speech saved as output.wav")
