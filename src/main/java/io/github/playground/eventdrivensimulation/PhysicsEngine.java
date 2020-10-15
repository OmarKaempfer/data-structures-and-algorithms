package io.github.playground.eventdrivensimulation;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class PhysicsEngine {

    private Instant lastUpdate;
    private final int width;
    private final int height;

    public PhysicsEngine(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void updatePositions(List<Ball> balls) {

        Instant currentUpdate = Instant.now();
        double elapsedTime = Duration.between(lastUpdate, currentUpdate).toMillis();
        elapsedTime /= 1000;
        lastUpdate = currentUpdate;

        for(Ball ball : balls) {
            move(ball, elapsedTime);
        }
    }

    public void move(Ball ball, double dt) {

        double newxPos = newxPos(ball, dt);
        if(newxPos - ball.radius < 0 || newxPos + ball.radius > width) {
            ball.xVelocity = (-1) * ball.xVelocity;
        }

        double newyPos = newyPos(ball, dt);
        if(newyPos - ball.radius < 0 || newyPos + ball.radius > height) {
            ball.yVelocity = (-1) * ball.yVelocity;
        }

        ball.xPosition = newxPos;
        ball.yPosition = newyPos;
    }

    private double newxPos(Ball ball, double dt) {
        return ball.xPosition + ball.xVelocity * dt;
    }

    private double newyPos(Ball ball, double dt) {
        return ball.yPosition + ball.yVelocity * dt;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void start() {
        lastUpdate = Instant.now();
    }
}
