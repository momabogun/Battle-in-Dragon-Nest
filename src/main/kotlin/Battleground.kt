import java.lang.Exception

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
        println("Welcome to the Entrance Battle!! Our Heroes facing 5 Dragons....")
        println("---------------------------------")
        Thread.sleep(1000)
        var i = 0
        while (heroes.isNotEmpty() || enemies.isNotEmpty()) {
            while (true) {
                i++
                println("ROUND $i begins:")
                println("---------------------------------")
                println()
                Thread.sleep(200)

                try {
                    println("What hero are you choosing to attack an Enemy?")
                    println(heroes)
                    var auswahlHero = readln().toInt()
                    when (auswahlHero) {
                        1 -> {
                            paladin.spells(enemies)
                            break
                        }
                        2 -> {
                            warrior.spells(enemies)
                            break
                        }
                        3 -> {
                            mage.spells(enemies)
                            break
                        }
                        4 -> {
                            priest.spells(enemies, heroes)
                            break
                        }
                        else -> throw IllegalArgumentException("Invalid hero selection!")
                    }
                } catch (e: NumberFormatException) {
                    println("Please enter a valid number!")
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
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
                println("Enemies turn:")
                Thread.sleep(2000)
                val dragon = enemies.filterIsInstance<LittleDragon>()
                dragon.random().fireBolt(heroes.random())
                Thread.sleep(3000)
                println("---------------------------------")
                println()
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
        var i = 0
        while (heroes.isNotEmpty() || boss.isNotEmpty()) {
            if (heroes.isEmpty()){
                break
            }
            while (true) {
                i++
                println("ROUND $i begins:")
                println("---------------------------------")
                println()
                Thread.sleep(200)
                try {
                    println("What hero are you choosing to attack an Enemy?")
                    println(heroes)
                    var auswahlHero = readln().toInt()
                    when (auswahlHero) {
                        1 -> {
                            paladin.spells(boss)
                            break
                        }

                        2 -> {
                            warrior.spells(boss)
                            break
                        }

                        3 -> {
                            mage.spells(boss)
                            break
                        }

                        4 -> {
                            priest.spells(boss, heroes)
                            break
                        }

                        else -> throw IllegalArgumentException("Invalid hero selection!")
                    }
                } catch (e: NumberFormatException) {
                    println("Please enter a valid number!")
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
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
                println("All Heroes are dead......\n GAME OVER")
                break
            }


        }

    }

}






