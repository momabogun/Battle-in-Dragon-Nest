import java.lang.Exception

class Battleground (var name: String){
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
        println("Welcome to the ${this.name}!! Our Heroes facing 5 Dragons....")
        println("---------------------------------")
        Thread.sleep(1000)
        var i = 1
        while (heroes.isNotEmpty() || enemies.isNotEmpty()) {
            while (true) {
                println()
                println("---------------------------------")
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
                            if (paladin.heroDead()){
                                paladin.spells(enemies)
                                Thread.sleep(1000)
                                continue
                            }else {
                                paladin.spells(enemies)
                                break
                            }
                        }
                        2 -> {
                            if (warrior.heroDead()){
                                warrior.spells(enemies)
                                Thread.sleep(1000)
                                continue
                            }else{
                                warrior.spells(enemies)
                                break
                            }
                        }
                        3 -> {
                            if (mage.heroDead()){
                                mage.spells(enemies)
                                Thread.sleep(1000)
                                continue
                            }else{
                                mage.spells(enemies)
                                break
                            }
                        }
                        4 -> {
                            if (priest.heroDead()){
                                priest.spells(enemies,heroes)
                                Thread.sleep(1000)
                                continue
                            }else {
                                priest.spells(enemies, heroes)
                                break
                            }
                        }
                        else -> throw IllegalArgumentException("Invalid hero selection!")
                    }
                } catch (e: NumberFormatException) {
                    println("Please enter a valid number!")
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
            for (enemy in enemies){
                if (enemy.enemyDead()){
                    for(hero in heroes){
                        hero.expGain()
                    }
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
                println("---------------------------------")
                println("Enemies turn:")
                Thread.sleep(2000)
                val dragon = enemies.filterIsInstance<LittleDragon>()
                dragon.random().fireBolt(heroes.random())
                i++
                Thread.sleep(2000)
                println("---------------------------------")
                println()
            } else {
                println("You won the entrance battle. Congratulations!!")
                Thread.sleep(2000)
                println(".........")
                println("But new foe is closing near")
                Thread.sleep(1000)
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
        if (heroes.isNotEmpty()) {
            println("++++++ BOSS BATTLE ++++++")
            println("---------------------------------")
            println("Boss has arrived in ${this.name}!! Our Heroes facing mighty $bossDragon")
            println("---------------------------------")
        } else {
            println(".....")
        }
        Thread.sleep(1000)
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
                            if (paladin.heroDead()){
                                paladin.spells(boss)
                                Thread.sleep(1000)
                                continue
                            }else {
                                paladin.spells(boss)
                                break
                            }
                        }

                        2 -> {
                            if (warrior.heroDead()){
                                warrior.spells(boss)
                                Thread.sleep(1000)
                                continue
                            }else{
                                warrior.spells(boss)
                                break
                            }
                        }

                        3 -> {
                            if (mage.heroDead()){
                                mage.spells(boss)
                                Thread.sleep(1000)
                                continue
                            }else{
                                mage.spells(boss)
                                break
                            }
                        }

                        4 -> {
                            if (priest.heroDead()){
                                priest.spells(boss,heroes)
                                Thread.sleep(1000)
                                continue
                            }else {
                                priest.spells(boss, heroes)
                                break
                            }
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
                println("---------------------------------")
                println("$bossDragon turn:")
                Thread.sleep(2000)
                if (bossDragon.health >= 1500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireBreath(heroes.random())
                    Thread.sleep(2000)
                }
                if (bossDragon.health < 500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().cataclysm(heroes.random())
                    Thread.sleep(2000)
                }
                else if (bossDragon.health < 1000) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireFromWithin(heroes)
                    dragon.random().fireStrength()
                    Thread.sleep(2000)
                }
                else if (bossDragon.health < 1500) {
                    var dragon = boss.filterIsInstance<Dragon>()
                    dragon.random().fireBreath(heroes.random())
                    dragon.random().fireStrength()
                    Thread.sleep(2000)
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
    fun menu(){
        println("-------------------------")
        println("Welcome in the 'Battle in Dragon' Nest RPG game")
        while (true) {
            println("-------------------------")
            println()
            println("[1] Tutorial\n[2] New Game\n[3] Log Out")
            try {
                var auswahl = readln().toInt()
                when (auswahl) {
                    1 -> {
                        println("Rundenbasierte Kämpfe, du und der Feind abwechselnd Aktionen ausführen.\nSie haben 4 Helden: Warrior, Paladin, Mage und \nPriest, die alle verschiedene spells haben\nSie kämpfen zuerst mit Drahe(Firezilla) minions und wenn \nsie gewinne gegen die minions dann kommt die Drahe.")
                        Thread.sleep(2000)
                        continue
                    }

                    2 -> {
                        entranceBattle()
                        bossBattle()
                        break
                    }

                    3 -> {
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

    }

}






