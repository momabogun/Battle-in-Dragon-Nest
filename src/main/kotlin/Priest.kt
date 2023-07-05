class Priest(name: String,
    maxHP:Int,
level: Int,
exp :Int,
maxMana: Int,
attackPower: Int,
abilityPower:Int
):Heroes(name,maxHP,level,exp,maxMana,attackPower,abilityPower) {
    fun healTouch(target:Heroes){
        if (mana<200){
            println("You have no mana for this Spell!!")
        } else{
            priest.manaUsage(200)
            target.heal(200)
        }
    }
    fun lightingBolt(target: Enemy){
        if (mana < 100){
            println("You have no mana for this Spell!!")
        } else{
            priest.manaUsage(100)
            target.takeDamage(abilityPower)
        }

    }
    fun massHeal(target: MutableList<Heroes>){
        if (mana < 500){
            println("You have no mana for this Spell!!")
        } else{
            priest.manaUsage(500)
            for (hero in target){
                hero.heal(abilityPower/2)
            }
        }
    }







}
