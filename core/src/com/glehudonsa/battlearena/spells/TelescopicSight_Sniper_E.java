package com.glehudonsa.battlearena.spells;

import com.glehudonsa.battlearena.blueprints.Champ;
import com.glehudonsa.battlearena.blueprints.Spell;

public class TelescopicSight_Sniper_E implements Spell
{
	private String SPELL_NAME;
	private String CAST_TYPE;			// TRIGGER, TOGGLE, CHANNEL, PASSIVE
	private String CAST_TARGET;			// UNIT, SELF, AUTO, GROUND, DIRECTION, ONHIT, NON
	private String SPELL_TYPE;			// DAMAGE, HEALING, MOVEMENT, BUFF
	private String SPELL_TARGET;		// SINGLE, AREA


	private int castRange;
	private int baseDamage;
	private int upgradeDamage;
	private int upgradeCooldown;		// Frames
	private int upgradeMax;				// Max Level
	private int current_dmg;

	private int manacost;
	private int level;
	private int baseCooldown;			// Frames
	private int current_cd;				// Frames

	private int cooldown;				// Frames

	private boolean isExpired;

	public TelescopicSight_Sniper_E()
	{
		SPELL_NAME		= "Telescopic Sight (E)";
		CAST_TYPE 		= "PASSIVE";	// TRIGGER, TOGGLE, CHANNEL, PASSIVE
		CAST_TARGET 	= "ONHIT";		// UNIT, SELF, AUTO, GROUND, DIRECTION, ONHIT, NON
		SPELL_TYPE 		= "DAMAGE";		// DAMAGE, HEALING, MOVEMENT, BUFF
		SPELL_TARGET 	= "SINGLE";		// SINGLE, AREA


		castRange 		= 0;			// 0 = Infinite; In this case the <AttackRange> of the <Champion>

		baseDamage 		= 50;
		baseCooldown	= 600;			// Frames = 600 / 60 = 10 seconds

		upgradeDamage 	= 100;
		upgradeCooldown	= 60;			// Frames = 60 / 60 = 1 second

		upgradeMax 		= 5;			// Max Level

		current_dmg		= baseDamage   + (level * upgradeDamage);
		current_cd		= baseCooldown - (level * upgradeCooldown);

		manacost		= 0;

		// Leave as-is:
		level			= 0;
		cooldown		= 0;
		isExpired 		= false;
	}

	public boolean canHitTarget(Champ target)
	{
		return target.canBeHitSpell();
	}

	public void onHit(Champ target)
	{
		if(current_cd == 0 && canHitTarget(target))
		{
			target.damage(current_dmg);
			cooldown = current_cd;
		}
	}
	public void cooldown()
	{
		if(cooldown > 0)
		{
			cooldown--;
		}

	}
	public void upgrade()
	{
		if(level < upgradeMax)
		{
			level++;
			current_dmg	= baseDamage + (level * upgradeDamage);
		}
	}

	public String getInfo()
	{
		return "--------------------------------------------------------------------------\n" +
		""                  + SPELL_NAME +
		"\nCast type:\t\t"  + CAST_TYPE +
		"\nCast target:\t"  + CAST_TARGET +
		"\nSpell type:\t\t" + SPELL_TYPE +
		"\nSpell target:\t" + SPELL_TARGET +
		"\nDescription:"    +
		"\nEvery <" + cooldown/60 + "> seconds, the next basic attack deals <" + current_dmg + "> additional damage." +
		"\n--------------------------------------------------------------------------\n";
	}

	public boolean isExpired()
	{
		return isExpired;
	}
}
