package com.daniel.budgetplanner.dashboard.domain.model

enum class Category(val value: String) {
    FOOD_EXPENSES("Alimentación"),
    ANT_EXPENSES("Gastos hormiga"),
    SERVICES_EXPENSES("Servicios Públicos"),
    HEALTH_EXPENSES("Salud"),
    OUTFIT_EXPENSES("Vestimenta"),
    TRANSPORTATION_EXPENSES("Transporte"),
    MONTHLY_INCOMES("Ingresos Mensuales"),
    OTHER_INCOMES("Ingresos varios")
}
