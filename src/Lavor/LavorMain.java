package Lavor;

import java.awt.Window;
import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Image;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Vertex;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.Mouse;

public class LavorMain {
	
	public static RenderWindow window = new RenderWindow(new VideoMode(640,480),"문제 내기");
	public static RenderWindow window2 = new RenderWindow();
	public static RenderWindow window3 = new RenderWindow();
	public static Texture pan = new Texture();
	public static Texture no1 = new Texture();
	public static Texture no2 = new Texture();
	public static Texture no3 = new Texture();
	public static Texture no4 = new Texture();
	public static Texture no5 = new Texture();
	public static Texture no6 = new Texture();
	public static Texture no7 = new Texture();
	public static Texture no8 = new Texture();
	public static Texture no9 = new Texture();
	public static Texture no10 = new Texture();
	public static Texture no11 = new Texture();
	public static Texture no12 = new Texture();
	public static int reserv = 0;
	public static int[][] quastionpan = new int[5][5];
	public static int[][] quastionpan2 = new int[5][5];
	public static int[][] quastionpan3 = new int[5][5];
	public static int[][] panrotation = new int[5][5];
	public static int[][] panrotation2 = new int[5][5];
	public static int[][] panrotation3= new int[5][5];
	public static int[][] panlight = new int[5][5];
	public static boolean firwindow = true;
	public static boolean secwindow = false;
	public static boolean thirwindow = false;
	public static boolean play = false;
	public static boolean light = false;
	
	public static void main(String[] args) {
		try {
		    pan.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\pan.png"));
		    no1.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\1.png"));
		    no2.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\2.png"));
		    no3.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\3.png"));
		    no4.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\4.png"));
		    no5.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\5.png"));
		    no6.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\6.png"));
		    no7.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\7.png"));
		    no8.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\8.png"));
		    no9.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\9.png"));
		    no10.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\10.png"));
		    no11.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\answerpan.png"));
		    no12.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\meetquestionpan.png"));
		    
		} catch(IOException ex) {
		    ex.printStackTrace();
		}
		
		Sprite[] drawsprite = new Sprite[13];
		
		drawsprite[0] = new Sprite(pan);
		drawsprite[1] = new Sprite(no1);
		drawsprite[2] = new Sprite(no2);
		drawsprite[3] = new Sprite(no3);
		drawsprite[4] = new Sprite(no4);
		drawsprite[5] = new Sprite(no5);
		drawsprite[6] = new Sprite(no6);
		drawsprite[7] = new Sprite(no7);
		drawsprite[8] = new Sprite(no8);
		drawsprite[9] = new Sprite(no9);
		drawsprite[10] = new Sprite(no10);
		drawsprite[11] = new Sprite(no11);
		drawsprite[12] = new Sprite(no12);
		
		while(window.isOpen()||window2.isOpen()||window3.isOpen())
		{
			if(firwindow)
			{
				munjanagy(drawsprite);
			}
			else if(secwindow)
			{
				if(!window2.isOpen())
				{
					reserv = 0;
					window2.create(new VideoMode(640,480), "문제 정답");
					window.close();
				}
				secwindowact(drawsprite);
			}
			else if(thirwindow)
			{
				if(!window3.isOpen())
				{
					reserv = 0;
					window3.create(new VideoMode(1280,480), "문제 맞추기");
					window2.close();
				}
				thirwindowact(drawsprite);
			}
		}
	}
	
	public static void munjanagy(Sprite[] draw)
	{
		window.clear(Color.WHITE);
		for(Event event : window.pollEvents())
		{
			if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
				window.close();

			if(Mouse.isButtonPressed(Mouse.Button.LEFT))
			{
				Vector2i vec = Mouse.getPosition(window);
				if(vec.x-490<75&&vec.x-490>-75&&vec.y-60>-75&&vec.y<75)
				{
					int cnt = 0;
					
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
							if(quastionpan[i][j]!=0)
								cnt++;
					if(cnt == 0)
						System.out.println("문제를 제시하지 않으셨습니다");
					else
					{
						firwindow = false;
						secwindow = true;
					}
				}
				
				if(vec.x>450&&vec.x<520&&vec.y>100&&vec.y<175)
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
						{
							quastionpan[i][j] = 0;
							panrotation[i][j] = 0;
							reserv = 0;
							window.clear();
						}
				
				if((500-vec.x)*(500-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
					reserv = 1;
				else if((550-vec.x)*(550-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
					reserv = 3;
				else if((500-vec.x)*(500-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
					reserv = 4;
				else if((550-vec.x)*(550-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
					reserv = 6;
				else if((500-vec.x)*(500-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
					reserv = 8;
				else if((550-vec.x)*(550-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
					reserv = 9;
				else if((500-vec.x)*(500-vec.x) < 169&&(350-vec.y)*(350-vec.y)<169)
					reserv = 10;
				
				if(vec.x>40&&vec.x<430&&vec.y>105&&vec.y<450)
				{
					int y = (vec.y-105)/70;
					int x =	(vec.x-40)/80;
					switch(reserv)
					{
						case 1:
							if(quastionpan[y][x]==1)
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 1;
							break;
						case 3:
							if(quastionpan[y][x]==3)
								quastionpan[y][x] = 2;
							else if(quastionpan[y][x]==2)
								if(panrotation[y][x]/90%4==3)
								{
									quastionpan[y][x]=3;
									panrotation[y][x]+=90;
								}
								else
									panrotation[y][x]+=90;
							else
								quastionpan[y][x] = 3;
							break;
						case 4:
							if(quastionpan[y][x]==4)
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 4;
							break;
						case 6:
							if(quastionpan[y][x]==6)
								quastionpan[y][x] = 5;
							else if(quastionpan[y][x]==5)
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 6;
							break;
						case 8:
							if(quastionpan[y][x]==8)
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 8;
							break;
						case 9:
							if(quastionpan[y][x]==9)
								quastionpan[y][x] = 7;
							else if (quastionpan[y][x]==7) 
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 9;
							break;
						case 10:
							if(quastionpan[y][x]==10)
								panrotation[y][x] += 90;
							else
								quastionpan[y][x] = 10;
							break;
					}
				}
			}
		}

		draw[0].setOrigin(Vector2f.div(new Vector2f(pan.getSize()), 2));
		draw[1].setOrigin(Vector2f.div(new Vector2f(no1.getSize()), 2));
		draw[2].setOrigin(Vector2f.div(new Vector2f(no2.getSize()), 2));
		draw[3].setOrigin(Vector2f.div(new Vector2f(no3.getSize()), 2));
		draw[4].setOrigin(Vector2f.div(new Vector2f(no4.getSize()), 2));
		draw[5].setOrigin(Vector2f.div(new Vector2f(no5.getSize()), 2));
		draw[6].setOrigin(Vector2f.div(new Vector2f(no6.getSize()), 2));
		draw[7].setOrigin(Vector2f.div(new Vector2f(no7.getSize()), 2));
		draw[8].setOrigin(Vector2f.div(new Vector2f(no8.getSize()), 2));
		draw[9].setOrigin(Vector2f.div(new Vector2f(no9.getSize()), 2));
		draw[10].setOrigin(Vector2f.div(new Vector2f(no10.getSize()), 2));
		
		draw[0].setPosition(320, 240);
		draw[1].setPosition(500, 200);
		draw[3].setPosition(550, 200);
		draw[4].setPosition(500, 250);
		draw[6].setPosition(550, 250);
		draw[8].setPosition(500, 300);
		draw[9].setPosition(550, 300);
		draw[10].setPosition(500, 350);
	
		window.draw(draw[0]);
		for(int i = 1; i < 11; i++)
			if(draw[i].getPosition().x>0)
			{
				draw[i].setRotation(0);
				window.draw(draw[i]);
			}
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(quastionpan[i][j]>0)
				{
					draw[quastionpan[i][j]].setPosition(80+j*79,140+i*70);
					draw[quastionpan[i][j]].setRotation(panrotation[i][j]);
					window.draw(draw[quastionpan[i][j]]);
				}
		window.display();
	}
	
	public static void secwindowact(Sprite[] draw)
	{
		window2.clear(Color.WHITE);
		for(Event event : window2.pollEvents())
		{
			if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
				window2.close();

			if(Mouse.isButtonPressed(Mouse.Button.LEFT))
			{
				Vector2i vec = Mouse.getPosition(window2);
				
				int cnt = 0;
				
				for(int i = 0; i < 5; i++)
					for(int j = 0; j < 5; j++)
						if(quastionpan2[i][j]!=0)
							cnt++;
				
				if(vec.x>450&&vec.x<600&&vec.y>20&&vec.y<100)
					if(cnt == 0)
						System.out.println("정답을 입력하시지 않았습니다");
					else
					{
						thirwindow = true;
						secwindow = false;
					}
				
				if(vec.x>450&&vec.x<600&&vec.y>100&&vec.y<175)
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
						{
							quastionpan2[i][j] = 0;
							panrotation2[i][j] = 0;
							window2.clear();
						}

				if((500-vec.x)*(500-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
					reserv = 1;
				else if((550-vec.x)*(550-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
					reserv = 3;
				else if((500-vec.x)*(500-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
					reserv = 4;
				else if((550-vec.x)*(550-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
					reserv = 6;
				else if((500-vec.x)*(500-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
					reserv = 8;
				else if((550-vec.x)*(550-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
					reserv = 9;
				else if((500-vec.x)*(500-vec.x) < 169&&(350-vec.y)*(350-vec.y)<169)
					reserv = 10;
				
				if(vec.x>40&&vec.x<430&&vec.y>105&&vec.y<450)
				{
					int y = (vec.y-105)/70;
					int x =	(vec.x-40)/80;
					switch(reserv)
					{
						case 1:
							if(quastionpan2[y][x]==1)
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 1;
							break;
						case 3:
							if(quastionpan2[y][x]==3)
								quastionpan2[y][x] = 2;
							else if(quastionpan2[y][x]==2)
								if(panrotation2[y][x]/90%4==3)
								{
									quastionpan2[y][x]=3;
									panrotation2[y][x]+=90;
								}
								else
									panrotation2[y][x]+=90;
							else
								quastionpan2[y][x] = 3;
							break;
						case 4:
							if(quastionpan2[y][x]==4)
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 4;
							break;
						case 6:
							if(quastionpan2[y][x]==6)
								quastionpan2[y][x] = 5;
							else if(quastionpan2[y][x]==5)
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 6;
							break;
						case 8:
							if(quastionpan2[y][x]==8)
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 8;
							break;
						case 9:
							if(quastionpan2[y][x]==9)
								quastionpan2[y][x] = 7;
							else if (quastionpan2[y][x]==7) 
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 9;
							break;
						case 10:
							if(quastionpan2[y][x]==10)
								panrotation2[y][x] += 90;
							else
								quastionpan2[y][x] = 10;
							break;
					}
				}
			}
		}

		draw[11].setOrigin(Vector2f.div(new Vector2f(pan.getSize()), 2));
		draw[1].setOrigin(Vector2f.div(new Vector2f(no1.getSize()), 2));
		draw[2].setOrigin(Vector2f.div(new Vector2f(no2.getSize()), 2));
		draw[3].setOrigin(Vector2f.div(new Vector2f(no3.getSize()), 2));
		draw[4].setOrigin(Vector2f.div(new Vector2f(no4.getSize()), 2));
		draw[5].setOrigin(Vector2f.div(new Vector2f(no5.getSize()), 2));
		draw[6].setOrigin(Vector2f.div(new Vector2f(no6.getSize()), 2));
		draw[7].setOrigin(Vector2f.div(new Vector2f(no7.getSize()), 2));
		draw[8].setOrigin(Vector2f.div(new Vector2f(no8.getSize()), 2));
		draw[9].setOrigin(Vector2f.div(new Vector2f(no9.getSize()), 2));
		draw[10].setOrigin(Vector2f.div(new Vector2f(no10.getSize()), 2));
		
		draw[11].setPosition(320, 240);
		draw[1].setPosition(500, 200);
		draw[3].setPosition(550, 200);
		draw[4].setPosition(500, 250);
		draw[6].setPosition(550, 250);
		draw[8].setPosition(500, 300);
		draw[9].setPosition(550, 300);
		draw[10].setPosition(500, 350);
	
		window2.draw(draw[11]);
		window2.draw(draw[1]);
		window2.draw(draw[3]);
		window2.draw(draw[4]);
		window2.draw(draw[6]);
		window2.draw(draw[8]);
		window2.draw(draw[9]);
		window2.draw(draw[10]);
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				if(quastionpan2[i][j]>0)
				{
					draw[quastionpan2[i][j]].setPosition(80+j*79,140+i*70);
					draw[quastionpan2[i][j]].setRotation(panrotation2[i][j]);
					window2.draw(draw[quastionpan2[i][j]]);
				}
			}
		
		window2.display();
	}
	
	public static void thirwindowact(Sprite[] draw)
	{
		window3.clear(Color.WHITE);
		for(Event event : window3.pollEvents())
		{
			if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
			{
				window3.close();
			}
			if(Mouse.isButtonPressed(Mouse.Button.LEFT))
			{
				Vector2i vec = Mouse.getPosition(window3);
				
				int cnt = 0;
				
				for(int i = 0; i < 5; i++)
					for(int j = 0; j < 5; j++)
						if(quastionpan2[i][j]!=quastionpan3[i][j])
							cnt++;
				
				if(vec.x>450&&vec.x<530&&vec.y>20&&vec.y<100)
				{
					play = true;
				}
				
				if(vec.x>450&&vec.x<530&&vec.y>100&&vec.y<175)
				{
					for(int i = 0; i < 5; i++)
					{
						for(int j = 0; j < 5; j++)
						{
							quastionpan3[i][j] = 0;
							panrotation3[i][j] = 0;
							panlight[i][j]=0;
							window3.clear();
						}
					}
				}
				
				if(vec.x>530&&vec.x<600&&vec.y>20&&vec.y<100)
				{
					for(int i = 0; i < 5; i++)
					{
						for(int j = 0; j < 5; j++)
						{
							quastionpan3[i][j] = quastionpan2[i][j];
						}
					}
				}
				
				if(vec.x>530&&vec.x<600&&vec.y>100&&vec.y<175)
				{
					light = true;
					
					if(play == true)
					{	
						if(cnt == 0)
						{
							thirwindow = false;
							System.out.println("정답입니다");
						}
						else
						{
							System.out.println("오답입니다");
						}
					}
				}
				
				
				if(play == true)
				{
					if((500-vec.x)*(500-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
						reserv = 1;
					else if((550-vec.x)*(550-vec.x) < 169&&(200-vec.y)*(200-vec.y)<169)
						reserv = 3;
					else if((500-vec.x)*(500-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
						reserv = 4;
					else if((550-vec.x)*(550-vec.x) < 169&&(250-vec.y)*(250-vec.y)<169)
						reserv = 6;
					else if((500-vec.x)*(500-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
						reserv = 8;
					else if((550-vec.x)*(550-vec.x) < 169&&(300-vec.y)*(300-vec.y)<169)
						reserv = 9;
					else if((500-vec.x)*(500-vec.x) < 169&&(350-vec.y)*(350-vec.y)<169)
						reserv = 10;
					
					if(vec.x>40&&vec.x<430&&vec.y>105&&vec.y<450)
					{
						int y = (vec.y-105)/70;
						int x =	(vec.x-40)/80;
						switch(reserv)
						{
							case 1:
								if(quastionpan3[y][x]==1)
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 1;
								break;
							case 3:
								if(quastionpan3[y][x]==3)
									quastionpan3[y][x] = 2;
								else if(quastionpan3[y][x]==2)
									if(panrotation3[y][x]/90%4==3)
									{
										quastionpan3[y][x]=3;
										panrotation3[y][x]+=90;
									}
									else
										panrotation3[y][x]+=90;
								else
									quastionpan3[y][x] = 3;
								break;
							case 4:
								if(quastionpan3[y][x]==4)
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 4;
								break;
							case 6:
								if(quastionpan3[y][x]==6)
									quastionpan3[y][x] = 5;
								else if(quastionpan3[y][x]==5)
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 6;
								break;
							case 8:
								if(quastionpan3[y][x]==8)
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 8;
								break;
							case 9:
								if(quastionpan3[y][x]==9)
									quastionpan3[y][x] = 7;
								else if (quastionpan3[y][x]==7) 
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 9;
								break;
							case 10:
								if(quastionpan3[y][x]==10)
									panrotation3[y][x] += 90;
								else
									quastionpan3[y][x] = 10;
								break;
						}
					}
				}
			}
		}

		draw[0].setOrigin(Vector2f.div(new Vector2f(pan.getSize()), 2));
		draw[1].setOrigin(Vector2f.div(new Vector2f(no1.getSize()), 2));
		draw[2].setOrigin(Vector2f.div(new Vector2f(no2.getSize()), 2));
		draw[3].setOrigin(Vector2f.div(new Vector2f(no3.getSize()), 2));
		draw[4].setOrigin(Vector2f.div(new Vector2f(no4.getSize()), 2));
		draw[5].setOrigin(Vector2f.div(new Vector2f(no5.getSize()), 2));
		draw[6].setOrigin(Vector2f.div(new Vector2f(no6.getSize()), 2));
		draw[7].setOrigin(Vector2f.div(new Vector2f(no7.getSize()), 2));
		draw[8].setOrigin(Vector2f.div(new Vector2f(no8.getSize()), 2));
		draw[9].setOrigin(Vector2f.div(new Vector2f(no9.getSize()), 2));
		draw[10].setOrigin(Vector2f.div(new Vector2f(no10.getSize()), 2));
		draw[12].setOrigin(Vector2f.div(new Vector2f(no12.getSize()), 2));
		
		draw[12].setPosition(590, 240);
		draw[1].setPosition(500, 200);
		draw[3].setPosition(550, 200);
		draw[4].setPosition(500, 250);
		draw[6].setPosition(550, 250);
		draw[8].setPosition(500, 300);
		draw[9].setPosition(550, 300);
		draw[10].setPosition(500, 350);
		
		window3.draw(draw[12]);
		for(int i = 1; i < 11; i++)
			if(draw[i].getPosition().x>0)
			{
				draw[i].setRotation(0);
				window3.draw(draw[i]);
			}
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(quastionpan3[i][j]!=0)
				{
					draw[quastionpan3[i][j]].setPosition(80+j*79,140+i*70);
					draw[quastionpan3[i][j]].setRotation(panrotation3[i][j]);
					window3.draw(draw[quastionpan3[i][j]]);
				}
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				if(quastionpan[i][j]>0)
				{
					draw[quastionpan[i][j]].setPosition(790+j*79, 140+i*70);
					draw[quastionpan[i][j]].setRotation(panrotation[i][j]);
					window3.draw(draw[quastionpan[i][j]]);
				}
			}
		
		int[] cnt = new int[11];
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(quastionpan2[i][j] != 0)
					cnt[quastionpan2[i][j]]++;
		
		Font freeSans = new Font();
		try {
		    freeSans.loadFromFile(Paths.get("C:\\Users\\Administrator\\Desktop\\jaro\\arial.ttf"));
		} catch(IOException ex) {
		    ex.printStackTrace();
		}

		for(int i = 1; i <= 10; i++)
		{
			draw[i].setPosition(670,130+i*32);
			draw[i].setRotation(0);
			window3.draw(draw[i]);
			Text text = new Text("x"+ Integer.toString(cnt[i]),freeSans,10);
			text.setPosition(700,120+i*32);
			text.setColor(Color.BLACK);
			window3.draw(text);
		}
		if(light == true)
		{
			Loop1: for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					if(quastionpan3[i][j]==5)
					{
						panlight[i][j] = panrotation3[i][j]/90%4+1;
						break Loop1;
					}
					
			for(int i = 0; i < 25; i++)
			{
				for(int a = 0; a < 5; a++)
				{
					for(int b = 0; b < 5; b++)
					{
						if(b>0)//2 b-1
						{
							if(panlight[a][b]%10==2||panlight[a][b]/10==2)
							{
								switch(quastionpan3[a][b-1])
								{
								case 1:
									if(panrotation3[a][b-1]/90%4==0||panrotation3[a][b-1]/90%4==2)
										panlight[a][b-1]=3;
									else 
										panlight[a][b-1]=1;
									break;
								case 2:
									if(panrotation3[a][b-1]/90%4==0||panrotation3[a][b-1]/90%4==2)
										panlight[a][b-1]=23;
									else 
										panlight[a][b-1]=21;
									break;
								case 4:
									panlight[a][b-1]=0;
									break;
								case 7:
									if(panrotation3[a][b-1]/90%4==0)
									{
										panlight[a][b-1]=1;
									}
									else if(panrotation3[a][b-1]/90%4==1)
									{
										panlight[a][b-1]=3;
									}
								case 8:
									panlight[a][b-1]=0;
									break;
								default:
									panlight[a][b-1]=2;
									break;
								}
							}
						}
						if(b<4)//4 b+1
						{
							if(panlight[a][b]%10==4||panlight[a][b]/10==4)
							{
								switch(quastionpan3[a][b+1])
								{
								case 1:
									if(panrotation3[a][b+1]/90%4==0||panrotation3[a][b+1]/90%4==2)
										panlight[a][b+1]=1;
									else 
										panlight[a][b+1]=3;
									break;
								case 2:
									if(panrotation3[a][b+1]/90%4==0||panrotation3[a][b+1]/90%4==2)
										panlight[a][b+1]=41;
									else 
										panlight[a][b+1]=43;
									break;
								case 4:
									panlight[a][b+1]=0;
									break;
								case 7:
									if(panrotation3[a][b+1]/90%4==0)
									{
										panlight[a][b+1]=1;
									}
									else if(panrotation3[a][b+1]/90%4==1)
									{
										panlight[a][b+1]=3;
									}
								case 8:
									panlight[a][b+1]=0;
									break;
								default:
									panlight[a][b+1]=4;
									break;
								}
							}
						}
						if(a>0)//3 a-1
						{
							if(panlight[a][b]%10==3||panlight[a][b]/10==3)
							{
								switch(quastionpan3[a-1][b])
								{
								case 1:
									if(panrotation3[a-1][b]/90%4==0||panrotation3[a-1][b]/90%4==2)
										panlight[a-1][b]=2;
									else 
										panlight[a-1][b]=4;
									break;
								case 2:
									if(panrotation3[a-1][b]/90%4==0||panrotation3[a-1][b]/90%4==2)
										panlight[a-1][b]=32;
									else 
										panlight[a-1][b]=34;
									break;
								case 4:
									panlight[a-1][b]=0;
									break;
								case 7:
									if(panrotation3[a-1][b]/90%4==0)
									{
										panlight[a-1][b]=2;
									}
									else if(panrotation3[a-1][b]/90%4==1)
									{
										panlight[a-1][b]=4;
									}
								case 8:
									panlight[a-1][b]=0;
									break;
								default:
									panlight[a-1][b]=3;
									break;
								}
							}
						}
						if(a<4)//1 a+1
						{
							if(panlight[a][b]%10==1||panlight[a][b]/10==1)
							{
								switch(quastionpan3[a+1][b])
								{
								case 1:
									if(panrotation3[a+1][b]/90%4==0||panrotation3[a+1][b]/90%4==2)
										panlight[a+1][b]=4;
									else 
										panlight[a+1][b]=2;
									break;
								case 2:
									if(panrotation3[a+1][b]/90%4==0||panrotation3[a+1][b]/90%4==2)
										panlight[a+1][b]=14;
									else 
										panlight[a+1][b]=12;
									break;
								case 4:
									panlight[a+1][b]=0;
									break;
								case 7:
									if(panrotation3[a+1][b]/90%4==0)
									{
										panlight[a+1][b]=4;
									}
									else if(panrotation3[a+1][b]/90%4==1)
									{
										panlight[a+1][b]=2;
									}
								case 8:
									panlight[a+1][b]=0;
									break;
								default:
									panlight[a+1][b]=1;
									break;
								}
							}
						}
					}
				}
			}
			
			
			RectangleShape line = new RectangleShape();
			
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					switch(panlight[i][j]/10)
					{
					case 1:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(90);
						window3.draw(line);
						break;
					case 2:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(180);
						window3.draw(line);
						break;
					case 3:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(270);
						window3.draw(line);
						break;
					case 4:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(0);
						window3.draw(line);
						break;
					}
					
					switch(panlight[i][j]%10)
					{
					case 1:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(90);
						window3.draw(line);
						break;
					case 2:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(180);
						window3.draw(line);
						break;
					case 3:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(270);
						window3.draw(line);
						break;
					case 4:
						line.setSize(new Vector2f(75,5));
						line.setFillColor(Color.RED);
						line.setPosition(80+j*79,140+i*70);
						line.setRotation(0);
						window3.draw(line);
						break;
					}
				}
			}
			window3.display();
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex)
			{
				System.out.println(ex.getMessage());
			}
			light = false;
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					System.out.print(panlight[i][j]);
					panlight[i][j]=0;
				}
				System.out.println();
			}
		}
		window3.display();
	}
}
