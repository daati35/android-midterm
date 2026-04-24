package com.example.financeportfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etIncome = view.findViewById<EditText>(R.id.dg_ia_et_income)
        val etExpenses = view.findViewById<EditText>(R.id.dg_ia_et_expenses)
        val btnSave = view.findViewById<Button>(R.id.dg_ia_btn_save)

        btnSave.setOnClickListener {
            val incomeText = etIncome.text.toString()
            val expensesText = etExpenses.text.toString()

            if (incomeText.isEmpty()) {
                etIncome.error = "შეიყვანეთ შემოსავალი"
                return@setOnClickListener
            }
            if (expensesText.isEmpty()) {
                etExpenses.error = "შეიყვანეთ ხარჯები"
                return@setOnClickListener
            }

            val result = Bundle().apply {
                putDouble("income", incomeText.toDouble())
                putDouble("expenses", expensesText.toDouble())
            }

            parentFragmentManager.setFragmentResult("inputData", result)
        }
    }
}
