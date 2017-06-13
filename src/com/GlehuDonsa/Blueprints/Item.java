package com.GlehuDonsa.Blueprints;

public interface Item
{
	boolean hasSubitems	= false;

	boolean hasActive 	= false;
	boolean hasPassive  = false;

	boolean canConsume	= false;

	void onActivation();		// For active items
	void onHit();				// For items with OnHit passives

	int strength		= 0;	// Pretty much like Dota 2 (shhhhh)
	int intelligence	= 0;
	int agility			= 0;

}