class LittleDragon(
    name: String,
    health: Int,
    attackPower: Int): Enemy(name,health,attackPower) {
        fun fireBolt():Int{
            return attackPower * (1..2).random()
        }





}