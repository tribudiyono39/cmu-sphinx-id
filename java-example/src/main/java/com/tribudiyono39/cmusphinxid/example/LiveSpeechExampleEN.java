package com.tribudiyono39.cmusphinxid.example;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class LiveSpeechExampleEN {
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

		recognizer.startRecognition(true);
        while (true) {
            SpeechResult result = recognizer.getResult();
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
	}
}
