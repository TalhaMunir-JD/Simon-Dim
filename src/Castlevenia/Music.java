package Castlevenia;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	public void PlayMusic(String musiclocation) {
		try {

			File musicpath = new File(musiclocation);
			if(musicpath.exists()) {            //it will check if the path exists if then play the music otherwise show the message file not found
				AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicpath);   
				Clip clip = AudioSystem.getClip();
				clip.open(audioinput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);

			}else {
				System.out.println("File not found");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
