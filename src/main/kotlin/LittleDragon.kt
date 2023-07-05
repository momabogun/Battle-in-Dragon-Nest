class LittleDragon(
    name: String,
    maxHP:Int,
    attackPower: Int): Enemy(name,maxHP,attackPower) {
    fun fireBolt():Int{
        println("${this.name} casted Fire Bolt!!")
            return attackPower * (1..2).random()
        }





}