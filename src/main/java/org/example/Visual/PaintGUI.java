package org.example.Visual;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PaintGUI extends JFrame implements MouseListener, MouseMotionListener{
    private JPanel panelGeneral;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JPanel panelCenter;
    private JButton btnLimpiar;
    private JButton btonGuardar;
    private JLabel lblCoordenadas;
    private JSlider sliderPincel;
    private JButton btnColorNegro;
    private JLabel lblFiguras;
    private JButton btnRectangulo;
    private JButton btnCirculo;
    private JButton btnLinea;
    private JButton btnCuadrado;
    private JPanel panelOeste;
    private JPanel panelEste;
    private JLabel lblTitulo;
    private JLabel lblPincel;
    private JLabel lblColores;
    private JButton btnColorMorado;
    private JButton btnColorRojo;
    private JButton btnColorVerde;
    private JButton btnColorAzul;
    private JButton btnColorAmarilo;
    private JButton btnColorCian;
    private JButton btnColorNaranja;
    private JButton btnColorRosado;
    private JButton btnColorCafe;
    private JButton btonCargar;
    //----------------------------------------------------------------------------------------------------------------------
    private List<Circulo> circulos; //En esta lista se guardan los círculos
    private int diametro;
    private Color elColor;
    private ImageIcon imagen;


    public PaintGUI(){
        super("Paint 2");
        panelCenter = new panelCenter();
        setContentPane(panelGeneral);
        panelGeneral.add(panelCenter, BorderLayout.CENTER); //Aquí se añade el panel de dibujo al panel general.
        diametro = 10;
        elColor = Color.BLACK;
        circulos = new ArrayList<>();
        addEventos();
        imagen = new ImageIcon("src/main/java/org/example/recursos/IconoPalette-removebg-resized.png");
        lblTitulo.setIcon(imagen);
//----------------------------------------------------------------------------------------------------------------------
        btnColorNegro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = Color.BLACK;
                panelCenter.repaint();
            }
        });
        btnColorRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = Color.RED;
                panelCenter.repaint();
            }
        });
        btnColorAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = Color.BLUE;
                panelCenter.repaint();
            }
        });
        btnColorVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = Color.GREEN;
                panelCenter.repaint();
            }
        });
        btnColorMorado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(178,57,255);
                panelCenter.repaint();
            }
        });
        btnColorAmarilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(238,255,15);
                panelCenter.repaint();
            }
        });
        btnColorCian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(15,255,238);
                panelCenter.repaint();
            }
        });
        btnColorNaranja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(255,116,27);
                panelCenter.repaint();
            }
        });
        btnColorRosado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(255,0,219);
                panelCenter.repaint();
            }
        });
        btnColorCafe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(159,106,70);
                panelCenter.repaint();
            }
        });

        sliderPincel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int notches = sliderPincel.getValue();
                diametro = 10 + (notches - 1) * (90 / (6 - 1));
                panelCenter.repaint();
            }
        });

        btnLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnRectangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


//----------------------------------------------------------------------------------------------------------------------


    public void addEventos(){
        panelCenter.addMouseListener(this); //Aquí se añaden los eventos al panel de dibujo.
        panelCenter.addMouseMotionListener(this);
        this.addMouseWheelListener(new MouseWheelListener() { //Con esto se cambia el tamaño del pincel
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                diametro += notches * -5;
                if (diametro < 10) diametro = 10;
                if (diametro > 100) diametro = 100;
                panelCenter.repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) { //Esto es lo que permite el "modo borrador"
            elColor = Color.WHITE;
        } else if (SwingUtilities.isLeftMouseButton(e)) { //Con esto regresa a "modo pincel"
            elColor = Color.BLACK;
        }
        panelCenter.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //estos los dejé asi en caso de que se quiera hacer algo con ellos xd
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

    @Override
    public void mouseDragged(MouseEvent e) {
        int iX = e.getX() - diametro / 2;
        int iY = e.getY() - diametro / 2;
        circulos.add(new Circulo(new Point(iX, iY), diametro, elColor));
        panelCenter.repaint();
        lblCoordenadas.setText("X: " + e.getX() + " Y: " + e.getY() + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        lblCoordenadas.setText("X: " + e.getX() + " Y: " + e.getY() + ")");
    }

//----------------------------------------------------------------------------------------------------------------------
    class panelCenter extends JPanel {
        public panelCenter() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (PaintGUI.Circulo circulo : circulos) {
                g.setColor(circulo.getColor());
                g.fillOval(circulo.getPosicion().x, circulo.getPosicion().y, circulo.getDiametro(), circulo.getDiametro());
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    class Circulo { //Todo esto es el objeto circulo que nos permite fijar los circulos con diferentes tamaños y colores, que a su vez tambien DEBERIA facilitar el guardar los dibujos
        private Point posicion;
        private int diametro;
        private Color color;

        public Circulo(Point posicion, int diametro, Color color) {
            this.posicion = posicion;
            this.diametro = diametro;
            this.color = color;
        }

        public Point getPosicion() {
            return posicion;
        }

        public int getDiametro() {
            return diametro;
        }

        public Color getColor() {
            return color;
        }
    }

}