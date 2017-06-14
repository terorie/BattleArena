package com.glehudonsa.battlearena.spells

import com.glehudonsa.battlearena.blueprints.Champ
import com.glehudonsa.battlearena.blueprints.Spell

class TelescopicSight_Sniper_E : Spell
{
	override val spellName		 = "Telescopic Sight (E)"
	override val castType		 = Spell.CastType.PASSIVE
	override val castTarget		 = Spell.CastTarget.ONHIT
	override val spellType		 = Spell.SpellType.DAMAGE
	override val spellTarget	 = Spell.SpellTarget.SINGLE

	override val castRange		 = 0		// 0 = Infinite; In this case the <AttackRange> of the <Champion>

	override val baseDamage		 = 50
	override val baseCooldown	 = 600		// Frames = 600 / 60 = 10 seconds

	override val upgradeDamage	 = 100
	override val upgradeCooldown = 60		// Frames = 60 / 60 = 1 second

	override val upgradeMax		 = 5		// Max level

	override var manaCost		= 0

	// Leave as-is:
	override var level = 0
	var cooldown = 0

	override fun onHit(target: Champ)
	{
		if(currentCd == 0 && canHitTarget(target))
		{
			target.damage(currentDmg)
			cooldown = currentCd
		}
	}

	override fun cooldown()
	{
		if(cooldown > 0)
		{
			cooldown--
		}
	}

	override val desc: String
		get() = "Every <${cooldown/60}> seconds, the next basic attack deals <$currentDmg> additional damage."

	// TODO help glehu?
	override fun isExpired() = false

}
