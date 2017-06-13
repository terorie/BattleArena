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
	int upgradeCooldown	= 0;
	int upgradeMax 		= 0;	// Max level

	int currentDmg		= 0;

	int manacost		= 0;
	int level			= 0;
	int baseCooldown	= 0;	// Frames

	int currentCd		= 0;

	boolean isExpired	= false;

	boolean canHitTarget(Champ target);
	void onHit(Champ target);

	void cooldown();

	void upgrade();

	String getInfo();

	boolean isExpired();
}
