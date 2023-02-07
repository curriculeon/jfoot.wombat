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

    public void turnRight() {
        if (getDirection() == EAST ) {
            setDirection(SOUTH);
        } else if(getDirection() == WEST ) {
            setDirection(NORTH);
        } else if (getDirection() == NORTH ) {
            setDirection(EAST);
        } else  {
            setDirection(WEST);
        }
    }

    // turn right is dependent on the direction of the wombat
    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else {
            if(getDirection() == EAST ) {
                turnLeft();
                move();
                turnLeft();
            } else if (getDirection() == WEST ) {
                turnRight();
                move();
                turnRight();
            }
        }
    }

    // I just used the same parameters from turnRight()...gotta work smarter not harder
    public void turnLeft() {
        if (this.getDirection() == EAST ) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST ) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH ) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }
}
