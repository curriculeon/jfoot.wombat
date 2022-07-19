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

    public boolean isAtLeftBorder() {
        return getX() == 0;
    }
    public boolean isAtTopBorder() {
        return getY() == 0;
    }

    public boolean isAtRightBorder() {
        return getX() == 9;
    }
    public boolean isAtBottomBorder() {
        return getY() == 9;
    }

    public boolean atTopLeftCorner() {
        return isAtLeftBorder() && isAtTopBorder();
    }
    public boolean atBottomLeftCorner() {return isAtLeftBorder() && isAtBottomBorder(); }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        }

        if (atBottomLeftCorner()){
            this.turnRight();
            this.move();
        }
        if (atTopLeftCorner()){
            this.turnRight();
            this.move();
        }
        else if (!this.canMove() && this.getDirection() == WEST ) {
            this.turnLeft();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.turnLeft();

        }else
        if (!this.canMove() && this.getDirection() == EAST) {
            this.turnRight();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.turnSouth();
        }else

        if (!this.canMove() && this.getDirection() == NORTH) {
           this.turnLeft();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
           this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
            this.turnLeft();
        } else if (!this.canMove() && this.getDirection() == SOUTH) {
          this.turnRight();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
          this.move();
            if (this.foundLeaf()) {
                this.eatLeaf();
            }
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
        if (this.getDirection() != NORTH) {
            this.setDirection(NORTH);

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


