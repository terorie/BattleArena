package com.GlehuDonsa;

import com.GlehuDonsa.Blueprints.Champ;
import com.GlehuDonsa.Champions.Sniper;
import com.GlehuDonsa.Spells.TelescopicSight_Sniper_E;

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
		Sniper sniper = new Sniper("Sniper", 0, "Blue");
		TelescopicSight_Sniper_E sniper_e = new TelescopicSight_Sniper_E();
		sniper.addSpell(sniper_e);
		teamBlue.add(sniper);

		sniper.getInfo();
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
