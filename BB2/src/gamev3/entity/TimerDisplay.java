package gamev3.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import gamev3.Handler;
import gamev3.entity.Entity;

public class TimerDisplay extends Entity{
	private Handler handler;
	private final static int TIMER_WIDTH = 50;
	private final static int TIMER_HEIGHT = 20;
	
	public TimerDisplay(Handler handler, float x, float y) {
		super(handler, x, y,TIMER_WIDTH,TIMER_HEIGHT);
		this.handler = handler;
	}

	Timer timer1;
	int second=0;
	int minute=0;
	String ddSecond, ddMinute;
	Font font1 = new Font("Arial", Font.PLAIN, 20);
	
	DecimalFormat dFormat = new DecimalFormat("00");

	Timer gametimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			second ++;
			ddSecond = dFormat.format(second);
			ddMinute = dFormat.format(minute);
			if(second==60) {
				minute++;
				second = 0;
			}
		}
	};
	
	public void start() {
		gametimer.scheduleAtFixedRate(task, 1000, 1000);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 12));
		g.drawString((ddMinute+":"+ddSecond), 470, 18);
	}
}