package io.github.playground.eventdrivensimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Canvas extends JPanel implements ActionListener {

    private static final int REPAINTING_PERIOD = 16;
    private final Timer timer;

    private final List<Consumer<Graphics>> drawingCalls = new ArrayList<>();

    public Canvas() {
        timer = new Timer(REPAINTING_PERIOD, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawingCalls.forEach(drawingCall -> drawingCall.accept(graphics));
    }

    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void addNewDrawing(Consumer<Graphics> drawingCall) {
        this.drawingCalls.add(drawingCall);
    }
}
