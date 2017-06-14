package com.GlehuDonsa.Blueprints;

public interface Buff
{
	int duration 			= 0;	// Frames
	int damage				= 0;
	int healing				= 0;

	boolean canBeRemoved 	= true;
	boolean debuff			= false;
	boolean isExpired		= false;

	String BUFF_TYPE		= "";	// DAMAGE, HEALING, MOVEMENT (CC)

	void onTick();
	void onExpire();

	boolean isExpired();
}
