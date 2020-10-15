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
        double newyPos = newyPos(ball, dt);

        ball.xPosition = newxPos;
        ball.yPosition = newyPos;

        if(escapingVerticalBounds(ball, newxPos)) {
            bounceOffHorizontalWall(ball);
        }

        if(escapingHorizontalBounds(ball, newyPos)) {
            bounceOffVerticalWall(ball);
        }

    }

    private void bounceOffVerticalWall(Ball ball) {
        ball.yVelocity = (-1) * ball.yVelocity;
    }

    private void bounceOffHorizontalWall(Ball ball) {
        ball.xVelocity = (-1) * ball.xVelocity;
    }

    private boolean escapingHorizontalBounds(Ball ball, double newyPos) {
        return (newyPos - ball.radius < 0 && ball.yVelocity < 0) || (newyPos + ball.radius > height && ball.yVelocity > 0);
    }

    private boolean escapingVerticalBounds(Ball ball, double newxPos) {
        return (newxPos - ball.radius < 0 && ball.xVelocity < 0) || (newxPos + ball.radius > width && ball.xVelocity > 0);
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
