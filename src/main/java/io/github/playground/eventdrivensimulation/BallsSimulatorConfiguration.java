package io.github.playground.eventdrivensimulation;

public class BallsSimulatorConfiguration {

    public int sandboxWidth = 700;
    public int sandboxHeight = 700;
    public int nrOfBalls = 20;

    public double xvelocityUpperBound = 20;
    public double xvelocityLowerBound = 50;

    public double yvelocityUpperBound = 20;
    public double yvelocityLowerBound = 50;

    public double radiusUpperBound = 4;
    public double radiusLowerBound = 12;

    public double massLowerBound = 1;
    public double massUpperBound = 5;

    int physicsEngineTickPeriod = 16;

    public BallsSimulatorConfiguration() {}

    public int getSandboxWidth() {
        return sandboxWidth;
    }

    public BallsSimulatorConfiguration setSandboxWidth(int sandboxWidth) {
        this.sandboxWidth = sandboxWidth;
        return this;
    }

    public int getSandboxHeight() {
        return sandboxHeight;
    }

    public BallsSimulatorConfiguration setSandboxHeight(int sandboxHeight) {
        this.sandboxHeight = sandboxHeight;
        return this;
    }

    public int getNrOfBalls() {
        return nrOfBalls;
    }

    public BallsSimulatorConfiguration setNrOfBalls(int nrOfBalls) {
        this.nrOfBalls = nrOfBalls;
        return this;
    }

    public double getXvelocityUpperBound() {
        return xvelocityUpperBound;
    }

    public BallsSimulatorConfiguration setXvelocityUpperBound(double xvelocityUpperBound) {
        this.xvelocityUpperBound = xvelocityUpperBound;
        return this;
    }

    public double getXvelocityLowerBound() {
        return xvelocityLowerBound;
    }

    public BallsSimulatorConfiguration setXvelocityLowerBound(double xvelocityLowerBound) {
        this.xvelocityLowerBound = xvelocityLowerBound;
        return this;
    }

    public double getYvelocityUpperBound() {
        return yvelocityUpperBound;
    }

    public BallsSimulatorConfiguration setYvelocityUpperBound(double yvelocityUpperBound) {
        this.yvelocityUpperBound = yvelocityUpperBound;
        return this;
    }

    public double getYvelocityLowerBound() {
        return yvelocityLowerBound;
    }

    public BallsSimulatorConfiguration setYvelocityLowerBound(double yvelocityLowerBound) {
        this.yvelocityLowerBound = yvelocityLowerBound;
        return this;
    }

    public double getRadiusUpperBound() {
        return radiusUpperBound;
    }

    public BallsSimulatorConfiguration setRadiusUpperBound(double radiusUpperBound) {
        this.radiusUpperBound = radiusUpperBound;
        return this;
    }

    public double getRadiusLowerBound() {
        return radiusLowerBound;
    }

    public BallsSimulatorConfiguration setRadiusLowerBound(double radiusLowerBound) {
        this.radiusLowerBound = radiusLowerBound;
        return this;
    }

    public double getMassLowerBound() {
        return massLowerBound;
    }

    public BallsSimulatorConfiguration setMassLowerBound(double massLowerBound) {
        this.massLowerBound = massLowerBound;
        return this;
    }

    public double getMassUpperBound() {
        return massUpperBound;
    }

    public BallsSimulatorConfiguration setMassUpperBound(double massUpperBound) {
        this.massUpperBound = massUpperBound;
        return this;
    }

    public int getPhysicsEngineTickPeriod() {
        return physicsEngineTickPeriod;
    }

    public BallsSimulatorConfiguration setPhysicsEngineTickPeriod(int physicsEngineTickPeriod) {
        this.physicsEngineTickPeriod = physicsEngineTickPeriod;
        return this;
    }
}
