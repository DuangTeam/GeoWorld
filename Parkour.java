/*
 * 	GeoWorld -- Parkour Game
 */

import java.util.Random;
import processing.core.PApplet;

public class Parkour extends PApplet{
	
	Random rand = new Random();
	public float x = 0, y = 0, v = 4, a = 0;
	public int num = rand.nextInt(3), q = 0;
	
	public void settings(){
		
		size(1500, 1000);
		
	}
	
	public void setup(){

		stroke(0);
		noFill();
		
	}
	
	public void draw(){
		
		background(255);
		
		v += a;
		x += v;
		switch(num){
			case 0:
				drawTriangle(1500 - x, 500, 150);
				if(x >= 1540){
					q++;
					a += (q % 6 == 0 && q != 0) ? 0.003 : 0;
					if(q >= 6){
						num = rand.nextInt(4);
					}else{
						num = rand.nextInt(2);
					}
					x = num == 2 ? -100 : -75;
				}
				break;
			case 1:
				drawSquare(1500 - x, 500, 150);
				if(x >= 1540){
					q++;
					a += (q % 6 == 0 && q != 0) ? 0.003 : 0;
					if(q >= 6){
						num = rand.nextInt(4);
					}else{
						num = rand.nextInt(2);
					}
					x = num == 2 ? -100 : -75;
				}
				break;
			case 2:
				drawCircle(1500 - x, 450, 100);
				if(x >= 1600){
					q++;
					a += (q % 6 == 0 && q != 0) ? 0.003 : 0;
					num = rand.nextInt(3);
					x = num == 2 ? -100 : -75;
				}
				break;
			case 3:
				y += v * 2 / 3;
				drawFalling(1500 - x, y);
				if(x >= 1540){
					q++;
					a += (q % 6 == 0 && q != 0) ? 0.003 : 0;
					num = rand.nextInt(4);
					x = num == 2 ? -100 : -75;
				}
				break;
				
			default:
				break;
		}
	}
	
	public void drawTriangle(float xPos, float yPos, float len){
			
		triangle(xPos, yPos - len / 2 * (float)(Math.sqrt(3)), xPos - len / 2, yPos, xPos + len / 2, yPos);
		line(xPos + len / 6, yPos, xPos + len / 3, yPos - len / 6 * (float)(Math.sqrt(3)));
		line(xPos - len / 6, yPos, xPos + len / 6, yPos - 2 * len / 6 * (float)(Math.sqrt(3)));
		
	}
	
	public void drawSquare(float xPos, float yPos, float len){
		
		noFill();
		rect(xPos - len / 2, yPos - len, len, len);
		fill(0);
		ellipse(xPos - len / 4 + 5, yPos - len * 3 / 4, len / 2, len / 2);
		fill(0);
		ellipse(xPos + len / 4 - 5, yPos - len / 4, len / 2, len / 2);
		noFill();
		
	}
	
	public void drawCircle(float xPos, float yPos, float radius){
		
		ellipse(xPos, yPos - radius, 2 * radius, 2 * radius);
		rect(xPos - (float)(Math.sqrt(2)) / 2 * radius, yPos - radius - (float)(Math.sqrt(2)) / 2 * radius, (float)(Math.sqrt(2)) * radius, (float)(Math.sqrt(2)) * radius);
		line(xPos, yPos - radius - (float)(Math.sqrt(2)) / 2 * radius, xPos - (float)(Math.sqrt(2)) / 2 * radius, yPos - radius);
		line(xPos - (float)(Math.sqrt(2)) / 2 * radius, yPos - radius, xPos, yPos - radius + (float)(Math.sqrt(2)) / 2 * radius);
		line(xPos, yPos - radius + (float)(Math.sqrt(2)) / 2 * radius, xPos + (float)(Math.sqrt(2)) / 2 * radius, yPos - radius);
		line(xPos + (float)(Math.sqrt(2)) / 2 * radius, yPos - radius, xPos, yPos - radius - (float)(Math.sqrt(2)) / 2 * radius);
		fill(0);
		ellipse(xPos, yPos - radius, 10, 10);
		noFill();
		
	}
	
	public void drawFalling(float xPos, float yPos){
		
		rect(xPos, yPos, 150, 40);
		line(xPos, yPos, xPos + 150, yPos + 40);
		line(xPos + 40, yPos, xPos + 150, yPos + 40);
		
	}
	
	
	public static void main(String[] args){
		
		PApplet.main("Parkour");
		
	}

}
