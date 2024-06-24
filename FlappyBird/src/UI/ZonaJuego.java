
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import objetos.*;


public class ZonaJuego extends javax.swing.JFrame {
    
    static public int puntaje;
    static boolean cae = true;
    static int tCaida= 1;
    final int graveda = 1;
    final int tiempo = 20;

    Timer time;
    
    JPanel Bird = new JPanel();
    JPanel tubo1 = new JPanel();
    JPanel tubo2 = new JPanel();
    JPanel tubo3 = new JPanel();
    JPanel tubo4 = new JPanel();
    
    
    public ZonaJuego() {
        initComponents();
        puntaje = 0;
        pajaro();
        obstaculos();
        tiempoJuego();
        PuntJue.setText(Integer.toString(this.getPuntaje()));
        
    }
    private void tiempoJuego(){
        time = new Timer();
        TimerTask mov = new TimerTask() {
            @Override
            public void run() {
                fall();
                movtub();
                sifObst();
                golpea();
                puntaje();
            }
        };
        time.schedule(mov, 0, tiempo);
    }
    
    private void puntaje(){

            if (tubo1.getLocation().x == 100 || tubo3.getLocation().x == 100) {
                puntaje += 1; 
                PuntJue.setText(Integer.toString(puntaje));  
            }
    }
    private void golpea(){
                //si se chocan termina el juego
                if (hitbox(tubo1) || hitbox(tubo2) || hitbox(tubo3) || hitbox(tubo4)) {                   
                    MenuFin per = new MenuFin();
                    per.setLocationRelativeTo(null);
                    per.setVisible(true);
                    this.setVisible(false);
                    time.cancel();
                } 
         
    }
    
    
    private void obstaculos(){
       Tubo obsta = new Tubo(); 
       tubo1 = new JPanel();
       
       //tubo superior
       tubo1.setBounds(550, 0, obsta.getWith(), obsta.getHeight());
       tubo1.setBackground(obsta.getColor());
       Fondo.add(tubo1);
       tubo1.setVisible(true);
       
       //tubo inferior
       tubo2 = new JPanel();
       
       tubo2.setBounds(550, 600-(500-tubo1.getHeight()), obsta.getWith(), 500-tubo1.getHeight());
       tubo2.setBackground(obsta.getColor());
       Fondo.add(tubo2);
       tubo2.setVisible(true);
       
       Tubo obsta2 = new Tubo(); 
       tubo3 = new JPanel();
       
       //tubo superior
       tubo3.setBounds(550, 0, obsta2.getWith(), obsta2.getHeight());
       tubo3.setBackground(obsta2.getColor());
       Fondo.add(tubo3);
       
       
       //tubo inferior
       tubo4 = new JPanel();
       
       tubo4.setBounds(550, 600-(500-tubo3.getHeight()), obsta2.getWith(), 500-tubo3.getHeight());
       tubo4.setBackground(obsta2.getColor());
       Fondo.add(tubo4);
       
       tubo3.setVisible(false);
       tubo4.setVisible(false);
       
    }
        
    private void sifObst(){
        //cuando salgan los tibos se moveran y se deben redimensionar
                if (tubo2.getLocation().x <= -50) {
                    Tubo obsta = new Tubo();
                    tubo1.setSize(50, obsta.getHeight());
                    tubo2.setBounds(600, 600-(500-tubo1.getHeight()), obsta.getWith(), 500-tubo1.getHeight());
                    tubo1.setLocation(600, tubo1.getLocation().y);
                    tubo2.setLocation(600, tubo2.getLocation().y);

                } 
                //se crean otros obtaculos en medio juego
                if(tubo1.getLocation().x == 250 || tubo1.getLocation().x == 251){
                    tubo3.setVisible(true);
                    tubo4.setVisible(true);
                }
                //se mueven al inicio y redimensionan
                if (tubo3.getLocation().x <= -50) {
                    Tubo obsta = new Tubo();
                    tubo3.setSize(50, obsta.getHeight());
                    tubo4.setBounds(600, 600-(500-tubo3.getHeight()), obsta.getWith(), 500-tubo3.getHeight());
                    tubo3.setLocation(600, tubo3.getLocation().y);
                    tubo4.setLocation(600, tubo4.getLocation().y);
                }     
    }
    private void pajaro(){
       Pajaro bird = new Pajaro();
       Bird = new JPanel();
       Bird.setBounds(100, 100, bird.getWith(), bird.getHeight());
       Bird.setBackground(bird.getColor());
       Fondo.add(Bird);
       Bird.setVisible(true);        
    }
    
    private boolean hitbox(JPanel objeto){
        boolean hit = false;
        if (Bird.getLocation().x > objeto.getLocation().x+objeto.getWidth()||
            Bird.getLocation().x + Bird.getWidth() < objeto.getLocation().x ||
            Bird.getLocation().y > objeto.getLocation().y + objeto.getHeight() ||
            Bird.getLocation().y + Bird.getHeight() < objeto.getLocation().y) {
            
        } else {
            hit = true;
            this.setVisible(false);
            this.dispose();
            System.gc();
        }
        
        return hit;
    }
    
    private void fall() {                
                if (cae) {
                    //si cae mucho que se quede en lo bajo
                    if (Bird.getLocation().y < 511) {
                        Bird.setLocation(Bird.getLocation().x, Bird.getLocation().y +1+ graveda*tCaida);  
                        tCaida++; 
                    } else {
                        Bird.setLocation(Bird.getLocation().x, 511);
                    }
                }
                
            }
  
    private void movtub() {

                tubo1.setLocation(tubo1.getLocation().x-4, tubo1.getLocation().y);
                tubo2.setLocation(tubo2.getLocation().x-4, tubo2.getLocation().y);
                if (tubo3.isVisible()) {
                    tubo3.setLocation(tubo3.getLocation().x-4, tubo3.getLocation().y);
                    tubo4.setLocation(tubo4.getLocation().x-4, tubo4.getLocation().y);
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

        Fondo = new javax.swing.JPanel();
        PuntJue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        Fondo.setBackground(new java.awt.Color(0, 204, 204));
        Fondo.setPreferredSize(new java.awt.Dimension(600, 600));

        PuntJue.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        PuntJue.setText("jLabel1");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(PuntJue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PuntJue)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        int key = evt.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_SPACE :
                if (Bird.getLocation().y <0) {
                    Bird.setLocation(Bird.getLocation().x, 0);
                }
                for (int i = 0; i < 10; i++) {
                    Bird.setLocation(Bird.getLocation().x, Bird.getLocation().y - 2);
                }
                
                tCaida= 1;
                cae = false;
                break;
                
        }        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        //caundo no se presiona una tecla entonces se caee
        cae = true;
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

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
            java.util.logging.Logger.getLogger(ZonaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZonaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZonaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZonaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZonaJuego().setVisible(true);
            }
        });
    }

    public static int getPuntaje() {
        return puntaje;
    }

    public static void setPuntaje(int puntaje) {
        ZonaJuego.puntaje = puntaje;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel PuntJue;
    // End of variables declaration//GEN-END:variables
}
