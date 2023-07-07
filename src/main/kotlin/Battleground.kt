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
    fun entranceBattle() {
        while (heroes.isNotEmpty() || enemies.isNotEmpty()){
        val newListHeroes = mutableListOf<Heroes>()
        for (hero in heroes) {
            if (!hero.heroDead())
                newListHeroes.add(hero)
        }
        heroes.clear()
        heroes.addAll(newListHeroes)
            var auswahlHero: Int
                println("What hero are you choosing to attack an Enemy?")
                println(heroes)
                auswahlHero = readln().toInt()
                when (auswahlHero) {
                    1 -> {
                        do {
                            println(paladin)
                            println("\n[0] -> Attack with sword \n[1] -> Judgment(costs 100 mana)\n[2] -> Heal Of Righteous(costs ${paladin.abilityPower})\n[3] -> Wings of Justice (costs 300 mana)")
                            var auswahl = readln().toInt()
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

                    2 -> {
                        do {
                            println(warrior)
                            println("\n[0] -> Attack with sword \n[1] -> Bladestorm (costs 100 mana)\n[2] -> Mortal Strike (costs 100 mana)\n[32] -> Execute (costs 300 mana)")
                            var auswahl = readln().toInt()
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
                    3 ->{
                        do {
                            println(mage)
                            println("\n[0] -> Attack with wand \n[1] -> Frostbolt(costs 100 mana) \n[2] -> Rain of Fire (costs 200 mana)\n[32] -> Plasma Beam (costs 500 mana)")
                            val auswahl = readln().toInt()
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
                    4 -> do {
                        println(priest)
                        println("\n[0] -> Attack with wand \n[1] -> Heal Touch (costs 200 mana)\n[2] -> Lighting Bolt (costs 100 mana)\n[32] -> Mass Heal (costs 500 mana)")
                        var auswahl = readln().toInt()
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
            } else{
                println("You won the entrance battle. Congratulations!!")
                break
            }


        }
    }

    }






