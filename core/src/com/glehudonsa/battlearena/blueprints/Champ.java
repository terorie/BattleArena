package com.glehudonsa.battlearena.blueprints;

import com.badlogic.gdx.utils.Array;

public abstract class Champ
{
	private String name, team;
	private int id, hp, attackrange;

	private boolean invulnerable 	= false;
	private boolean canBeHitSpell	= true;
	private boolean canBeHitAttack	= true;

	private boolean silenced 	 	= false;

	private boolean isAlive		 	= true;

	private Array<Spell> spells  = new Array<>();
	private Array<Buff>  buffs   = new Array<>();
	private Array<Buff>  debuffs = new Array<>();

	private Array<Spell> toRemove_Spell   = new Array<>();
	private Array<Buff>  toRemove_Buff    = new Array<>();
	private Array<Buff>  toRemove_Debuff  = new Array<>();

	public Champ(){}

	public Champ(String name, int id, String team, boolean ranged)
	{
		this.name = name;
		this.id   = id;
		this.team = team;

		this.hp   = 500;

		if(ranged)
		{
			this.attackrange = 500;
		} else
		{
			this.attackrange = 100;
		}
	}

	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}
	public int getHp()
	{
		return hp;
	}
	public String getTeam()
	{
		return team;
	}
	public boolean isInvulnerable()
	{
		return invulnerable;
	}
	public boolean canBeHitSpell() { return canBeHitSpell; }
	public boolean canBeHitAttack() { return canBeHitAttack; }

	public boolean isSilenced()
	{
		return silenced;
	}
	public boolean isAlive()
	{
		return isAlive;
	}

	public void getInfo()
	{
		System.out.printf(
			"Champion %s crated as #%d in team %s.\n" +
			"Spells:\n",
				getName(),
				getId()+1,
				getTeam()
		);

		for(Spell spell : spells) System.out.println(spell.getInfo());
	}

	public void addSpell(Spell spell)
	{
		spells.add(spell);
	}
	public void addBuff(Buff buff)
	{
		buffs.add(buff);
	}
	public void addDebuff(Buff debuff)
	{
		debuffs.add(debuff);
	}

	public void setInvulnerable(boolean invulnerable)
	{
		this.invulnerable = invulnerable;
	}
	public void setSilenced(boolean silenced)
	{
		this.silenced = silenced;
	}

	public void damage(int damage)
	{
		if(!isInvulnerable() && isAlive())
		{
			hp -= damage;
		}
	}

	public void update()
	{
		for(Spell spell : spells)
		{
			if(!spell.isExpired())
			{
				spell.cooldown();
			} else
			{
				toRemove_Spell.add(spell);
			}
		}

		if(buffs.size > 0)
		{
			for (Buff buff : buffs)
			{
				if(!buff.isExpired())
				{
					buff.onTick();
				} else
				{
					buff.onExpire();
					toRemove_Buff.add(buff);
				}
			}
		}

		if(debuffs.size > 0)
		{
			for (Buff debuff : debuffs)
			{
				if(!debuff.isExpired())
				{
					debuff.onTick();
				} else
				{
					debuff.onExpire();
					toRemove_Debuff.add(debuff);
				}
			}
		}

		/* identity:
		 * - false uses A.equals(B) to compare
		 * - true  uses A == B      to compare */
		if(toRemove_Spell. size > 0)  spells.removeAll(toRemove_Spell,  true);
		if(toRemove_Buff.  size > 0)   buffs.removeAll(toRemove_Buff,   true);
		if(toRemove_Debuff.size > 0) debuffs.removeAll(toRemove_Debuff, true);

		toRemove_Spell.clear();
		toRemove_Buff.clear();
		toRemove_Debuff.clear();
	}
}
