class Battleground {
    var heroes = mutableListOf<Heroes>(
        paladin,
        warrior,
        mage,
        priest
    )
    var enemies = mutableListOf<Enemy>(
        littleDragon,
        littleDragon,
        littleDragon,
        littleDragon
    )

    fun entranceBattle(){
        if (littleDragon.enemyDead()){
            enemies.removeAt(0)
            for (hero in heroes){
                hero.expGain()
            }
        }
    }






}