/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javazoom.jl.player.Player;

/**
 *
 * @author fabiruxs
 */
public class Reproductor extends javax.swing.JFrame {
    
    Playlist playList=new Playlist();
    
    ArrayList updateList= new ArrayList();
    
    Player player;
    File simpan;
    

    /**
     * Constructor Reproductor
     */
    public Reproductor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    void updateList(){
    
        updateList=playList.getListSong();
        DefaultListModel model=new DefaultListModel();
        
        for(int i=0;i<updateList.size();i++)
            {
                int j=1+1;
                model.add(i,j + " | " + ((File) updateList.get(i)).getName());
                
                
            }
        jPlaylist.setModel(model);
           
    }
    
    public void add(){
    
        playList.add(this);
        updateList();
    }
    
    void remove(){
    
        try {
              int memoherdez=jPlaylist.getLeadSelectionIndex();
              playList.listSong.remove(memoherdez);
              updateList();
            
        } catch (Exception e) {
        }
        
    }

     void up(){
    
         try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)playList.listSong.get(s1);
                playList.listSong.remove(s1);
                playList.listSong.add(s1-1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1-1);
             
         } catch (Exception e) {
         }
        
    }
     
      void down(){
          
          try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)playList.listSong.get(s1);
                playList.listSong.remove(s1);
                playList.listSong.add(s1+1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1+1);
             
         } catch (Exception e) {
         }
        
    }
      
      void open(){
    
        playList.openDirectory(this);
        updateList();
    }
      
      void save(){
    
       playList.saveAsPlaylist(this);
       updateList();
    }
      
      File play1;
      static int a=0;
      
      void play(){
      
          if(a==0)
             {
                 try {
                        int p1=jPlaylist.getSelectedIndex();
                        play1=(File)this.updateList.get(p1);
                        FileInputStream fis=new FileInputStream(play1);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 play();
                  
              }
          
      }
      
      File sa;
      void next(){
      
      if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()+1;
                        sa=(File)this.playList.listSong.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 next();
                  
              }    
          
      }
      
      void previous(){
      
             if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()-1;
                        sa=(File)this.playList.listSong.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 previous();
                  
              } 
          
      }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnadd = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btndown = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btnopen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        btnprevius = new javax.swing.JButton();
        btnplay = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnstop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnadd.setToolTipText("Agregar canción");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove.png"))); // NOI18N
        btnremove.setToolTipText("Eliminar canción");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        btndown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow_down.png"))); // NOI18N
        btndown.setToolTipText("Baja una canción de posición");
        btndown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndownActionPerformed(evt);
            }
        });

        btnup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrow_up.png"))); // NOI18N
        btnup.setToolTipText("Sube una canción de posición");
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });

        btnopen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/open_folder.png"))); // NOI18N
        btnopen.setToolTipText("Seleccionar carpeta");
        btnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopenActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jPlaylist);

        btnprevius.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/previous.png"))); // NOI18N
        btnprevius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviusActionPerformed(evt);
            }
        });

        btnplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N
        btnplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplayActionPerformed(evt);
            }
        });

        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next.png"))); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnstop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stop.png"))); // NOI18N
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btndown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnopen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnadd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnremove))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnprevius, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnplay, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnstop, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnremove)
                    .addComponent(btnadd)
                    .addComponent(btnopen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndown))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnstop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnplay, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnprevius, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplayActionPerformed
        play();
    }//GEN-LAST:event_btnplayActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       playList.add(this);
       updateList();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        remove();
    }//GEN-LAST:event_btnremoveActionPerformed

    private void btnpreviusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviusActionPerformed
        previous();
    }//GEN-LAST:event_btnpreviusActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        next();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        up();
    }//GEN-LAST:event_btnupActionPerformed

    private void btndownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndownActionPerformed
       down();
    }//GEN-LAST:event_btndownActionPerformed

    private void btnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopenActionPerformed
        open();
    }//GEN-LAST:event_btnopenActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        player.close();
        
    }//GEN-LAST:event_btnstopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndown;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnopen;
    private javax.swing.JButton btnplay;
    private javax.swing.JButton btnprevius;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnstop;
    private javax.swing.JButton btnup;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel DefaultListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
