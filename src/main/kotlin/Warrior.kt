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
        return "\n[2]${this.name}(Warrior, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }

    override var mana = 0
    fun bladeStorm(target: MutableList<Enemy>){
        if (mana < 100) {
            println("You have no mana for this Spell!!")
        } else {
            warrior.manaUsage(100)
            println("${this.name} casted Blade Storm!!")
            val bladeStorm = attackPower/2
            for (enemy in target){
                enemy.takeDamage(bladeStorm)
            }
        }
    }
    fun mortalStrike(target: Enemy){
        if (mana < 100){
            println("You have no mana for this Spell!!")
        } else{
            warrior.manaUsage(100)
            println("${this.name} casted Mortal Strike!!")
            val mortalStrike = attackPower*2
            target.takeDamage(mortalStrike)
        }
    }
    fun execute(target: Enemy){
        if (mana < 300){
            println("You have no mana for this Spell!!")
        } else {
            warrior.manaUsage(300)
            println("ULTIMATE.${this.name} casted Execute!!")
            val execute = (0.2 * target.health).toInt()
            println("Execute did $execute DMG")
            target.takeDamage(execute)
        }
    }








}