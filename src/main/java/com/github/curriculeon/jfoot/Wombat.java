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
    boolean hitTheEdge;
    boolean goingDown;
    boolean goingUP = true;
    public void act() {

        if(this.getY()==9){ goingDown =false; goingUP = true;}
        if(this.getY()==0){goingDown = true; goingUP = false;}

        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();

        } else {
            hitTheEdge = !hitTheEdge;

            if (goingUP){
                if (hitTheEdge) {
                    this.turnLeft();
                    move();
                    this.turnLeft();
                } else {
                    this.turnRight();
                    move();
                    this.turnRight();

                }
            }
            else if (goingDown){
                if (hitTheEdge) {
                    this.turnRight();
                    move();
                    this.turnRight();

                } else {
                    this.turnLeft();
                    move();
                    this.turnLeft();

                }
            }

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

    public void turnRight(){
        if(this.getDirection() ==WEST){
            this.setDirection(NORTH);
        }else if(this.getDirection()== EAST){
            this.setDirection(SOUTH);
        }else if(this.getDirection() == NORTH){
            this.setDirection(EAST);
        }else{
            this.setDirection(WEST);
        }
    }
}
