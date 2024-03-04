/*package org.example.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Eventosmouse extends JFrame implements MouseListener, MouseMotionListener {

    private List<Circulo> circulos; // En esta lista se guardan los círculos
    private int diametro;
    private Color elColor;

    public Eventosmouse(){
        super("Eventos de Mouse");
        setSize(1000,800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        diametro = 10;
        elColor = Color.BLACK;
        circulos = new ArrayList<>();

        JPanel panel = new PanelPizarra(); //un panel que sirve de "pizarron" para pintar
        add(panel, BorderLayout.CENTER);

        addEventos();
        setVisible(true);
    }

    public void addEventos(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(new MouseWheelListener() { //Con esto se cambia el tamaño del pincel
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                diametro += notches * -5;
                if (diametro < 10) diametro = 10;
                if (diametro > 100) diametro = 100;
                repaint();
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
        repaint();
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
        int iX = e.getX() - diametro / 2 - 7;
        int iY = e.getY() - diametro / 2 - 30;
        circulos.add(new Circulo(new Point(iX, iY), diametro, elColor));
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    class PanelPizarra extends JPanel {
        public PanelPizarra() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Circulo circulo : circulos) {
                g.setColor(circulo.getColor());
                g.fillOval(circulo.getPosicion().x, circulo.getPosicion().y, circulo.getDiametro(), circulo.getDiametro());
            }
        }
    }

    public static void main(String[] args) {
        new Eventosmouse();
    }


    class Circulo { //Todo esto es el objeto circulo que nos permite fijar los circulos con diferentes tamaños y colores, que a su vez tambien deberia facilitar el guardar los dibujos
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
*/
