class LittleDragon(
    name: String,
    maxHP:Int,
    attackPower: Int): Enemy(name,maxHP,attackPower) {
    fun fireBolt(target: Heroes){
        println("${this.name} casted Fire Bolt!!")
        val fireBolt = attackPower * (1..2).random()
            target.takeDamage(fireBolt)
        }





}