package com.github.curriculeon.jfoot;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void move() {
        while (this.foundLeaf()) {
            this.eatLeaf();
        }
        super.move();
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        }

        if (!this.canMove()) {
            if (isAtTopEdge()) {
                if (this.getDirection().equals(WEST)) {
                    setDirection(SOUTH);
                }
            } else {
                if (this.getDirection().equals(EAST)) {
                    this.leftMoveLeft();
                } else if (this.getDirection().equals(WEST)) {
                    this.rightMoveRight();
                } else if (this.getDirection().equals(SOUTH)) {
                    setDirection(EAST);
                }
            }
        }
        this.move();
    }

    private boolean isAtTopEdge() {
        return getY() == 0;
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }

    private void turnRight() {
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }

    public void leftMoveLeft() {
        turnLeft();
        move();
        turnLeft();
    }

    public void rightMoveRight() {
        turnRight();
        move();
        turnRight();
    }
}
