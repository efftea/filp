// Автомобиль
open class Car(val brand: String, val model: String, val year: Int, val dailyRate: Double) {
    fun displayInfo() {
        println("$brand $model, Год: $year, Дневная норма: $dailyRate")
    }
}

// Легковой автомобиль
class PassengerCar(brand: String, model: String, year: Int, dailyRate: Double, val passengerCapacity: Int) : Car(brand, model, year, dailyRate) {
    fun displayPassengerCapacity() {
        println("Пассажировместимость: $passengerCapacity")
    }
}

// Грузовой автомобиль
class Truck(brand: String, model: String, year: Int, dailyRate: Double, val cargoCapacity: Double) : Car(brand, model, year, dailyRate) {
    fun displayCargoCapacity() {
        println("Грузоподъемность: $cargoCapacity")
    }
}