import os
from openai import OpenAI

import openai
import speech_recognition as sr
import pyttsx3

personality = "personality.txt"

#reads txt file
with open(personality, "r") as file:
    mode = file.read()

messages = [
    {"role": "system", "content": f"{mode}"}
]

engine = pyttsx3.init()
voice = engine.getProperty('voices')
engine.setProperty('voice', voice[0].id) #0 for male, 1 for female

r = sr.Recognizer()
mic = sr.Microphone(device_index=0) #0 equals default mic
r.dynamic_energy_threshold=False
r.energy_threshold = 400

def whisper(audio):
    print("entered whisper")
    #how to do it with temp. file?
    with open('speech.wav', 'wb') as f:
        f.write(audio.get_wav_data())
    speech = open('speech.wav', 'rb')
    print("about to transcribe")
    wcompletion = openai.audio.transcriptions.create(
        model = "whisper-1",
        file = speech)
    print("should have transcribed")
    user_input = wcompletion['text']
    print(user_input) #to check what it picks up
    return user_input

#asks the user for inputs continuously until ended
while True:
    print("in loop")
    with mic as source:
        print("\nListening...")
        r.adjust_for_ambient_noise(source, duration=0.5)
        audio = r.listen(source)
        print("after listening")
        try:
            user_input = whisper(audio)
            print("whisper called")
            print("User input = "+ user_input)
        except openai.OpenAIError as e:
            print(f"error: {e}")
            print("exception occur, continueing with listening loop")
            #has to be way to check error, --> look up different options
            continue
    print("TEST")
    messages.append({"role": "user", "content": user_input})

    completion = openai.chat.completions.create(
        model="gpt-3.5-turbo",
        messages = messages,
        temperature = 0.8
    )

    response = completion.choices[0].message.content
    messages.append({"role": "assistant", "content":response})
    print(f"\n{response}\n")
    engine.say(f'{response}')
    engine.runAndWait()