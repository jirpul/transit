/*
 * Zde zobrazime matici s prvky mnoziny a umoznime zavest relace 
 */
package transit;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.GroupLayout.Group;

/**
 *
 * @author jiri.pulec
 */
public class VyslJFrame extends javax.swing.JFrame

 {
    javax.swing.JCheckBox jCheckBox5[][];   // pole checkboxu umoznujici naklikat pozadovynou relaci
    Boolean TransitMat[][];                 // pomocna promenna pouzita pro vypocet tranzitivniho uzaveru
    javax.swing.JLabel jLabel2[];
    javax.swing.JLabel jLabel3[];
    int length;
    int posForButton;
    
    /**
     * Vytvorime formular
     */
    
    public VyslJFrame(List<String> vstup) {
        initComponents();
        jButton2 = new javax.swing.JButton();
        prepareGrid(vstup);                      // Vytvori mrizku se zahlavimi z prvku mnoziny, ktera umozni naklikat pozadovanou relaci 
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);    // Svaze stisk tlacitka s vypoctem tranzitivniho uzaveru relace a vypisem vysledku
            }
        });
    }

    /**
     * initComponents() zde pouze vytvori informaceni label
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("zadejte relaci zaskrtnutim poli");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 468, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(List<String> vstup) {
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
            java.util.logging.Logger.getLogger(VyslJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VyslJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VyslJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VyslJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VyslJFrame vyslJFrame = new VyslJFrame(vstup);
                        vyslJFrame.setVisible(true);
            }
        });
    }
  
    
    
    public void prepareGrid(List<String> vstup){ //Zde vytvorime pole checkboxu se zahlavimi z nazvu prvku mnoziny
        length = vstup.size();
        posForButton = (length + 1) * 40;
        jButton2.setText("Vyhodnot ");

        jCheckBox5 = new javax.swing.JCheckBox[length][length];   // Vytvori pole checkboxu
        TransitMat = new Boolean[length][length];                 // Zalozi pomocnou promennou
      
        jLabel2 = new javax.swing.JLabel[length];                // pole nazvu prvku
        jLabel3 = new javax.swing.JLabel[length];                // pole nazvu prvku

        for(int i = 0 ; i < length; i++){
            for(int j = 0; j< length; j++){
             TransitMat[i][j] = new Boolean(false);

            }
        }
        
        int maxLength = 0;
        for(int i = 0; i< length; i++){
            if(maxLength < this.getFontMetrics( this.getFont()).stringWidth(vstup.get(i))){
                maxLength = this.getFontMetrics( this.getFont()).stringWidth(vstup.get(i));
            }
        }
        
        
        
        for(int i = 0; i<length ; i++){                  // Naplnime pole nazvy prvku mnoziny
              jLabel2[i]  = new javax.swing.JLabel();       
              jLabel2[i].setText(vstup.get(i));
              jLabel3[i]  = new javax.swing.JLabel();
              jLabel3[i].setText(vstup.get(i));
        }

        /*
        * Tady Vytvorime horizontalni a vertikalni zahlavi
        */
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        int pos = maxLength + 10;
        for(int k = 0; k<length ;k++){

            Group u;
            u = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);   
            u.addComponent(jLabel3[k]);
            
                        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(pos,pos, pos)
                    .addGroup(u)
                    .addContainerGap(21, Short.MAX_VALUE))
            );
                        
            Group t;
            t = layout.createSequentialGroup().addGap(40,40,40);
            t.addComponent(jLabel3[k]);
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(t)
            );
            pack();   
            pos = pos + 10 + this.getFontMetrics( this.getFont()).stringWidth(vstup.get(k));
        }
        Group x;
        x = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        
        for(int k = 0; k<length ;k++){
           x.addComponent(jLabel2[k]);
        }
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(x)
                .addGap(20, 20, 20)

                .addContainerGap(500, Short.MAX_VALUE))
        );
        
        
        Group y;
        y = layout.createSequentialGroup().addGap(60,60,60);;
        for(int k = 0; k<length ;k++){
            y.addComponent(jLabel2[k]);
            y.addGap(20);
        }

            //h.addContainerGap(108, Short.MAX_VALUE);
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(y)
        );
        pack();
               
        
        /*
        * A nasledne umistime jednotlive checkboxy
        */
       
        pos = maxLength + 10;
        for(int j =0; j<length;j++){
            
            Group g;
            g = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);

            Group h;
            h = layout.createSequentialGroup().addGap(60,60,60);
            
            for(int i = 0; i<length ; i++){
                jCheckBox5[i][j] = new javax.swing.JCheckBox();
            }

            for(int k = 0; k<length ;k++){
                g.addComponent(jCheckBox5[k][j]);
            }
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(pos, pos, pos)
                    .addGroup(g)
                    .addContainerGap(21, Short.MAX_VALUE))
            );

            for(int k = 0; k<length ;k++){
                h.addComponent(jCheckBox5[k][j]);
                h.addGap(20);
            }
            //h.addContainerGap(108, Short.MAX_VALUE);
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h)
            );
            pos = pos + 10 + this.getFontMetrics( this.getFont()).stringWidth(vstup.get(j));
            pack();
        }
            Group r;
            
            r = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);   
            r.addComponent(jButton2);
            
                        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(pos,pos, pos)
                    .addGroup(r)
                    .addContainerGap(21, Short.MAX_VALUE))
            );
            Group s;
            s = layout.createSequentialGroup().addGap(posForButton +30,posForButton +30,posForButton + 30);
            s.addComponent(jButton2);
            layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                     .addContainerGap(posForButton, Short.MAX_VALUE)
                     .addGroup(s).addContainerGap())
            );
            pack(); 
    }
    
    /*
    * Vypocte tranzitivni uzaver relace a vypise vysledek
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {     
 
        // nejprve naplnime pomocnou promennou
        
        for (int i = 0; i < length; i ++){
            for (int j = 0; j < length; j ++){
                TransitMat[i][j] = jCheckBox5[i][j].isSelected();
            }
        }
        
        // pro kontrolu vypiseme
        
        for (int i = 0; i < length; i ++){
            for (int j = 0; j < length; j ++){
                if(TransitMat[i][j])
                    System.out.print(" 1 ");
                else
                    System.out.print(" 0 ");
            }
                System.out.print(" \r\n ");
        }

        transitiveClosureComputation();    // Vypocte tranzitivni uzaver warshallovym algoritmem
        
        // pro kontrolu vypiseme
        
        for (int i = 0; i < length; i ++){
            for (int j = 0; j < length; j ++){
                if(TransitMat[i][j])
                    System.out.print(" 1 ");
                else
                    System.out.print(" 0 ");
            }
                System.out.print(" \r\n ");
        }
        displayTransitiveClosure();        // vypise vystup do mrizky
    } 

    
    /*
    * Tranzitivni uzaver
    */    
     
    void transitiveClosureComputation(){ 
        for(int i = 0; i<length; i++){
            for(int j = 0; j< length; j++){
                if(TransitMat[j][i]){
                    for(int k = 0; k<length;k++){
                        TransitMat[j][k] = TransitMat[j][k] | TransitMat [i][k];
                    }
                }
            }
        }
    }
    
    /*
    * Vypise vysledek do mrizky
    */
    
    void displayTransitiveClosure(){ 
        for (int i = 0; i < length; i ++){
            for (int j = 0; j < length; j ++){
                if(TransitMat[i][j]){
                    jCheckBox5[i][j].setSelected(true);
                }
            }
         }
    }
     //   TransitiveClosureDisplay();
    private javax.swing.JButton jButton2;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
