class Paladin(
    name: String,
    abilityPower: Int,
    level: Int,
    mana: Int,
    attackPower: Int,
    ): Heroes(name,abilityPower,level,mana,attackPower) {
    val maxHealth:Int = 2500
        override var health = maxHealth
            set(value) {
                field = value.coerceIn(0, maxHealth)
            }

    fun judgment(): Int {
        return attackPower + ((abilityPower / 2) * level)
    }
    fun healOfRighteous(){
        if (mana <= 0){
            println("You have no mana for this Spell!!")
        } else if (this.health >= this.maxHealth){
            println("You have full HP!!")

            }else {
                this.mana -= 100
                val heal = 200
                this.health += heal
            println("${this.name} has ${this.health}/${this.maxHealth}")
            }
        }

    }