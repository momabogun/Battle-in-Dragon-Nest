class LittleDragon(
    name: String,
    attackPower: Int): Enemy(name,attackPower) {
    val maxHealth:Int = 2500
    override var health = maxHealth
        set(value) {
            field = value.coerceIn(0, maxHealth)
        }

    fun fireBolt():Int{
            return attackPower * (1..2).random()
        }





}