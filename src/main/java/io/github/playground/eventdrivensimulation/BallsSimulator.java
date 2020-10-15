package io.github.playground.eventdrivensimulation;

import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BallsSimulator extends JFrame {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int NR_OF_BALLS = 20;
    public static final int RADIUS = 4;
    public static final int DEFAULT_VELOCITY = 50;

    public static final int PHYSICS_TICK_PERIOD = 16;

    private final Canvas canvas;
    private final PhysicsEngine physicsEngine;
    private final List<Ball> balls = new ArrayList<>();

    public BallsSimulator(Canvas canvas) {

        this.canvas = canvas;
        this.physicsEngine = new PhysicsEngine(WIDTH, HEIGHT);

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
        setSize(new Dimension((int) (WIDTH * 1.1), (int) (HEIGHT * 1.1)));

        addWallsDrawing();
    }

    private void addWallsDrawing() {

        canvas.addNewDrawing(graphics -> graphics.drawLine(WIDTH,HEIGHT, 0, HEIGHT));
        canvas.addNewDrawing(graphics -> graphics.drawLine(WIDTH,HEIGHT, WIDTH, 0));
        canvas.addNewDrawing(graphics -> graphics.drawLine(0,0, WIDTH, 0));
        canvas.addNewDrawing(graphics -> graphics.drawLine(0,0, 0, HEIGHT));
    }

    private void populate() {

        for(int i = 0; i < NR_OF_BALLS; i++) {
            Ball ball = generateRandomBall();
            balls.add(ball);
            canvas.addNewDrawing(graphics -> drawBall(graphics, ball));
        }
    }

    private void stubBall() {

        Ball mock = Mockito.mock(Ball.class);
        Mockito.when(mock.getxPosition()).then(invocationOnMock -> {
            System.out.println("position " + mock.xPosition + " " + mock.yPosition);
            System.out.println("radius " + mock.radius);
            return mock.xPosition;
        });
        mock.xPosition = 30;
        mock.yPosition = 30;
        mock.radius = RADIUS;
        mock.yVelocity = 15;
        mock.xVelocity = 15;
        balls.add(mock);
        canvas.addNewDrawing(graphics -> drawBall(graphics, mock));
    }

    private void drawBall(Graphics graphics, Ball ball) {

        Ellipse2D.Double ballShape = new Ellipse2D.Double(ball.xPosition - ball.radius, ball.yPosition - ball.radius,
                                                        ball.radius * 2, ball.radius * 2);
        ((Graphics2D)graphics).fill(ballShape);
    }

    private Ball generateRandomBall() {

        Random random = new Random();

        Ball ball = new Ball();
        ball.xPosition = Math.abs(random.nextInt()) % WIDTH;
        ball.yPosition = Math.abs(random.nextInt()) % HEIGHT;
        ball.xVelocity = random.nextInt(2) == 1 ? DEFAULT_VELOCITY : (-1) * DEFAULT_VELOCITY;
        ball.yVelocity = random.nextInt(2) == 1 ? DEFAULT_VELOCITY : (-1) * DEFAULT_VELOCITY;
        ball.radius = RADIUS;

        return ball;
    }

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public void start() {
        physicsEngine.start();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            physicsEngine.updatePositions(balls);
        }, 0, PHYSICS_TICK_PERIOD, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {

        BallsSimulator ballsSimulator = new BallsSimulator(new Canvas());
        ballsSimulator.setVisible(true);
        ballsSimulator.start();
    }
}
