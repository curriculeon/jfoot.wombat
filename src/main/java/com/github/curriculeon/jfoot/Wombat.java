package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

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

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        }
        if (this.canMove()) {
            this.move();
        } else {
            if(this.getDirection().equals(EAST)) {
                this.leftMoveLeft();
            } else if(this.getDirection().equals(WEST)) {
                this.rightMoveRight();
            }
        }
    }

    public void turnLeft() {
        System.out.println("turnLeft");
        System.out.println("Current Direction " + getDirection());
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
        System.out.println("New Direction " + getDirection());
    }

    private void turnRight() {
        System.out.println("turnRight");
        System.out.println("Current Direction " + getDirection());
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
        System.out.println("New Direction " + getDirection());
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
