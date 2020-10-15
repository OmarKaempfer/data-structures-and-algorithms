package io.github.playground.eventdrivensimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BallsSimulator extends JFrame {

    private final Canvas canvas;
    private final BallsSimulatorConfiguration configuration;
    private final PhysicsEngine physicsEngine;
    private final List<Ball> balls = new ArrayList<>();

    public BallsSimulator(Canvas canvas, BallsSimulatorConfiguration configuration) {

        this.canvas = canvas;
        this.configuration = configuration;
        this.physicsEngine = new PhysicsEngine(configuration.sandboxWidth, configuration.sandboxHeight);

        init();
        populate();
    }

    private void init() {

        add(this.canvas);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                canvas.getTimer().stop();
            }
        });

        setTitle("Balls Simulator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension((int) (configuration.sandboxWidth * 1.1), (int) (configuration.sandboxHeight * 1.1)));

        addWallsDrawing();
    }

    private void addWallsDrawing() {

        canvas.addNewDrawingCommand(graphics -> graphics.drawLine(configuration.sandboxWidth,
                configuration.sandboxHeight, 0, configuration.sandboxHeight));
        canvas.addNewDrawingCommand(graphics -> graphics.drawLine(configuration.sandboxWidth,
                configuration.sandboxHeight, configuration.sandboxWidth, 0));
        canvas.addNewDrawingCommand(graphics -> graphics.drawLine(0,0, configuration.sandboxWidth, 0));
        canvas.addNewDrawingCommand(graphics -> graphics.drawLine(0,0, 0, configuration.sandboxHeight));
    }

    private void populate() {
        BallGenerator generator = new BallGenerator(configuration);
        for(int i = 0; i < configuration.nrOfBalls; i++) {
            Ball ball = generator.generateRandomBall();
            balls.add(ball);
            canvas.addNewDrawingCommand(graphics -> drawBall(graphics, ball));
        }
    }

//    private void stubBall() {
//
//        Ball mock = Mockito.mock(Ball.class);
//        Mockito.when(mock.getxPosition()).then(invocationOnMock -> {
//            System.out.println("position " + mock.xPosition + " " + mock.yPosition);
//            System.out.println("radius " + mock.radius);
//            return mock.xPosition;
//        });
//        mock.xPosition = 30;
//        mock.yPosition = 30;
//        mock.radius = configuration.radiusUpperBound;
//        mock.yVelocity = 15;
//        mock.xVelocity = 15;
//        mock.mass = 1;
//        balls.add(mock);
//        canvas.addNewDrawingCommand(graphics -> drawBall(graphics, mock));
//    }

    private void drawBall(Graphics graphics, Ball ball) {

        Ellipse2D.Double ballShape = new Ellipse2D.Double(ball.xPosition - ball.radius, ball.yPosition - ball.radius,
                                                        ball.radius * 2, ball.radius * 2);
        ((Graphics2D)graphics).fill(ballShape);
    }

    public void start() {
        physicsEngine.start();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            physicsEngine.updatePositions(balls);
        }, 0, configuration.physicsEngineTickPeriod, TimeUnit.MILLISECONDS);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BallsSimulator(new Canvas(), new BallsSimulatorConfiguration()).start();
    }
}
