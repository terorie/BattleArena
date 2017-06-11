package com.GlehuDonsa;

import com.GlehuDonsa.Blueprints.Champ;

import java.util.ArrayList;

public class Main
{

	private ArrayList<Champ> teamBlue = new ArrayList<>();
	private ArrayList<Champ> teamRed = new ArrayList<>();

	public static void main(String[] args)
	{
		new Main().init();
		new Main().run();
	}

	public void init()
	{
	}

	public void run()
	{
		boolean running = true;
		while(running)
		{
			for(Champ champ : teamBlue)
			{
				champ.update();
			}

			for(Champ champ : teamRed)
			{
				champ.update();
			}
		}
	}
}
