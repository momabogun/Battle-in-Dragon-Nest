open class Heroes(
    val name: String,
    var abilityPower: Int,
    var level: Int,
    var mana: Int,
    var attackPower: Int,
){
    open var health: Int = 1500

    fun takeDamage(damage:Int){
        health -= damage
        return if (health > 0){
            println("${this.name} took $damage damage, and has now ${this.health} HP")
        } else{
            println("${this.name} has been slain in Battle!!")

        }
    }





}