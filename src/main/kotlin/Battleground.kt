import java.lang.Exception
import java.lang.NumberFormatException

class Battleground {
    var heroes = mutableListOf<Heroes>(
        paladin,
        warrior,
        mage,
        priest
    )
    var enemies = mutableListOf<Enemy>(
        littleDragon,
        littleDragon1,
        littleDragon2,
        littleDragon3,
        littleDragon4
    )
    var boss = mutableListOf<Enemy>(
        bossDragon
    )

    fun entranceBattle() {
        while (heroes.isNotEmpty() || enemies.isNotEmpty()) {
            do {
                println("What hero are you choosing to attack an Enemy?")
                println(heroes)
                var auswahlHero = readln().toInt()
                when (auswahlHero) {
                    0 -> {
                        do {
                            println(paladin)
                            var auswahl = 0
                            println("\n[0] -> Attack with sword \n[1] -> Judgment(costs 100 mana)\n[2] -> Heal Of Righteous(costs ${paladin.abilityPower})\n[3] -> Wings of Justice (costs 300 mana)")
                            try {
                                auswahl = readln().toInt()
                            } catch (e: Exception) {
                                println("You have to type number, not letter!!")
                            }
                            when (auswahl) {
                                0 -> {
                                    paladin.attack(enemies.random())
                                }

                                1 -> {
                                    paladin.judgment(enemies.random())
                                }

                                2 -> {
                                    paladin.healOfRighteous()
                                }

                                3 -> {
                                    paladin.wingsOfJustice()
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while (auswahl > 3)

                    }

                    1 -> {
                        do {
                            println(warrior)
                            var auswahl = 0
                            println("\n[0] -> Attack with sword \n[1] -> Bladestorm (costs 100 mana)\n[2] -> Mortal Strike (costs 100 mana)\n[32] -> Execute (costs 300 mana)")
                            try {
                                auswahl = readln().toInt()
                            } catch (e: Exception) {
                                println("You have to type number, not letter!!")
                            }

                            when (auswahl) {
                                0 -> {
                                    warrior.attack(enemies.random())
                                }

                                1 -> {
                                    warrior.bladeStorm(enemies)
                                }

                                2 -> {
                                    warrior.mortalStrike(enemies.random())
                                }

                                3 -> {
                                    warrior.execute(enemies.random())
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while ((auswahl > 3))
                    }

                    2 -> {
                        do {
                            println(mage)
                            var auswahl = 0
                            println("\n[0] -> Attack with wand \n[1] -> Frostbolt(costs 100 mana) \n[2] -> Rain of Fire (costs 200 mana)\n[32] -> Plasma Beam (costs 500 mana)")
                            try {
                                auswahl = readln().toInt()
                            } catch (e: Exception) {
                                println("You have to type number, not letter!!")
                            }
                            when (auswahl) {
                                0 -> {
                                    mage.attack(enemies.random())
                                }

                                1 -> {
                                    mage.frostBolt(enemies.random())
                                }

                                2 -> {
                                    mage.rainOfFire(enemies)
                                }

                                3 -> {
                                    mage.plasmaBeam(enemies.random())
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while ((auswahl > 3))

                    }

                    3 -> do {
                        println(priest)
                        var auswahl = 0
                        println("\n[0] -> Attack with wand \n[1] -> Heal Touch (costs 200 mana)\n[2] -> Lighting Bolt (costs 100 mana)\n[32] -> Mass Heal (costs 500 mana)")
                        try {
                            auswahl = readln().toInt()
                        } catch (e: Exception) {
                            println("You have to type number, not letter!!")
                        }
                        when (auswahl) {
                            0 -> {
                                priest.attack(enemies.random())
                            }

                            1 -> {
                                priest.healTouch(heroes.random())
                            }

                            2 -> {
                                priest.lightingBolt(enemies.random())
                            }

                            3 -> {
                                priest.massHeal(heroes)
                            }

                            else -> {
                                println("False Number from attack, try again!")
                                println("-----------------------------------")
                            }
                        }
                    } while ((auswahl > 3))
                }
            } while (auswahlHero > 3)
            val newListEnemy = mutableListOf<Enemy>()
            for (enemy in enemies) {
                if (!enemy.enemyDead()) {
                    newListEnemy.add(enemy)
                }
            }
            enemies.clear()
            enemies.addAll(newListEnemy)
            if (enemies.isNotEmpty()) {
                var dragon = enemies.filterIsInstance<LittleDragon>()
                dragon.random().fireBolt(heroes.random())
            } else {
                println("You won the entrance battle. Congratulations!!")
                break
            }
            val newListHeroes = mutableListOf<Heroes>()
            for (hero in heroes) {
                if (!hero.heroDead())
                    newListHeroes.add(hero)
            }
            heroes.clear()
            heroes.addAll(newListHeroes)
            if (heroes.isEmpty()) {
                println("All Heroes are dead......\n GAME OVER")
                break
            }


        }
    }

    fun bossBattle() {

        while (heroes.isNotEmpty() || boss.isNotEmpty()) {
            if (heroes.isEmpty()){
                break
            }
            do {
                println("What hero are you choosing to attack an Enemy?")
                println(heroes)
                var auswahlHero = readln().toInt()
                when (auswahlHero) {
                    0 -> {
                        do {
                            println(paladin)
                            println("\n[0] -> Attack with sword \n[1] -> Judgment(costs 100 mana)\n[2] -> Heal Of Righteous(costs ${paladin.abilityPower})\n[3] -> Wings of Justice (costs 300 mana)")
                            var auswahl = readln().toInt()
                            when (auswahl) {
                                0 -> {
                                    paladin.attack(boss.random())
                                }

                                1 -> {
                                    paladin.judgment(boss.random())
                                }

                                2 -> {
                                    paladin.healOfRighteous()
                                }

                                3 -> {
                                    paladin.wingsOfJustice()
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while (auswahl > 3)

                    }

                    1 -> {
                        do {
                            println(warrior)
                            println("\n[0] -> Attack with sword \n[1] -> Bladestorm (costs 100 mana)\n[2] -> Mortal Strike (costs 100 mana)\n[32] -> Execute (costs 300 mana)")
                            var auswahl = readln().toInt()
                            when (auswahl) {
                                0 -> {
                                    warrior.attack(boss.random())
                                }

                                1 -> {
                                    warrior.bladeStorm(boss)
                                }

                                2 -> {
                                    warrior.mortalStrike(boss.random())
                                }

                                3 -> {
                                    warrior.execute(boss.random())
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while ((auswahl > 3))
                    }

                    2 -> {
                        do {
                            println(mage)
                            println("\n[0] -> Attack with wand \n[1] -> Frostbolt(costs 100 mana) \n[2] -> Rain of Fire (costs 200 mana)\n[32] -> Plasma Beam (costs 500 mana)")
                            val auswahl = readln().toInt()
                            when (auswahl) {
                                0 -> {
                                    mage.attack(boss.random())
                                }

                                1 -> {
                                    mage.frostBolt(boss.random())
                                }

                                2 -> {
                                    mage.rainOfFire(boss)
                                }

                                3 -> {
                                    mage.plasmaBeam(boss.random())
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while ((auswahl > 3))

                    }

                    3 -> {
                        do {
                            println(priest)
                            println("\n[0] -> Attack with wand \n[1] -> Heal Touch (costs 200 mana)\n[2] -> Lighting Bolt (costs 100 mana)\n[3] -> Mass Heal (costs 500 mana)")
                            var auswahl = readln().toInt()
                            when (auswahl) {
                                0 -> {
                                    priest.attack(boss.random())
                                }

                                1 -> {
                                    priest.healTouch(heroes.random())
                                }

                                2 -> {
                                    priest.lightingBolt(boss.random())
                                }

                                3 -> {
                                    priest.massHeal(heroes)
                                }

                                else -> {
                                    println("False Number from attack, try again!")
                                    println("-----------------------------------")
                                }
                            }
                        } while ((auswahl > 3))
                    }

                    else -> {
                        println("We have only 4 Heroes, try again!")
                        println("-----------------------------------")
                    }
                }
            } while (auswahlHero > 3)

            val newListEnemy = mutableListOf<Enemy>()
            for (boss in boss) {
                if (!boss.enemyDead()) {
                    newListEnemy.add(boss)
                }
            }
            boss.clear()
            boss.addAll(newListEnemy)
            if (boss.isNotEmpty()) {
                if (bossDragon.health >= 1500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireBreath(heroes.random())
                }
                if (bossDragon.health < 500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().cataclysm(heroes.random())
                }
                else if (bossDragon.health < 1000) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireFromWithin(heroes)
                    dragon.random().fireStrength()
                }
                else if (bossDragon.health < 1500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireBreath(heroes.random())
                    dragon.random().fireStrength()
                }

            } else {
                println("You won the battle against mighty $bossDragon!! Congratulations, the realm is now in safe place!!")
                break
            }
            val newListHeroes = mutableListOf<Heroes>()
            for (hero in heroes) {
                if (!hero.heroDead())
                    newListHeroes.add(hero)
            }
            heroes.clear()
            heroes.addAll(newListHeroes)
            if (heroes.isEmpty()) {
                break
            }


        }

    }

}






