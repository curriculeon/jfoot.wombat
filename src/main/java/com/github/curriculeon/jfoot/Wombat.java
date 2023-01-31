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
    boolean left_next = true;
    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else if (left_next==true){
                this.turnLeft();
                this.move();
                this.turnLeft();
                left_next=false;
        } else if (left_next==false){
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            left_next=true;

        }
    }
    /* ACT psudeo code
    boolean left=true
    if found leaf:
        eat
    else if can move:
        move
    else:
        if left = true
            turn left
            move once
            turn left
            left =false
        else:
            turn left three times //(right turn)
            move 1
            turn left three times //(right turn)
            left = true
     */


    public void turnLeft() { //next : take int for repetitions
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
}
