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
                        println(paladin)
                        println("\n[0] -> Back\n[1] -> Attack with sword \n[2] -> Judgment(costs 100 mana)\n[3] -> Heal Of Righteous(costs ${paladin.abilityPower})\n[4] -> Wings of Justice (costs 300 mana)")
                        var auswahl = readln().toInt()
                        when (auswahl) {
                            0 -> auswahlHero
                            1 -> {
                                paladin.attack(enemies.random())
                            }

                            2 -> {
                                paladin.judgment(enemies.random())
                            }

                            3 -> {
                                paladin.healOfRighteous()
                            }

                            4 -> paladin.wingsOfJustice()
                        }

                    }

                    2 -> {
                        println(warrior)
                        println("\n[0] -> Back\n[1] -> Attack with sword \n[2] -> Bladestorm (costs 100 mana)\n[3] -> Mortal Strike (costs 100 mana)\n[4] -> Execute (costs 300 mana)")
                        var auswahl = readln().toInt()
                        when (auswahl) {
                            0 -> auswahlHero
                            1 -> {
                                warrior.attack(enemies.random())
                            }

                            2 -> {
                                warrior.bladeStorm(enemies)
                            }

                            3 -> {
                                warrior.mortalStrike(enemies.random())
                            }

                            4 -> warrior.execute(enemies.random())
                        }


                    }
                }

            val newListEnemy = mutableListOf<Enemy>()
            for (enemy in enemies) {
                if (!enemy.enemyDead()) {
                    newListEnemy.add(enemy)
                }
                for (hero in heroes) {
                    hero.expGain()
                }
            }
            enemies.clear()
            enemies.addAll(newListEnemy)
            if (enemies.isNotEmpty()) {
                var dragon = enemies.filterIsInstance<LittleDragon>()
                dragon.random().fireBolt(heroes.random())
            }


        }
    }

    }






