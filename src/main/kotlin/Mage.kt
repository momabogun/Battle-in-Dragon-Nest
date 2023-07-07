class Mage(
    name: String,
maxHP:Int,
level: Int,
exp :Int,
maxMana: Int,
attackPower: Int,
abilityPower:Int
):Heroes(name,maxHP,level,exp,maxMana,attackPower,abilityPower) {
    override fun toString(): String {
        return "\n[3] -> ${this.name}(Mage, lvl: ${this.level},exp: ${this.exp})\n⚔️ ${this.attackPower} Attack Power\n🪄 ${this.abilityPower} Ability Power\n❤️ ${this.health}/${this.maxHP} HP\n🔹 ${this.mana}/${this.maxMana} Mana"
    }

    fun frostBolt(target: Enemy){
        if (mana<100){
            println("You have no Mana for this spell")
        } else{
            mage.manaUsage(100)
            val frostBolt = abilityPower * (1..2).random()
            target.takeDamage(frostBolt)
        }

    }
    fun rainOfFire(target: MutableList<Enemy>){
        if (mana <200){
            println("You have no Mana for this spell")
        } else{
            mage.manaUsage(200)
            println("${this.name} casted Rain of Fire!!")
            val rainOfFire = abilityPower/2
            for (enemy in target){
                enemy.takeDamage(rainOfFire)
            }

        }
    }
    fun plasmaBeam(target: Enemy){
        if (mana< 500){
            println("You have no Mana for this spell")
        } else {
            mage.manaUsage(500)
            println("Ultimate: ${this.name} casted Plasma Beam on $target ")
            val plasmaBeam= abilityPower * (2..5).random()
            target.takeDamage(plasmaBeam)
        }
    }





}