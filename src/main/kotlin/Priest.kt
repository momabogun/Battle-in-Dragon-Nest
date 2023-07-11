import java.lang.Exception

class Priest(name: String,
             maxHP:Int,
             level: Int,
             exp :Int,
             maxMana: Int,
             attackPower: Int,
             abilityPower:Int
):Heroes(name,maxHP,level,exp,maxMana,attackPower,abilityPower) {
    override fun toString(): String {
        return "\n[4] -> ${this.name}(Priest, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }
    fun healTouch(target:Heroes){
        if (mana<200){
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else if (target.health == target.maxHP){
            println("${target.name} is full HP!!")
            Thread.sleep(1000)
        }
        else {
            println("${this.name} casts healing touch on ${target.name}")
            priest.manaUsage(200)
            target.heal(200)
        }
    }
    fun lightingBolt(target: Enemy){
        if (mana < 100){
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else{
            println("${this.name} casts lighting bolt on $target")
            priest.manaUsage(100)
            target.takeDamage(abilityPower)
        }

    }
    fun massHeal(target: MutableList<Heroes>){
        if (mana < 500){
            println("You have no mana for this Spell!!")
            Thread.sleep(1000)
        } else{
            println("ULTIMATE: ${this.name} casts Mass Heal on his allies")
            priest.manaUsage(500)
            for (hero in target){
                hero.heal(abilityPower/2)
            }
        }
    }

    override fun attack(target: Enemy) {
        mana += 200
        health += 100
        val attack = attackPower
        target.takeDamage(attack)
    }

    fun spells(enemies: MutableList<Enemy>, heroes: MutableList<Heroes>) {
        if (!priest.heroDead()) {
            println("---------------------------------")
            println("Great choice, you chose ${this.name}")
        }
        while (true) {
            if (!priest.heroDead()){
                println(priest)
                println("---------------------------------")
                println("Choose your attack:")
                println("[1] -> Attack with wand(heals for 100 when attack enemy) \n[2] -> Heal Touch (costs 200 mana)\n[3] -> Lighting Bolt (costs 100 mana)\n[4] -> Mass Heal (costs 500 mana)")
                try {
                    val auswahl = readln().toInt()
                    when (auswahl) {
                        1 -> {
                            priest.attack(enemies.random())
                            break
                        }

                        2 -> {
                            if (mana < 200 || heroes.random().health == heroes.random().maxHP) {
                                priest.healTouch(heroes.random())
                                continue
                            } else {
                                priest.healTouch(heroes.random())
                                break
                            }


                        }

                        3 -> {
                            if (mana < 100) {
                                priest.lightingBolt(enemies.random())
                                continue
                            } else {
                                priest.lightingBolt(enemies.random())
                                break
                            }

                        }

                        4 -> {
                            if (mana < 500) {
                                priest.massHeal(heroes)
                                continue
                            } else {
                                priest.massHeal(heroes)
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
            } else{
                println("This hero is DEAD!!")
                break
            }
            println("---------------------------------")
        }
    }
}
