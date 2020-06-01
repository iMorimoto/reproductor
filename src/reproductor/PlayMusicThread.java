/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author fabiruxs
 */
public class PlayMusicThread extends Thread {

    private final Player player;

    public PlayMusicThread(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        try {
            player.play();
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        }
    }

}
