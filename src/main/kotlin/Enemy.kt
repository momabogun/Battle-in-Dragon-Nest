open class Enemy(
    val name: String,
    var health: Int,
    var attackPower: Int
) {
    fun takeDamage(damage:Int){
        health -= damage
        println("${this.name} took $damage damage, and has now ${this.health} HP")
        if (health <= 0){
            println("${this.name} has been slain in Battle!!")
        }
    }




}