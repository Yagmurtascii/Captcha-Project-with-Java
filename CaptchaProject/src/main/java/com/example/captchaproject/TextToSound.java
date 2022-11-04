package com.example.captchaproject;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

public class TextToSound {

    public void converToText(String word) {

        try {
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            for (int i = 0; i < word.length(); i++)
                synthesizer.speakPlainText(String.valueOf(word.charAt(i)), null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AudioException e) {
            e.printStackTrace();
        } catch (EngineException e) {
            e.printStackTrace();
        }
    }
}

