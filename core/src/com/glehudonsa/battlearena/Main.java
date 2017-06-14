package com.glehudonsa.battlearena;

import com.glehudonsa.battlearena.blueprints.Champ;
import com.glehudonsa.battlearena.champions.Sniper;
import com.glehudonsa.battlearena.spells.TelescopicSight_Sniper_E;

import java.util.ArrayList;
import com.badlogic.gdx.ApplicationAdapter;

public class Main extends ApplicationAdapter
{

	private ArrayList<Champ> teamBlue = new ArrayList<>();
	private ArrayList<Champ> teamRed = new ArrayList<>();

	@Override
	public void create()
	{
		Sniper sniper = new Sniper("Sniper", 0, "Blue");
		TelescopicSight_Sniper_E sniper_e = new TelescopicSight_Sniper_E();
		sniper.addSpell(sniper_e);
		teamBlue.add(sniper);

		sniper.getInfo();
	}

	@Override
	public void render()
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
