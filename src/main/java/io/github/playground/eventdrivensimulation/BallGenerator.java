package io.github.playground.eventdrivensimulation;

import java.util.Random;

public class BallGenerator {

    private final Random random;
    private final BallsSimulatorConfiguration configuration;

    public BallGenerator(BallsSimulatorConfiguration configuration) {
        this.configuration = configuration;
        this.random = new Random();
    }

    public Ball generateRandomBall() {

        Ball ball = new Ball();

        ball.radius = generateRandomNumber(configuration.radiusLowerBound, configuration.radiusUpperBound, false);
        ball.xPosition = generateRandomNumber(ball.radius, configuration.sandboxWidth - ball.radius, false);
        ball.yPosition = generateRandomNumber(ball.radius, configuration.sandboxHeight - ball.radius, false);
        ball.xVelocity = generateRandomNumber(configuration.xvelocityLowerBound, configuration.xvelocityUpperBound, true);
        ball.yVelocity = generateRandomNumber(configuration.yvelocityLowerBound, configuration.yvelocityUpperBound, true);
        ball.mass = generateRandomNumber(configuration.massLowerBound, configuration.massUpperBound, false);

        return ball;
    }

    private int generateRandomNumber(double lowerBoundAbs, double upperBoundAbs, boolean canBeNegative) {

        double range = upperBoundAbs - lowerBoundAbs;
        range = range != 0 ? range : 1;

        int randomNumber = (int) (Math.abs(random.nextInt()) % range + lowerBoundAbs);

        if(canBeNegative) {
            randomNumber *= random.nextInt(2) == 0 ? 1 : -1;
        }

        return randomNumber;
    }
}
