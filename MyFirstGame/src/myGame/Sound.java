package myGame;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

    private final AudioClip clip;
    private Sound(String name) {
        clip = Applet.newAudioClip(Sound.class.getResource(name));
    }
    public static final Sound shoot = new Sound("/shotLaser.wav");
    public static final Sound startMenuSong = new Sound("/StarWarsMainSong.wav");
    public static final Sound battleSong = new Sound("/FinalFantasyBattleThemeSong.wav");
    public static final Sound MainShipExplosion = new Sound("/MatrixBombExplosion.wav");
    public static final Sound destroyedShipExplosion = new Sound("/SmallExplosion2.wav");


    public void play() {
        clip.play();
    }

    public void loop() {
        clip.loop();
    }

    public void stop() {
        clip.stop();
    }


}
