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
        if (this.foundLeaf()) { //Found leaf
            this.eatLeaf();
        } else if (this.canMove()) { //No leaf is found & can move
            this.move();
        } else { //No leaf found & can't move
            if (this.getDirection() == EAST){
                this.turnLeft();
                this.move();
                this.turnLeft();
            }
            else if (this.getDirection() == WEST) {
                this.turnRight();
                this.move();
                this.turnRight();
            }

            if(isAtTopLeft()){
                this.setDirection(SOUTH);
            }

            if(isAtBottomLeft()){
                this.setDirection(EAST);
            }

        }
    }

    private Boolean canMove(Direction direction) {
        Direction originalDirection = this.getDirection();
        setDirection(direction);
        boolean canMove = canMove();
        setDirection(originalDirection);
        return canMove;
    }

    private Boolean isAtTopLeft() {
        return !canMove(NORTH) && !canMove(WEST);
    }

    private Boolean isAtBottomLeft(){
        return !canMove(SOUTH) && canMove(EAST);
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

    public void turnRight() {
        if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }
}
