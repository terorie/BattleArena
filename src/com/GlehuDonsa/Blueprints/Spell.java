package com.GlehuDonsa.Blueprints;

public interface Spell
{
	String CAST_TYPE 	= "";	// TRIGGER, TOGGLE, CHANNEL
	String CAST_TARGET 	= "";	// UNIT, SELF, AUTO, GROUND, DIRECTION
	String SPELL_TYPE 	= "";	// DAMAGE, HEALING, MOVEMENT
	String SPELL_TARGET = "";	// SINGLE, AREA


	int castRange		= 0;
	int baseDamage 		= 0;
	int upgradeDamage 	= 0;
	int upgradeMax 		= 0;	// Max Level

	int cooldown		= 0;	// Frames

	boolean isExpired	= false;

	void onHit();
	void cooldown();

	boolean isExpired();
}
