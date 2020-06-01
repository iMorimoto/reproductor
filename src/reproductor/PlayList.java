/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author fabiruxs
 */
public class PlayList {

    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private JFileChooser jFileChooser = new JFileChooser();
    private ArrayList listSong = new ArrayList();

    public ArrayList getListSong() {
        return listSong;
    }

    /**
     * Método para agregar un archivo mp3 a la playlist
     *
     * @param frame
     */
    public void add(JFrame frame) {

        jFileChooser.setMultiSelectionEnabled(false);
        int fileValid = jFileChooser.showOpenDialog(frame);
        switch (fileValid) {
            case JFileChooser.APPROVE_OPTION:
                File file = jFileChooser.getSelectedFile();
                listSong.add(file);
                
            default:
        }
    }

    /**
     * Método para agregar multiples archivos mp3 a la playlist
     * @param frame 
     */
    public void openDirectory(JFrame frame) {
        jFileChooser.setMultiSelectionEnabled(true);
        int jfcState = jFileChooser.showOpenDialog(frame);

        switch (jfcState) {
            case JFileChooser.APPROVE_OPTION:
                File[] files = jFileChooser.getSelectedFiles();
                listSong.addAll(Arrays.asList(files));
               

            default:
        }
    }

}
