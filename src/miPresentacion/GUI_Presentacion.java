package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImage;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion(){
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame

        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Sebastian, oprime los botones",Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco más de mi...",
                             TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                             new Font("Calibri", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textoExpectativas = new JTextArea(10,12);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUGui_presentacion = new GUI_Presentacion();
            }
        });


    }
    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void mouseClicked(MouseEvent e) {
            //JOptionPane.showMessageDialog(null, "Oprimiste un botón");
            panelDatos.removeAll();
            if(e.getSource()==miFoto){
                image = new ImageIcon(getClass().getResource("/resources/mifoto2.jpeg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);

                revalidate();
                repaint();
            }else{
                if (e.getClickCount() == 2 && e.getSource() == miHobby) {
                    image = new ImageIcon(getClass().getResource("/resources/mifoto1.jpeg"));
                    labelImage.setIcon(image);
                    panelDatos.add(labelImage);
                }else{
                    if(e.getSource()==misExpectativas ){

                    }
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

            panelDatos.removeAll();

            if(e.getKeyChar()==e.VK_M){
                textoExpectativas.setText("Mis expectativas para el curso son: \n\n" +
                        "Reforzar mis conocimientos de Java. \n\n" +
                        "Aprender una nueva manera de programar. \n\n" +
                        "Superar con éxito las tareas y trabajos que se me propongan. \n\n" +
                        "Disfrutar de esta nueva étapa.");
                textoExpectativas.setFont(new Font("Arial",Font.ITALIC,20));
                textoExpectativas.setBackground(null);
                panelDatos.add(textoExpectativas);

                revalidate();
                repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
