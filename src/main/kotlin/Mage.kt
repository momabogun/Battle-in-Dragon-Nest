import java.lang.Exception

class Mage(
    name: String,
    maxHP: Int,
    level: Int,
    exp: Int,
    maxMana: Int,
    attackPower: Int,
    abilityPower: Int
) : Heroes(name, maxHP, level, exp, maxMana, attackPower, abilityPower) {
    override fun toString(): String {
        return "\n[3] -> ${this.name}(Mage, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }

    fun frostBolt(target: Enemy) {
        if (mana < 100) {
            println("You have no Mana for this spell!!")
        } else {
            println("${this.name} casts Frost Bolt on $target")
            mage.manaUsage(100)
            val frostBolt = abilityPower * (1..2).random()
            target.takeDamage(frostBolt)
        }

    }

    fun rainOfFire(target: MutableList<Enemy>) {
        if (mana < 200) {
            println("You have no Mana for this spell")
        } else {
            mage.manaUsage(200)
            println("${this.name} casted Rain of Fire!!")
            val rainOfFire = abilityPower / 2
            for (enemy in target) {
                enemy.takeDamage(rainOfFire)
            }

        }
    }

    fun plasmaBeam(target: Enemy) {
        if (mana < 500) {
            println("You have no Mana for this spell")
        } else {
            mage.manaUsage(500)
            println("Ultimate: ${this.name} casted Plasma Beam on $target ")
            val plasmaBeam = abilityPower * (2..5).random()
            target.takeDamage(plasmaBeam)
        }
    }

    override fun spells(enemies: MutableList<Enemy>) {
        println("---------------------------------")
        println("Great choice, you chose ${this.name}")
        while (true) {
            println(mage)
            println("---------------------------------")
            println("Choose your attack:")
            println("\n[1] -> Attack with wand \n[2] -> Frostbolt(costs 100 mana) \n[3] -> Rain of Fire (costs 200 mana)\n[4] -> Plasma Beam (costs 500 mana)")
            try {
                var auswahl = readln().toInt()
                when (auswahl) {
                    1 -> {
                        mage.attack(enemies.random())
                        break
                    }

                    2 -> {
                        mage.frostBolt(enemies.random())
                        break
                    }

                    3 -> {
                        mage.rainOfFire(enemies)
                        break
                    }

                    4 -> {
                        mage.plasmaBeam(enemies.random())
                        break
                    }

                    else -> {
                        println("False Number from attack, try again!")
                        println("-----------------------------------")
                    }
                }
            } catch (e: Exception) {
                println("You have to type number, not letter!!")

            }
        }
        println("---------------------------------")
    }


}