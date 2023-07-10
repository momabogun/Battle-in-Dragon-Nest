import java.lang.Exception

class Warrior(
    name: String,
    maxHP: Int,
    level: Int,
    exp: Int,
    maxMana: Int,
    attackPower: Int,
    override var abilityPower: Int = 0
) : Heroes(name, maxHP, level, exp, maxMana, attackPower, abilityPower) {
    override fun toString(): String {
        return "\n[2] -> ${this.name}(Warrior, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }

    override var mana = 0
    fun bladeStorm(target: MutableList<Enemy>) {
        if (mana < 100) {
            println("You have no mana for this Spell!!")
        } else {
            warrior.manaUsage(100)
            println("${this.name} casted Blade Storm!!")
            val bladeStorm = attackPower / 2
            for (enemy in target) {
                enemy.takeDamage(bladeStorm)
            }
        }
    }

    fun mortalStrike(target: Enemy) {
        if (mana < 100) {
            println("You have no mana for this Spell!!")
        } else {
            warrior.manaUsage(100)
            println("${this.name} casted Mortal Strike!!")
            val mortalStrike = attackPower * 2
            target.takeDamage(mortalStrike)
        }
    }

    fun execute(target: Enemy) {
        if (mana < 300) {
            println("You have no mana for this Spell!!")
        } else {
            warrior.manaUsage(300)
            println("ULTIMATE.${this.name} casted Execute!!")
            val execute = (0.2 * target.health).toInt()
            println("Execute did $execute DMG")
            target.takeDamage(execute)
        }
    }

    override fun spells(enemies: MutableList<Enemy>) {
        println("---------------------------------")
        println("Great choice, you chose ${this.name}, beware warrior gains mana with normal attacks!")
        while (true) {
            println(warrior)
            println("---------------------------------")
            println("Choose your attack:")
            println("[1] -> Attack with sword \n[2] -> Bladestorm (costs 100 mana)\n[3] -> Mortal Strike (costs 100 mana)\n[4] -> Execute (costs 300 mana)")
            try {
                var auswahl = readln().toInt()
                when (auswahl) {
                    1 -> {
                        warrior.attack(enemies.random())
                        break
                    }

                    2 -> {
                        warrior.bladeStorm(enemies)
                        break
                    }

                    3 -> {
                        warrior.mortalStrike(enemies.random())
                        break
                    }

                    4 -> {
                        warrior.execute(enemies.random())
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