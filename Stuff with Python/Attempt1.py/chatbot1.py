import openai
import speech_recognition as sr
import pyttsx3

#chat gpt api key and txt file that creates personality of bot
key = 'sk-'
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


#asks the user for inputs continuously until ended
while True:
    with mic as source:
        print("\nListening...")
        r.adjust_for_ambient_noise(source, duration=0.5)
        audio = r.listen(source)
        try:
            user_input = r.recognize_whisper(audio)
        except:
            continue

    user_input = input('Whats on your mind: ')

    messages.append({"role": "user", "content": user_input})

    completion = openai.chat.completions.create(
        model="gpt-3.5-turbo",
        messages = messages,
        temperature = 0.8
    )

    response = completion.choices[0].message.content
    messages.append({"role": "assistant", "content":response})
    print(f"\n{response}\n")