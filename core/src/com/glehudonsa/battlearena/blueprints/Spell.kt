package com.glehudonsa.battlearena.blueprints

interface Spell
{

	enum class CastType {
		TRIGGER, TOGGLE, CHANNEL, PASSIVE
	}

	enum class CastTarget {
		UNIT, SELF, AUTO, GROUND, DIRECTION, ONHIT, NON
	}

	enum class SpellType {
		DAMAGE, HEALING, MOVEMENT
	}

	enum class SpellTarget {
		SINGLE, AREA
	}

	/* Kotlin is useful here because in Java you would need
	 *
	 * String getSpellName()
	 *   and
	 * @Override public String getSpellName() { return … };
	 *
	 * everytime. Kotlin is much shorter*/

	val spellName:		String
	val castType:		CastType
	val castTarget:		CastTarget
	val spellType:		SpellType
	val spellTarget:	SpellTarget

	val castRange:		Int
	val baseDamage:		Int
	val upgradeDamage:	Int
	val upgradeCooldown:Int
	val upgradeMax:		Int // Max level

	var manaCost:		Int
	var level:			Int
	val baseCooldown:	Int // Frames

	fun canHitTarget(target: Champ) = target.canBeHitSpell()
	fun onHit(target: Champ)

	fun cooldown()

	fun upgrade()
	{
		if(level < upgradeMax)
		{
			level++;
		}
	}

	fun isExpired(): Boolean

	fun getInfo() =
"""--------------------------------------------------------------------------
$spellName
Cast type:		$spellName
Cast target:	$castTarget
Spell type:		$spellType
Spell target:	$spellTarget
Description:
$desc
--------------------------------------------------------------------------"""

	val desc:		String

	// A function. Can be called from java: getCurrentDmg()
	val currentDmg
		get() = baseDamage + (level * upgradeDamage)

	val currentCd
		get() = baseCooldown - (level * upgradeCooldown)

}
