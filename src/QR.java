
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.nio.*;
import java.nio.file.Path;

public class QR extends javax.swing.JFrame {

    public QR() {
        initComponents();

    }

    //metodo para generar el QR
    public void Qr() {
        int size = 1000; //cantidad de pixeles que tendra el qr generado
        String FileType = "png"; //formato del codigo qr
        String link = txtlink.getText();//obtengo en link a convertir
        //paso 1 elegir la ruta de la imagen
        String Path = "";
        JFileChooser chooser = new JFileChooser(); //instancie el JfileChooser
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //el qr se puede guardar en cualquier directorio del pc
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Path = chooser.getSelectedFile().getAbsolutePath();

        }

        //paso 2: generar el nombre
        UUID uuid = UUID.randomUUID();
        String randomname = uuid.toString();

        //paso 3 generar el qr
        QRCodeWriter qrcode = new QRCodeWriter();
        try {
            BitMatrix matriz = qrcode.encode(link, BarcodeFormat.QR_CODE, size, size);
            File f = new File(Path + "/" + randomname + "." + FileType);
            int matrixWidth = matriz.getWidth();
            BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.white); //fondo
            graphics.fillRect(0, 0, size, size); //adaptando el label al tamaño de la imagen
            graphics.setColor(Color.BLACK); //color del qr

            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (matriz.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);

                    }
                }
            }

            //mostrar la imagen generada
            ImageIO.write(image, FileType, f);
            Image Mimagen = new ImageIcon(Path + "/" + randomname + "." + FileType).getImage();
            ImageIcon Micon = new ImageIcon(Mimagen.getScaledInstance(lblQR.getWidth(), lblQR.getHeight(), 0));
            lblQR.setIcon(Micon);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlprincipal = new javax.swing.JPanel();
        txtlink = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        lblQR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlprincipal.setBackground(new java.awt.Color(0, 0, 0));

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlprincipalLayout = new javax.swing.GroupLayout(pnlprincipal);
        pnlprincipal.setLayout(pnlprincipalLayout);
        pnlprincipalLayout.setHorizontalGroup(
            pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalLayout.createSequentialGroup()
                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lblQR, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnGenerar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlprincipalLayout.setVerticalGroup(
            pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQR, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        Qr();
    }//GEN-LAST:event_btnGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel lblQR;
    private javax.swing.JPanel pnlprincipal;
    private javax.swing.JTextField txtlink;
    // End of variables declaration//GEN-END:variables
}
