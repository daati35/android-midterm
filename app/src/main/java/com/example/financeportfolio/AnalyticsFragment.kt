package com.example.financeportfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnalyticsFragment : Fragment() {

    private val wealthManager = WealthManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_analytics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvIncome = view.findViewById<TextView>(R.id.dg_ia_tv_income)
        val tvExpenses = view.findViewById<TextView>(R.id.dg_ia_tv_expenses)
        val tvSavings = view.findViewById<TextView>(R.id.dg_ia_tv_savings)

        parentFragmentManager.setFragmentResultListener("inputData", viewLifecycleOwner) { _, bundle ->
            val income = bundle.getDouble("income")
            val expenses = bundle.getDouble("expenses")
            val savings = wealthManager.calculateSavings(income, expenses)

            tvIncome.text = "შემოსავალი: $income"
            tvExpenses.text = "ხარჯები: $expenses"
            tvSavings.text = "დანაზოგი: %.2f".format(savings)
        }
    }
}
