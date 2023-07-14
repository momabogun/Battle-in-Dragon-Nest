import java.lang.Exception

class Paladin(
    name: String,
    maxHP: Int,
    level: Int,
    exp: Int,
    maxMana: Int,
    attackPower: Int,
    abilityPower: Int

) : Heroes(name, maxHP, level, exp, maxMana, attackPower, abilityPower) {
    override fun toString(): String {
        return "1] -> ${this.name}(Paladin, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }

    fun judgment(target: Enemy) {
        println("Paladin mana: ${this.mana}")
        if (mana < 100) {
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else {
            paladin.manaUsage(100)
            println("${this.name} casted Judgment!!")
            val judgment = attackPower + ((abilityPower / 2) * level)
            target.takeDamage(judgment)
        }
    }

    fun healOfRighteous() {
        if (mana < abilityPower) {
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else if (this.health == this.maxHP) {
            println("You have already full HP!!")

        } else {
            paladin.manaUsage(abilityPower)
            paladin.heal(abilityPower)
            println("${this.name} has ${this.health}/${this.maxHP}")
        }
    }

    fun wingsOfJustice() {
        if (mana < 300) {
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else {
            paladin.manaUsage(300)
            println("ULTIMATE. ${this.name} has now new form Wings of Justice")
            this.abilityPower *= 4
            this.attackPower *= 2

        }

    }

    override fun spells(enemies: MutableList<Enemy>) {
        if (!paladin.heroDead()) {
            println("---------------------------------")
            println("Great choice, you chose ${this.name}")
        }
        while (true) {
            if (!paladin.heroDead()) {
                println(paladin)
                println("---------------------------------")
                println("Choose your attack:")
                println("[1] -> Attack with sword \n[2] -> Judgment(costs 100 mana)\n[3] -> Heal Of Righteous(costs ${paladin.abilityPower})\n[4] -> Wings of Justice (costs 300 mana)")
                try {
                    var auswahl = readln().toInt()
                    when (auswahl) {
                        1 -> {
                            paladin.attack(enemies.random())
                            break
                        }

                        2 -> {
                            if (mana < 100) {
                                paladin.judgment(enemies.random())
                                continue
                            } else {
                                paladin.judgment(enemies.random())
                                break
                            }
                        }

                        3 -> {
                            if (mana < abilityPower || this.health == this.maxHP) {
                                paladin.healOfRighteous()
                                continue
                            } else {
                                paladin.healOfRighteous()
                                break
                            }

                        }

                        4 -> {
                            if (mana < 300) {
                                paladin.wingsOfJustice()
                                continue
                            } else {
                                paladin.wingsOfJustice()
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