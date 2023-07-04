class Paladin(
    name: String,
    abilityPower: Int,
    level: Int,
    health: Int,
    mana: Int,
    attackPower: Int,
    ): Heroes(name,abilityPower,level,health,mana,attackPower) {
    fun judgment(): Int {
        return attackPower + ((abilityPower / 2) * level)
    }
    fun healOfRighteous(health: Int){
        val heal = 200
        health + heal
    }

}