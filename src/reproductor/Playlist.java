/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fabiruxs
 */
public class Playlist {

    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private JFileChooser jFileChooser = new JFileChooser();
    protected ArrayList listSong = new ArrayList();

    public ArrayList getListSong() {
        return listSong;
    }

    /**
     * Método para agregar un archivo mp3 a la playlist
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

        /*if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;

        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {

            File[] file = jFileChooser.getSelectedFiles();
            listSong.addAll(Arrays.asList(file));

        }*/
    }

    public void saveAsPlaylist(JFrame frame) {

        jFileChooser.setMultiSelectionEnabled(false);

        int Valid = jFileChooser.showSaveDialog(frame);

        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {

            return;

        } else if (Valid == javax.swing.JFileChooser.APPROVE_OPTION) {

            File pls = jFileChooser.getSelectedFile();

            try {
                fos = new FileOutputStream(pls + ".tgr");
                oos = new ObjectOutputStream(fos);

                for (int i = 0; i < listSong.size(); i++) {
                    File tmp = (File) listSong.get(i);
                    oos.writeObject(tmp);

                }
                oos.close();

            } catch (Exception e) {

            }

        }

    }

    public void openDirectory(JFrame frame) {

        jFileChooser.setCurrentDirectory(new File("."));
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       jFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Filtro", "mp3");
        jFileChooser.addChoosableFileFilter(filter);
        
        int jfcState = jFileChooser.showOpenDialog(frame);
        
        
        
        /*jFileChooser.setMultiSelectionEnabled(false);
        int Valid = jFileChooser.showOpenDialog(frame);

        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {

            File pls = jFileChooser.getSelectedFile();

            try {
                fis = new FileInputStream(pls);
                ois = new ObjectInputStream(fis);
                File tmp;

                while ((tmp = (File) ois.readObject()) == null) {
                    listSong.add(tmp);

                }

                if ((tmp = (File) ois.readObject()) == null) {
                    listSong.isEmpty();

                }
                ois.close();

            } catch (Exception e) {
            }

        } else {
        }*/

    }

}
