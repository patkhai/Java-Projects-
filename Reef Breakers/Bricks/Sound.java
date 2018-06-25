
package Bricks;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author patkhai
 */
public class Sound {

//Game sounds are played using Orcale library and some help from stackover flow
   
    public static final Sound sounds = new Sound();

    /**
     *
     * @param filename
     */
    public static void playLoop(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Game.class.getResource(filename)));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    /**
     *
     * @param filename
     */
    public static void playClip(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Game.class.getResource(filename)));
            clip.loop(0);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
}
