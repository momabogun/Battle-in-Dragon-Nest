class Warrior(
    name: String,
    maxHP:Int,
    level: Int,
    exp :Int,
    maxMana: Int,
    attackPower: Int,
    override var abilityPower: Int = 0
    ):Heroes(name,maxHP,level,exp,maxMana,attackPower,abilityPower) {
    override fun toString(): String {
        return "${this.name} ${this.maxHP} ${this.level} ${this.exp} ${this.maxMana} ${this.mana}"
    }

    override var mana = 0
    fun bladeStorm(target: MutableList<Enemy>){
        warrior.manaUsage(100)
        if (mana < 100) {
            println("You have no mana for this Spell!!")
        } else {
            println("${this.name} casted Blade Storm!!")
            val bladeStorm = attackPower/2
            for (enemy in target){
                enemy.takeDamage(bladeStorm)
            }
        }
    }
    fun mortalStrike(target: Enemy){
        warrior.manaUsage(100)
        if (mana < 100){
            println("You have no mana for this Spell!!")
        } else{
            println("${this.name} casted Mortal Strike!!")
            val mortalStrike = attackPower*2
            target.takeDamage(mortalStrike)
        }
    }
    fun execute(target: Enemy){
        warrior.manaUsage(200)
        if (mana < 200){
            println("You have no mana for this Spell!!")
        } else {
            println("ULTIMATE.${this.name} casted Execute!!")
            val execute = (0.2 * target.health).toInt()
            println("Execute did $execute DMG")
            target.takeDamage(execute)
        }
    }








}