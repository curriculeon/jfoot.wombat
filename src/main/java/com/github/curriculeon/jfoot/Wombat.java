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
            //If the current direction is EAST
            if (this.getDirection() == EAST){
                //Turn Wombat to the left
                this.turnLeft();
                //Move forward a space
                this.move();
                //Turn Wombat to the left again
                this.turnLeft();
            }
            //Otherwise, if the current direction is WEST
            else if (this.getDirection() == WEST) {
                //Turn Wombat to the right
                this.turnRight();
                //Move forward a space
                this.move();
                //Turn Wombat to the right again
                this.turnRight();
            }

            //If the Wombat is at the top left of the grid
            if(isAtTopLeft()){
                //Change the Wombat's direction to SOUTH
                this.setDirection(SOUTH);
            }

            //If the Wombat is at the bottom left of the grid
            if(isAtBottomLeft()){
                //Change the Wombat's direction to EAST
                this.setDirection(EAST);
            }

        }
    }

    //This method is used to check if the Wombat is able to move in a certain direction
    private Boolean canMove(Direction direction) {
        //Retain the original direction when the method is called
        Direction originalDirection = this.getDirection();
        //Set the Wombat's direction to the direction to be checked
        setDirection(direction);
        //Boolean of whether the Wombat can move in this direction
        boolean canMove = canMove();
        //Set the Wombat's direction back to the original direction
        setDirection(originalDirection);
        //Return canMove boolean
        return canMove;
    }

    //This method is used to check if the Wombat is at the top left of the grid
    private Boolean isAtTopLeft() {
        //The canMove method is called on, passing in North and West
        //If we *can't* move North and *can't* move West...
        //Then the Wombat is at the top left
        //Otherwise, we haven't reached the top left yet
        return !canMove(NORTH) && !canMove(WEST);
    }

    //This method is used to check if the Wombat is at the bottom left of the grid
    private Boolean isAtBottomLeft(){
        /*
         The canMove method is called on, passing in South and East
         If we *can't* move South and *can't* move East...
         Then the Wombat is at the bottom left
         Otherwise, we haven't reached the bottom left yet
         */
        return !canMove(SOUTH) && canMove(EAST);
    }


    //Method to turn the Wombat to the left
    public void turnLeft() {
        //If the current direction is EAST
        if (this.getDirection() == EAST) {
            //Direction is changed to NORTH
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) { //If the current direction is WEST
            //Direction is changed to SOUTH
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) { //If the current direction is NORTH
            //Direction is changed to WEST
            this.setDirection(WEST);
        } else { //If none of the previous conditions apply (direction is currently SOUTH)
            //Direction is changed to EAST
            this.setDirection(EAST);
        }
    }

    //Method to turn the Wombat to the right, mirrors the previous turnLeft method
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
