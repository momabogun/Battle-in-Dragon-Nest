class LittleDragon(
    name: String,
    health : Int,
    attackPower: Int
):Enemy(name,health,attackPower) {
    override fun toString(): String {
        return this.name
    }
    fun fireBolt(target: Heroes){
        println("${this.name} casted Fire Bolt!!")
        val fireBolt = attackPower * (1..2).random()
            target.takeDamage(fireBolt)
        }





}