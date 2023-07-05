class Paladin(
    name: String,
    maxHP: Int,
    level: Int,
    exp :Int,
    maxMana: Int,
    attackPower: Int,
    ): Heroes(name,maxHP,level,exp,maxMana,attackPower) {
        private var abilityPower = 100*level

    fun judgment(): Int {
        println("${this.name} casted Judgment!!")
        return attackPower + ((abilityPower / 2) * level)
    }
    fun healOfRighteous(){
        if (mana <= 0){
            println("You have no mana for this Spell!!")
        } else if (this.health == this.maxHealth){
            this.mana -= 100
            println("You have full HP!!")

            }else {
                this.mana -= 100
                val heal = 200
                this.health += heal
            println("${this.name} has ${this.health}/${this.maxHealth}")
            }
        }


    }