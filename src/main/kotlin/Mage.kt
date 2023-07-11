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
            Thread.sleep(1000)
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
            Thread.sleep(1000)
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
            Thread.sleep(1000)
        } else {
            mage.manaUsage(500)
            println("Ultimate: ${this.name} casted Plasma Beam on $target ")
            val plasmaBeam = abilityPower * (2..5).random()
            target.takeDamage(plasmaBeam)
        }
    }

    override fun attack(target: Enemy) {
        mana += 200
        val attack = attackPower
        target.takeDamage(attack)
    }

    override fun spells(enemies: MutableList<Enemy>) {
        if (!mage.heroDead()) {
            println("---------------------------------")
            println("Great choice, you chose ${this.name}")
        }
        while (true) {
            if (!mage.heroDead()) {
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
                            if (mana < 100) {
                                mage.frostBolt(enemies.random())
                                continue
                            } else {
                                mage.frostBolt(enemies.random())
                                break
                            }

                        }

                        3 -> {
                            if (mana < 200) {
                                mage.rainOfFire(enemies)
                                continue
                            } else {
                                mage.rainOfFire(enemies)
                                break
                            }

                        }

                        4 -> {
                            if (mana < 500) {
                                mage.plasmaBeam(enemies.random())
                                continue
                            } else {
                                mage.plasmaBeam(enemies.random())
                                break
                            }
                        }

                        else -> {
                            println("False Number from attack, try again!")
                            println("-----------------------------------")
                        }
                    }
                } catch (e: Exception) {
                    println("You have to type number, not letter!!")

                }
            } else {
                println("This hero is DEAD!!")
                break
            }
            println("---------------------------------")
        }


    }
}