package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalcButton

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var displayValue by remember { mutableStateOf("0") }
    var currentOperator by remember { mutableStateOf<String?>(null) }
    var operand1 by remember { mutableStateOf<String?>(null) }
    var operand2 by remember { mutableStateOf<String?>(null) }


    fun onNumberClick(number: String) {
        if (displayValue == "0") {
            displayValue = number
        } else {
            displayValue += number
        }
    }


    fun onOperatorClick(operator: String) {
        operand1 = displayValue
        currentOperator = operator
        displayValue = "0"
    }


    fun onEqualsClick() {
        operand2 = displayValue
        val result = when (currentOperator) {
            "+" -> (operand1?.toDoubleOrNull() ?: 0.0) + (operand2?.toDoubleOrNull() ?: 0.0)
            "-" -> (operand1?.toDoubleOrNull() ?: 0.0) - (operand2?.toDoubleOrNull() ?: 0.0)
            "*" -> (operand1?.toDoubleOrNull() ?: 0.0) * (operand2?.toDoubleOrNull() ?: 0.0)
            "/" -> if ((operand2?.toDoubleOrNull() ?: 1.0) != 0.0) {
                (operand1?.toDoubleOrNull() ?: 0.0) / (operand2?.toDoubleOrNull() ?: 1.0)
            } else {
                "Error"
            }
            else -> "0"
        }


        displayValue = if (result is Double) {
            String.format("%.8f", result).trimEnd('0').trimEnd('.')
        } else {
            result.toString()
        }


        operand1 = null
        operand2 = null
        currentOperator = null
    }


    fun onClearClick() {
        displayValue = "0"
        operand1 = null
        operand2 = null
        currentOperator = null
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp)
                .height(100.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = displayValue,
                fontSize = 48.sp,
                color = Color.Black,
                textAlign = TextAlign.End
            )
        }


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "7",
                onClick = { onNumberClick("7") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "8",
                onClick = { onNumberClick("8") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "9",
                onClick = { onNumberClick("9") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "+",
                isOperation = true,
                onClick = { onOperatorClick("+") }
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "4",
                onClick = { onNumberClick("4") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "5",
                onClick = { onNumberClick("5") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "6",
                onClick = { onNumberClick("6") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "-",
                isOperation = true,
                onClick = { onOperatorClick("-") }
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "1",
                onClick = { onNumberClick("1") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "2",
                onClick = { onNumberClick("2") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "3",
                onClick = { onNumberClick("3") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "*",
                isOperation = true,
                onClick = { onOperatorClick("*") }
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "C",
                onClick = { onClearClick() }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "0",
                onClick = { onNumberClick("0") }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "=",
                isOperation = true,
                onClick = { onEqualsClick() }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "/",
                isOperation = true,
                onClick = { onOperatorClick("/") }
            )
        }
    }
}
