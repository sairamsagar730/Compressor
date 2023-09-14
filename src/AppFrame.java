import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        compressButton = new JButton("select file to compress");
        compressButton.setBounds(20, 100, 200, 50);
        compressButton.addActionListener(this);

        decompressButton = new JButton("select file to decompress");
        decompressButton.setBounds(250, 100, 200, 50);
        decompressButton.addActionListener(this);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
        this.setTitle("COMPRESSOR_DECOMPRESSOR");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                //System.out.println(file);
                try {
                    Compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // System.out.println(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }


    }
}
