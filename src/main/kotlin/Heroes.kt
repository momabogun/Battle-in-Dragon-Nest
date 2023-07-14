open class Heroes(
    val name: String,
    var maxHP:Int,
    var level: Int,
    var exp :Int,
    var maxMana: Int,
    var attackPower: Int,
    open var abilityPower: Int
){

    private val maxM:Int = maxMana
    var health = maxHP
        set(value) {
            field = value.coerceIn(0, maxHP)
        }
    open var mana = maxM
        set(value) {
            field = value.coerceIn(0,maxM)
        }
    

    fun takeDamage(damage:Int){
        health -= damage
        return if (health > 0){
            println("${this.name} took $damage damage, and has now ${this.health} HP")
        } else{
            println("${this.name} has been slain in Battle!!")

        }
    }
    fun expGain(){
        if (!heroDead()) {
            exp += 150
            if (exp == 300) {
                level += 1
                attackPower += 50
                maxHP += 100
                health = maxHP
                mana = maxMana

                println("Congratulation your ${this.name} has become lvl ${this.level}!")
            }
            if (exp == 450) {
                level += 1
                attackPower += 85
                maxHP += 150
                health = maxHP
                mana = maxMana
                println("Congratulation your ${this.name} has become lvl ${this.level}!")
            }
            if (exp == 750) {
                level += 1
                attackPower += 100
                maxHP += 200
                health = maxHP
                mana = maxMana
                println("Congratulation your ${this.name} has become lvl ${this.level}!")
            }
        }

    }
    open fun attack (target: Enemy){
        mana += 100
        val attack = attackPower
        target.takeDamage(attack)
    }
    fun manaUsage(cost:Int){
        mana -= cost
    }
    fun heal(heal:Int){
        health += heal
    }
    fun heroDead():Boolean{
        return this.health <= 0

    }
    open fun spells(enemies: MutableList<Enemy>) {

    }




}