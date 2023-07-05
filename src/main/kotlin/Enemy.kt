open class Enemy(
    val name: String,
    maxHP: Int,
    var attackPower: Int,
) {
    private val maxHealth:Int = maxHP
    var health = maxHealth
        set(value) {
            field = value.coerceIn(0, maxHealth)
        }
    fun takeDamage(damage:Int){
        health -= damage
        println("${this.name} took $damage damage, and has now ${this.health} HP")
        if (health <= 0){
            println("${this.name} has been slain in Battle!!")

        }
    }




}