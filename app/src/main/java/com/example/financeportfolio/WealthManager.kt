package com.example.financeportfolio

class WealthManager {

    // K = (სახელის ასოების რაოდენობა + გვარის ასოების რაოდენობა) / დაბადების რიცხვი
    // K = (5 + 5) / 16 = 0.625
    private val K = 0.625

    fun calculateSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * K
    }
}
