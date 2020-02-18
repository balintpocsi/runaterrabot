package experimental;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MouseListenerExample extends JFrame {

    int startX, startY, endX, endY;

    Color red_col = Color.red;

    public MouseListenerExample() {

        super();

        final JPopupMenu popMenu = new JPopupMenu();

        popMenu.add(new JMenuItem("Cut"));

        popMenu.add(new JMenuItem("Copy"));

        popMenu.add(new JMenuItem("Paste"));

        popMenu.addSeparator();

        popMenu.add(new JMenuItem("Select All"));

        popMenu.setInvoker(this);

        MouseListener popup = new MouseListener() {

            @Override

            public void mouseClicked(MouseEvent event) {

            }

            @Override

            public void mouseEntered(MouseEvent event) {

            }

            @Override

            public void mouseExited(MouseEvent event) {

            }

            @Override

            public void mousePressed(MouseEvent event) {

                if (event.isPopupTrigger()) {

                    popMenu(event);

                }

            }

            @Override

            public void mouseReleased(MouseEvent event) {

                if (event.isPopupTrigger()) {

                    popMenu(event);

                }

            }

            private void popMenu(MouseEvent event) {

                popMenu.show(event.getComponent(), event.getX(), event.getY());

            }

        };

        addMouseListener(popup);

        MouseListener drawing1 = new MouseListener() {

            @Override

            public void mouseClicked(MouseEvent event) {

            }

            @Override

            public void mouseEntered(MouseEvent event) {

            }

            @Override

            public void mouseExited(MouseEvent event) {

            }

            @Override

            public void mousePressed(MouseEvent event) {

                red_col = Color.RED;

                startX = endX = event.getX();

                startY = endY = event.getY();

                repaint();

            }

            @Override

            public void mouseReleased(MouseEvent event) {

                red_col = Color.BLACK;

                repaint();

            }

        };

        addMouseListener(drawing1);

        MouseMotionListener drawing2 = new MouseMotionListener() {

            @Override

            public void mouseDragged(MouseEvent event) {

                endX = event.getX();

                endY = event.getY();

                repaint();

            }

            @Override

            public void mouseMoved(MouseEvent event) {

            }

        };

        addMouseMotionListener(drawing2);

    }

    @Override
    public void paint(Graphics graphic) {

        super.paint(graphic);

        graphic.setColor(red_col);

        graphic.drawLine(startX, startY, endX, endY);
    }

    public static void main(String args[]) {

        JFrame jFrame = new MouseListenerExample();

        jFrame.setSize(600, 400);

        jFrame.setVisible(true);
    }
}
