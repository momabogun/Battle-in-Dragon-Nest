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

    fun entranceBattle(){
        while (heroes.isNotEmpty() || enemies.isNotEmpty()){
            for (enemy in enemies){
                if (enemy.enemyDead()){
                    enemies.remove(enemy)
                    for (hero in heroes){
                        hero.expGain()
                    }
                }
            }

        }

    }






}