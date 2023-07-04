open class Heroes(
    var name: String,
    var abilityPower: Int,
    var level: Int,
    var health: Int,
    var mana: Int,
    var attackPower: Int,
){

    fun takeDamage(damage:Int){
        health -= damage
        return if (health > 0){
            println("${this.name} took $damage damage, and has now ${this.health} HP")
        } else{
            println("${this.name} has been slain in Battle!!")

        }
    }
    fun attack(target: Enemy){
        attackPower
    }





}