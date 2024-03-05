package org.example.Visual;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PaintGUI extends JFrame implements MouseListener, MouseMotionListener{ //Atributos agregados por el UI
    private JPanel panelGeneral;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JPanel panelCenter;
    private JButton btnLimpiar;
    private JLabel lblCoordenadas;
    private JSlider sliderPincel;
    private JButton btnColorNegro;
    private JLabel lblFiguras;
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
    private JButton btnColorGris;
    private JButton btnColorVerdeO;
    private JButton btnColorCrema;
    private JButton btnColorRojoO;
    private JButton btnTriangulo;
    //---------------------------------------------------------------------------------------------------------------------- Atributos agregados manualmente
    private List<Circulo> circulos; //En esta lista se guardan los círculos
    private List<Linea> lineas; //aqui las lineas
    private List<Cuadrado> cuadrados; //y aqui los cuadrados
    private int diametro;
    private int grosorLinea;
    private int lado;
    private Color elColor;
    private ImageIcon imagen;
    private boolean dibujarLinea;
    private boolean dibujarCirculo;
    private boolean dibujarCuadrado;

    public PaintGUI(){
        super("Paint 2");
        panelCenter = new panelCenter(); //Esto sirve para conectar con el UI
        setContentPane(panelGeneral);
        panelGeneral.add(panelCenter, BorderLayout.CENTER); //Aquí se añade el panel de dibujo al panel general.
        diametro = 10;
        grosorLinea = 3;
        lado=10;
        elColor = Color.BLACK;
        circulos = new ArrayList<>();
        lineas = new ArrayList<>();
        cuadrados = new ArrayList<>();
        dibujarLinea = false;
        dibujarCirculo = true;
        dibujarCuadrado = false;
        addEventos();
        imagen = new ImageIcon("src/main/java/org/example/recursos/IconoPalette-removebg-resized.png");
        lblTitulo.setIcon(imagen);
//----------------------------------------------------------------------------------------------------------------------Eventos de botones
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
        btnColorGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(161,168,163);
                panelCenter.repaint();
            }
        });
        btnColorVerdeO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(14,160,7);
                panelCenter.repaint();
            }
        });
        btnColorCrema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(255,235,193);
                panelCenter.repaint();
            }
        });
        btnColorRojoO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elColor = new Color(171,0,11);
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
                dibujarLinea = true;
                dibujarCirculo = false;
                dibujarCuadrado = false;
                dibujarTriangulo = false;
                panelCenter.repaint();
            }
        });

        btnCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujarLinea = false;
                dibujarCirculo = false;
                dibujarCuadrado = true;
                dibujarTriangulo = false;
                panelCenter.repaint();
            }
        });

        btnCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujarCirculo = true;
                dibujarLinea = false;
                dibujarCuadrado = false;
                dibujarTriangulo = false;
                panelCenter.repaint();
            }
        });
        btnTriangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujarLinea = false;
                dibujarCirculo = false;
                dibujarCuadrado = true;
                dibujarTriangulo = false;
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circulos.clear();
                lineas.clear();
                cuadrados.clear();
                panelCenter.repaint();
            }
        });


    }


//----------------------------------------------------------------------------------------------------------------------Eventos Mouse


    public void addEventos(){
        panelCenter.addMouseListener(this); //Aquí se añaden los eventos al panel de dibujo.
        panelCenter.addMouseMotionListener(this);
        this.addMouseWheelListener(new MouseWheelListener() { //Con esto se cambia el tamaño del pincel
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();

                if (dibujarCirculo) {
                    diametro += notches * -5;
                    if (diametro < 10) diametro = 10;
                    if (diametro > 100) diametro = 100;
                }
                if (dibujarLinea) {
                    grosorLinea += notches * -5;
                    if (grosorLinea < 10) grosorLinea = 10; // Grosor mínimo de 1
                    if (grosorLinea > 100) grosorLinea = 100;
                }
                if (dibujarCuadrado) {
                    lado += notches * -5;
                    if (lado < 10) lado = 10;
                    if (lado > 100) lado = 100;
                }
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
        if (dibujarCirculo) {
            if (SwingUtilities.isRightMouseButton(e)) { //Esto es lo que permite el "modo borrador"
                elColor = Color.WHITE;
            } else if (SwingUtilities.isLeftMouseButton(e)) { //Con esto regresa a "modo pincel"
                elColor = Color.BLACK;
            }
        }
        if (dibujarLinea) {
            //Si estamos en modo de dibujo de líneas, agregamos el punto inicial
            if (SwingUtilities.isLeftMouseButton(e)) {
                lineas.add(new Linea(e.getPoint(), e.getPoint(), elColor, grosorLinea));
            }
            if (SwingUtilities.isRightMouseButton(e)) { //Esto es lo que permite el "modo borrador"
                elColor = Color.WHITE;
            }
        }
        if (dibujarCuadrado) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                cuadrados.add(new Cuadrado(new Point(e.getX(), e.getY()), lado, elColor));
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                elColor = Color.WHITE;
            }
        }

        panelCenter.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (dibujarLinea) {
            lineas.add(new Linea(e.getPoint(), e.getPoint(), elColor, grosorLinea));
        }
        if (dibujarCuadrado) {
            cuadrados.add(new Cuadrado(new Point(e.getX(), e.getY()), lado, elColor));
        }
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
        if (dibujarLinea) {
            //Si estamos en modo de dibujo de líneas, actualizamos el punto final de la última línea
            if (!lineas.isEmpty()) {
                lineas.get(lineas.size() - 1).setPuntoFinal(e.getPoint());
            }
        }
        if (dibujarCirculo) {
            int iX = e.getX() - diametro / 2;
            int iY = e.getY() - diametro / 2;
            circulos.add(new Circulo(new Point(iX, iY), diametro, elColor));
        }
        panelCenter.repaint();
        lblCoordenadas.setText("X: " + e.getX() + " Y: " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        lblCoordenadas.setText("X: " + e.getX() + " Y: " + e.getY() + ")");
    }

    //----------------------------------------------------------------------------------------------------------------------Adicion de paintComponet al panel genral
    class panelCenter extends JPanel {
        public panelCenter() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (Cuadrado cuadrado : cuadrados) {
                g2d.setColor(cuadrado.getColor());
                g2d.fillRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado());
            }

            for (PaintGUI.Linea linea : lineas) {
                g2d.setColor(linea.getColor());
                g2d.setStroke(new BasicStroke(linea.getGrosorLinea())); //Usa el grosor almacenado en cada línea
                g2d.drawLine(linea.getPuntoInicial().x, linea.getPuntoInicial().y, linea.getPuntoFinal().x, linea.getPuntoFinal().y);
            }

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
    class Linea {
        private Point puntoInicial;
        private Point puntoFinal;
        private Color color;
        private int grosorLinea;

        public Linea(Point puntoInicial, Point puntoFinal, Color color, int grosorLinea) {
            this.puntoInicial = puntoInicial;
            this.puntoFinal = puntoFinal;
            this.color = color;
            this.grosorLinea = grosorLinea;
        }
        public void setPuntoFinal(Point puntoFinal) {
            this.puntoFinal = puntoFinal;
        }

        public Point getPuntoInicial() {
            return puntoInicial;
        }

        public Point getPuntoFinal() {
            return puntoFinal;
        }

        public Color getColor() {
            return color;
        }

        public int getGrosorLinea() {
            return grosorLinea;
        }
    }

    public class Cuadrado {
        private Point posicion; //Posición superior izquierda del cuadrado
        private int lado; //Longitud del lado del cuadrado
        private Color color;

        public Cuadrado(Point posicion, int lado, Color color) {
            this.posicion = posicion;
            this.lado = lado;
            this.color = color;
        }

        public Point getPosicion() {
            return posicion;
        }

        public int getX() {
            return posicion.x;
        }

        public int getY() {
            return posicion.y;
        }

        public int getLado() {
            return lado;
        }

        public Color getColor() {
            return color;
        }
    }
}