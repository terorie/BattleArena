package com.GlehuDonsa.Blueprints;

public interface Spell
{
	String SPELL_NAME	= "";
	String CAST_TYPE 	= "";	// TRIGGER, TOGGLE, CHANNEL, PASSIVE
	String CAST_TARGET 	= "";	// UNIT, SELF, AUTO, GROUND, DIRECTION
	String SPELL_TYPE 	= "";	// DAMAGE, HEALING, MOVEMENT
	String SPELL_TARGET = "";	// SINGLE, AREA


	int castRange		= 0;
	int baseDamage 		= 0;
	int upgradeDamage 	= 0;
	int upgradeMax 		= 0;	// Max Level

	int manacost		= 0;
	int level			= 0;
	int cooldown		= 0;	// Frames

	boolean isExpired	= false;

	void onHit(Champ target);
	void cooldown();
	void upgrade();

	String getInfo();

	boolean isExpired();
}
