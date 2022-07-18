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
//boolean northWest = (getDirection() == NORTH) && (getDirection() == WEST);
    //boolean northEast = (getDirection() == NORTH) && (getDirection() == EAST);
    //boolean southWest = (getDirection() == SOUTH) && (getDirection() == WEST);
    //boolean southEast = (getDirection() == SOUTH) && (getDirection() == EAST);
    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        }

        // this.turnLeft();
        if (!this.canMove() && this.getDirection() == WEST ) {
            this.turnLeft();
            this.move();
            this.turnLeft();
            //this.turnNorth();
        }
        if (!this.canMove() && this.getDirection() == EAST) {
            this.turnRight();
            this.move();
            this.turnSouth();
        }
        //spin around u dumbass Wombat
        if (!this.canMove() && this.getDirection() == NORTH) {
           this.turnLeft();
           this.move();
            //this.turnSouth();
            this.turnLeft();
        }

        if (!this.canMove() && this.getDirection() == SOUTH) {
          this.turnRight();
          this.move();
          //this.turnNorth();
            this.turnRight();
        }
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
    public void turnNorth() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);

        }
    }
    public void turnSouth() {
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == SOUTH) {
            this.setDirection(NORTH);
        }
    }
    }


