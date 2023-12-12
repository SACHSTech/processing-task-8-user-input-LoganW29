import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(12, 122, 232);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  
   public void draw() {
    if (drawClouds == true) {
      for (int i = 10; i < width; i += 90){
      drawCloud(i, 40);
      }
    }
    
  }

  public void keyReleased() {
    if (keyCode == UP) {
      drawClouds = false;
    }
  }
  
  public void mousePressed() {
    drawFlower(mouseX, mouseY);
  }

  public void keyPressed() {

    // Change background colour if the 'B' or 'b' key is pressed 
    if (key == 'B' || key == 'b') {
    changeBackground(28, 52, 115);
    }
    // if the up key is pressed it draws a cloud where the mouse cursor is
    if (keyCode == UP) {
      drawClouds = true;
    } 
    
  }   
  /**
   * Changes the background if a key is pressed 
   * @param intR determines red 
   * @param intG determines green 
   * @param intB determines blue 
   */
  public void changeBackground(int intR, int intG, int intB) {
    background(intR, intG, intB);
  }

  /**
   * Calculations to draw flower
   * @param intX
   * @param intY
   */
  public void drawFlower(int intX, int intY) {
    stroke(0);
    fill(47, 145, 42);
    rect(intX - 10, intY + 20, 10, 50);
   
    fill(232, 12, 188);
    ellipse(intX + 10, intY + 30, 30, 30);
    ellipse(intX - 20, intY + 30, 30, 30);
    ellipse(intX + 10, intY, 30, 30);
    ellipse(intX - 20, intY, 30, 30);
   
    fill(219, 76, 29);
    ellipse (intX - 5, intY + 15, 30, 30);

  }

  public void mouseDragged() {
    drawGrass(mouseX, mouseY);

  }
   
  /**
   * Draws grass where the mouse is dragged
   * @param intX
   * @param intY
   */
  public void drawGrass(float fltX, float fltY) {
    if (mouseY > 300){
    noStroke();
    fill(66, 245, 96);
    ellipse(fltX, fltY, 30, 30);
    }
  }


  boolean drawClouds = false;
 
  public void drawCloud(int intX, int intY){
    
    if (keyCode == UP){
    noStroke();
    fill(255);
    ellipse(intX + 5, intY + 15, 30, 30);
    ellipse(intX - 10, intY + 15, 30, 30);
    ellipse(intX + 10, intY, 30, 30);
    ellipse(intX - 5, intY, 30, 30);
    }
  }


}