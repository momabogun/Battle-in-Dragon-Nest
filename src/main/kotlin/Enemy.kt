open class Enemy(
    val name: String,
    var health: Int,
    var attackPower: Int,
) {
    fun enemyDead():Boolean{
        return this.health <= 0

    }
    fun takeDamage(damage:Int){
        health -= damage
        println("${this.name} took $damage damage, and has now ${this.health} HP")
        if (enemyDead()){
            println("${this.name} has been slain in Battle!!")

        }
    }




}