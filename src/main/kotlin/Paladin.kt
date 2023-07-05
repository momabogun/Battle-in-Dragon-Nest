class Paladin(
    name: String,
    maxHP: Int,
    level: Int,
    exp :Int,
    maxMana: Int,
    attackPower: Int,
    abilityPower:Int

    ): Heroes(name,maxHP,level,exp,maxMana,attackPower, abilityPower) {
    override fun toString(): String {
        return "${this.name} ${this.maxHP} ${this.level} ${this.exp} ${this.maxMana} ${this.mana}"
    }

    fun judgment(target: Enemy,) {
        println("Paladin mana: ${this.mana}")
        if (mana < 100) {
            println("You have no mana for this Spell!!")
        } else {
            paladin.manaUsage(100)
            println("${this.name} casted Judgment!!")
            val judgment = attackPower + ((abilityPower / 2) * level)
            target.takeDamage(judgment)
        }
    }
    fun healOfRighteous(){
        if (mana < abilityPower){
            println("You have no mana for this Spell!!")
        } else if (this.health == this.maxHealth){
            println("You have already full HP!!")

            }else {
            paladin.manaUsage(abilityPower)
                paladin.heal(abilityPower)
            println("${this.name} has ${this.health}/${this.maxHealth}")
            }
        }
    fun wingsOfJustice(){
        if (mana < 300) {
            println("You have no mana for this Spell!!")
        } else{
            paladin.manaUsage(300)
            println("ULTIMATE. ${this.name} has now new form Wings of Justice")
            abilityPower *= 4
            attackPower *= 2
            maxHP += 300
            maxMana += 200

        }

    }


    }